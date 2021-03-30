package com.advancedpwr.record.inspect;

import com.advancedpwr.record.InstanceTree;
import com.advancedpwr.record.descriptor.ArrayObjectDescriptor;
import com.advancedpwr.record.descriptor.ObjectDescriptor;

public class ArrayInspector extends Inspector
{

	public void inspect( InstanceTree inTree )
	{
		setInstanceTree( inTree );
		addArrayAccessPaths();
	}

	protected void addArrayAccessPaths()
	{
		if ( objectClass().isArray() )
		{
			ArrayObjectDescriptor array = getObject().asArrayObjectDescriptor();
			for ( ObjectDescriptor member : array )
			{
				MultiPath path = new MultiPath();
				path.setTree( createInstanceTree( member ) );
				path.setInstanceName( objectClass().asArrayDescriptor().getComponentType().getClassName() );
				addAccessPath( path );
			}
		}
	}
}
