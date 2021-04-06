package com.advancedpwr.record.inspect;

import java.util.Map;
import java.util.Map.Entry;

import com.advancedpwr.record.InstanceTree;
import com.advancedpwr.record.descriptor.JavaClassDescriptor;
import com.advancedpwr.record.descriptor.MapObjectDescriptor;
import com.advancedpwr.record.descriptor.ObjectDescriptor;

public class MapInspector extends Inspector
{

	public void inspect( InstanceTree inTree )
	{
		setInstanceTree( inTree );
		addMapAccessPaths();
	}

	protected void addMapAccessPaths()
	{
		if ( isMap() )
		{
			MapObjectDescriptor map = getObject().asMapDescriptor();
			for ( Entry<ObjectDescriptor, ObjectDescriptor> entry : map )
			{
				MapPutPath path = new MapPutPath();
				path.setKeyTree( createInstanceTree( entry.getKey() ) );
				path.setValueTree( createInstanceTree( entry.getValue() ) );
				path.setInstanceName( currentInstanceName() );
				addAccessPath( path );
			}
		}
	}

	protected boolean isMap()
	{
		JavaClassDescriptor descriptor = new JavaClassDescriptor( Map.class );
		return objectClass().isAssignableFrom( descriptor );
	}
}
