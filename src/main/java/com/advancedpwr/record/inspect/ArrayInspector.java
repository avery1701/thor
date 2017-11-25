package com.advancedpwr.record.inspect;

import java.lang.reflect.Array;

import com.advancedpwr.record.InstanceTree;

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
			int length = Array.getLength( getObject() );
			for ( int i = 0; i < length; i++ )
			{
				Object member = Array.get( getObject(), i );
				MultiPath path = new MultiPath();
				path.setTree( createInstanceTree( member ) );
				path.setInstanceName( objectClass().getComponentType().getSimpleName() );
				addAccessPath( path );
			}
		}
	}
}
