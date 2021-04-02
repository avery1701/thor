package com.advancedpwr.record.descriptor;

import java.util.Iterator;

public class JavaCollectionObjectDescriptor extends JavaObjectDescriptor
		implements CollectionObjectDescriptor
{
	public JavaCollectionObjectDescriptor( Object object )
	{
		super( object );
	}

	@Override
	public Iterator<ObjectDescriptor> iterator()
	{
		return new JavaCollectionObjectIterator( subject() );
	}

}
