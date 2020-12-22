package com.advancedpwr.generate;

import com.advancedpwr.record.ClassWriter;
import com.advancedpwr.record.ClassWriterDelagate;

public abstract class BaseInstanceWriter extends ClassWriterDelagate implements InstanceWriter
{
	
	protected Class fieldInstanceClass;
	
	public Class getInstanceClass()
	{
		return fieldInstanceClass;
	}

	public void setInstanceClass( Class instanceClass )
	{
		fieldInstanceClass = instanceClass;
	}
	
	public BaseInstanceWriter( ClassWriter inWriter )
	{
		setClassWriter( inWriter );
	}
	
	protected String instanceType()
	{
		return getInstanceClass().getSimpleName();
	}

	protected String instanceName()
	{
		return instanceType().toLowerCase();
	}
	
	protected String fieldInstanceName;
	
	public String getInstanceName()
	{
		if ( fieldInstanceName == null )
		{
			fieldInstanceName = instanceName();
		}
		return fieldInstanceName;
	}

	public void setInstanceName( String instanceName )
	{
		fieldInstanceName = instanceName;
	}
}
