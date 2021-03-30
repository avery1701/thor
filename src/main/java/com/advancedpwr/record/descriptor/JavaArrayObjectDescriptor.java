package com.advancedpwr.record.descriptor;

import java.util.Arrays;
import java.util.Iterator;

public class JavaArrayObjectDescriptor extends JavaObjectDescriptor implements ArrayObjectDescriptor
{

	public JavaArrayObjectDescriptor( Object object )
	{
		super( object );
	}

	@Override
	public Iterator<ObjectDescriptor> iterator()
	{
		return Arrays.asList( super ).iterator();
	}

}
