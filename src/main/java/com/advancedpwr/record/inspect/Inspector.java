package com.advancedpwr.record.inspect;

import com.advancedpwr.record.AccessPath;
import com.advancedpwr.record.InstanceTree;
import com.advancedpwr.record.descriptor.ClassDescriptor;
import com.advancedpwr.record.descriptor.ObjectDescriptor;

public abstract class Inspector
{

	protected InstanceTree fieldInstanceTree;

	public abstract void inspect( InstanceTree inTree );

	protected ClassDescriptor objectClass()
	{
		return getInstanceTree().objectClass();
	}

	protected ObjectDescriptor getObject()
	{
		return getInstanceTree().getObject();
	}

	protected InstanceTree getInstanceTree()
	{
		return fieldInstanceTree;
	}

	protected void setInstanceTree( InstanceTree instanceTree )
	{
		fieldInstanceTree = instanceTree;
	}

	protected void debug( String inString )
	{
		//		System.out.println( inString );
	}

	protected void addAccessPath( AccessPath inPath )
	{
		getInstanceTree().getAccessPaths().add( inPath );
	}

	protected InstanceTree createInstanceTree( ObjectDescriptor result )
	{
		return getInstanceTree().createInstanceTree( result );
	}

	protected String currentInstanceName()
	{
		return getInstanceTree().currentInstanceName();
	}

}
