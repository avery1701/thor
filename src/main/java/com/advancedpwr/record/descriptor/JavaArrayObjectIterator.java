package com.advancedpwr.record.descriptor;

import java.lang.reflect.Array;

public class JavaArrayObjectIterator extends JavaObjectDescriptorIterator
{

	public JavaArrayObjectIterator( Object subject )
	{
		super( subject );
	}

	protected JavaObjectDescriptor getDescriptor( int index )
	{
		return new JavaObjectDescriptor( Array.get( subject(), index ) );
	}

}
