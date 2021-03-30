package com.advancedpwr.record.descriptor;

import java.util.Set;

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
	public Set<MethodDescriptor> getMethods()
	{
		return getClassDescriptor().getMethods();
	}

	@Override
	public JavaArrayObjectDescriptor asArrayObjectDescriptor()
	{
		return new JavaArrayObjectDescriptor(subject());
	}

}
