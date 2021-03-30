package com.advancedpwr.record.descriptor;

import java.util.List;

public class JavaObjectDescriptor implements ObjectDescriptor
{
	protected Object fieldSubject;

	public Object subject()
	{
		return fieldSubject;
	}

	public void setSubject( Object object )
	{
		fieldSubject = object;
	}

	public JavaObjectDescriptor( Object object )
	{
		setSubject( object );
	}

	@Override
	public ClassDescriptor getClassDescriptor()
	{
		return new JavaClassDescriptor( subject().getClass() );
	}

	@Override
	public List<MethodDescriptor> getMethods()
	{
		return getClassDescriptor().getMethods();
	}

	@Override
	public boolean isArray()
	{
		return subject().getClass().isArray();
	}

	@Override
	public JavaArrayObjectDescriptor asArrayObjectDescriptor()
	{
		return new JavaArrayObjectDescriptor( subject() );
	}
}
