package com.advancedpwr.record.descriptor;

import java.util.AbstractMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class JavaMapObjectIterator implements Iterator<Entry<ObjectDescriptor, ObjectDescriptor>>
{

	protected Set<Entry<Object, Object>> fieldSubject;
	protected Iterator<Entry<Object, Object>> fieldIterator;

	public JavaMapObjectIterator( Map<Object, Object> map )
	{
		setSubject( map.entrySet() );
		setIterator( subject().iterator() );
	}

	protected Set<Entry<Object, Object>> subject()
	{
		return fieldSubject;
	}

	protected void setSubject( Set<Entry<Object, Object>> subject )
	{
		fieldSubject = subject;
	}

	protected Iterator<Entry<Object, Object>> getIterator()
	{
		return fieldIterator;
	}

	protected void setIterator( Iterator<Entry<Object, Object>> iterator )
	{
		fieldIterator = iterator;
	}

	protected Entry<ObjectDescriptor, ObjectDescriptor> createNextEntry()
	{
		Entry<Object, Object> entry = getIterator().next();
		ObjectDescriptor key = new JavaObjectDescriptor( entry.getKey() );
		ObjectDescriptor value = new JavaObjectDescriptor( entry.getValue() );
		Entry<ObjectDescriptor, ObjectDescriptor> outEntry = new AbstractMap.SimpleEntry<ObjectDescriptor, ObjectDescriptor>(
				key, value );
		return outEntry;
	}

	@Override
	public boolean hasNext()
	{
		return getIterator().hasNext();
	}

	@Override
	public Entry<ObjectDescriptor, ObjectDescriptor> next()
	{
		return createNextEntry();
	}

}
