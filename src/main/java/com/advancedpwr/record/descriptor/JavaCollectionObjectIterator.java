package com.advancedpwr.record.descriptor;

import java.util.Collection;

public class JavaCollectionObjectIterator extends JavaObjectDescriptorIterator
{
	public JavaCollectionObjectIterator( Object subject )
	{
		super( subject );
	}

	protected ObjectDescriptor getDescriptor( int index )
	{
		return new JavaObjectDescriptor( ( (Collection<?>) subject() ).toArray()[ index ] );
	}
}
