package com.advancedpwr.record.inspect;

import java.util.Collection;

import com.advancedpwr.record.InstanceTree;
import com.advancedpwr.record.descriptor.CollectionObjectDescriptor;
import com.advancedpwr.record.descriptor.JavaClassDescriptor;
import com.advancedpwr.record.descriptor.ObjectDescriptor;

public class CollectionInspector extends Inspector
{

	public void inspect( InstanceTree inTree )
	{
		setInstanceTree( inTree );
		addCollectionAccessPaths();
	}

	protected void addCollectionAccessPaths()
	{
		if ( isCollection() )
		{
			CollectionObjectDescriptor collection = getObject().asCollectionDescriptor();
			for ( ObjectDescriptor member : collection )
			{
				MultiPath path = new MultiPath();
				path.setTree( createInstanceTree( member ) );
				path.setInstanceName( currentInstanceName() );
				addAccessPath( path );
			}
		}
	}

	protected boolean isCollection()
	{
		JavaClassDescriptor descriptor = new JavaClassDescriptor( Collection.class );
		return objectClass().isAssignableFrom( descriptor );
	}

}
