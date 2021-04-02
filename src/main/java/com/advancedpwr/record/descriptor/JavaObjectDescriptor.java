package com.advancedpwr.record.descriptor;

import java.util.List;

import com.advancedpwr.record.RecorderException;

/**
 * 
 * @author Elijah Hopp, github.mrzeusthecoder@gmail.com. Created: Apr 1, 2021
 *
 */
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

	//FIXME: Is this a dirty way of managing to invoke the method backend-independent?
	/**
	 * 
	 * Safely (no need to change method access) invokes a method on this object.
	 * 
	 */
	@Override
	public ObjectDescriptor invokeMethod( MethodDescriptor method )
	{
		if(!getClassDescriptor().getMethods().contains( method )) {
			throw new RecorderException("Method doens't exist on this object");
		}
		
		try
		{
			method.setAccessible( true );
			return new JavaObjectDescriptor( method.invoke(subject()) );
		}
		catch ( Exception e )
		{
			throw new RecorderException( e );
		}
	}

	@Override
	public boolean isArray()
	{
		return subject().getClass().isArray();
	}

	@Override
	public ArrayObjectDescriptor asArrayDescriptor()
	{
		return new JavaArrayObjectDescriptor( subject() );
	}

	//FIXME: Acceptable? Not really fantastic, but how else can I do it?
	@Override
	public CollectionObjectDescriptor asCollectionDescriptor()
	{
		return new JavaCollectionObjectDescriptor( subject() );
	}

}
