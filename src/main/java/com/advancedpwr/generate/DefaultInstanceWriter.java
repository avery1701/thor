package com.advancedpwr.generate;

import static com.advancedpwr.record.ClassWriter.SPACE;

import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;

import com.advancedpwr.record.ClassWriter;

public class DefaultInstanceWriter extends BaseInstanceWriter
{


	public DefaultInstanceWriter( ClassWriter inWriter )
	{
		super( inWriter );
	}
	
	public boolean writeInstance( Class inClass )
	{
		setInstanceClass( inClass );
		if ( hasDefaultConstructor() )
		{
			writeLine( instanceType() + SPACE + instanceName() + " = new " + instanceType() + "()");
		}

		else
		{
			writeLine( instanceName() + " = (" + instanceType() + ")newInstance( " + instanceType() + ".class )");
		}
		return true;
	}
	
	public boolean writeInstance( Parameter param )
	{
		setInstanceClass( param.getType() );
		if ( hasDefaultConstructor() )
		{
			writeLine( instanceType() + SPACE + param.getName() + " = new " + instanceType() + "()");
		}
		else
		{
			writeLine( param.getName() + " = (" + instanceType() + ")newInstance( " + instanceType() + ".class )");
		}
		return true;
	}

	
	protected boolean hasDefaultConstructor()
	{
		Constructor[] constructors = getInstanceClass().getConstructors();
		for ( int i = 0; i < constructors.length; i++ )
		{
			if ( constructors[i].getParameterTypes().length == 0 )
			{
				return true;
			}
		}
		return false;
	}
	
	public DefaultInstanceWriter withInstanceClass( Class inClass )
	{
		setInstanceClass( inClass );
		return this;
	}

}
