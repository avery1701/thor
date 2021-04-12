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
		if(subject().getClass().isArray()) {
			return new JavaArrayClassDescriptor( subject().getClass() );
		}
		return new JavaClassDescriptor( subject().getClass() );			
	}

	@Override
	public List<MethodDescriptor> getMethods()
	{
		return getClassDescriptor().getMethods();
	}

	/**
	 * 
	 * Safely (no need to change method access) invokes a method on this object.
	 * 
	 */
	@Override
	public ObjectDescriptor invokeMethod( MethodDescriptor method )
	{
		try
		{
			method.setAccessible( true );
			//TODO: method.invoke(subject()) could return null, will JavaObjectDescriptor handle that, or should we return null?
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

	@Override
	public MapObjectDescriptor asMapDescriptor()
	{
		return new JavaMapObjectDescriptor(subject());
	}

}
