package com.advancedpwr.record.descriptor;

import java.lang.reflect.Array;
import java.util.Iterator;

public class JavaArrayObjectIterator implements Iterator<ObjectDescriptor>
{
	protected Object fieldSubject;
	protected int fieldIndex;

	protected Object subject()
	{
		return fieldSubject;
	}

	protected void setSubject( Object subject )
	{
		fieldSubject = subject;
	}

	protected int getIndex()
	{
		return fieldIndex;
	}

	protected void setIndex( int index )
	{
		fieldIndex = index;
	}

	public JavaArrayObjectIterator( Object subject )
	{
		setSubject( subject );
	}

	@Override
	public boolean hasNext()
	{
		return Array.getLength( subject() ) > getIndex();
	}

	@Override
	public ObjectDescriptor next()
	{
		JavaObjectDescriptor descriptor = getDescriptor(getIndex());
		setIndex( getIndex() + 1 );
		return descriptor;
		
	}

	protected JavaObjectDescriptor getDescriptor( int index )
	{
		return new JavaObjectDescriptor( Array.get( subject(), index ) );
	}

}
