package com.advancedpwr.generate;

import static com.advancedpwr.record.ClassWriter.SPACE;

import java.lang.reflect.Parameter;
import java.util.List;

import com.advancedpwr.record.ClassWriter;

public class ListInstanceWriter extends BaseInstanceWriter
{
	

	public ListInstanceWriter( ClassWriter inWriter )
	{
		super( inWriter );
	}

	@Override
	public boolean writeInstance( Class inClass )
	{

		if ( isList() )
		{
			writeLine( instanceType() + SPACE + instanceName() + " = new ArrayList<>()" );
			return true;
		}
		return false;
	}

	protected boolean isList()
	{
		return List.class.isAssignableFrom( getInstanceClass() );
	}

	@Override
	public boolean writeInstance( Parameter param )
	{
		setInstanceClass( param.getType() );
		if ( isList() )
		{
			writeLine( instanceType() + SPACE + param.getName() + " = new ArrayList<>()" );
			return true;
		}
		return false;
	}

}
