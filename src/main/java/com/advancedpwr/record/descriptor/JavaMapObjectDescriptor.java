package com.advancedpwr.record.descriptor;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.advancedpwr.record.RecorderException;

public class JavaMapObjectDescriptor extends JavaObjectDescriptor implements MapObjectDescriptor
{

	public JavaMapObjectDescriptor( Object object )
	{
		super( object );
	}

	@SuppressWarnings( "unchecked" )
	@Override
	public Iterator<Entry<ObjectDescriptor, ObjectDescriptor>> iterator()
	{
		if ( subject() instanceof Map<?, ?> )
		{
			return new JavaMapObjectIterator( (Map<Object, Object>) subject() );
		}
		else
		{
			throw new RecorderException( "bad stuff" );
		}
	}

}
