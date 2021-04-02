package com.advancedpwr.record.descriptor;

import java.lang.reflect.Array;
import java.util.Iterator;

public abstract class JavaObjectDescriptorIterator implements Iterator<ObjectDescriptor>
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

	public JavaObjectDescriptorIterator( Object subject )
	{
		setSubject( subject );
	}

	protected abstract ObjectDescriptor getDescriptor( int index );

	public boolean hasNext()
	{
		return Array.getLength( subject() ) > getIndex();
	}

	public ObjectDescriptor next()
	{
		ObjectDescriptor descriptor = getDescriptor( getIndex() );
		setIndex( getIndex() + 1 );
		return descriptor;

	}
}
