package com.advancedpwr.generate;

import static com.advancedpwr.record.ClassWriter.SPACE;

import java.lang.reflect.Parameter;

import com.advancedpwr.record.ClassWriter;

public class ArrayInstanceWriter extends BaseInstanceWriter
{

	public ArrayInstanceWriter( ClassWriter inWriter )
	{
		super( inWriter );
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean writeInstance( Class inClass )
	{
		setInstanceClass( inClass );
		return writeArrayInstance();
	}

	protected String arrayType()
	{
		return getInstanceClass().getComponentType().getSimpleName() + "[]";
	}

	public boolean isMatch()
	{
		return getInstanceClass().isArray();
	}

	@Override
	public boolean writeInstance( Parameter param )
	{
		setInstanceClass( param.getType() );
		setInstanceName( param.getName() );
		return writeArrayInstance();
	}

	protected boolean writeArrayInstance()
	{
		if ( isMatch() )
		{
			writeLine( arrayType() + SPACE + getInstanceName() + " = new " + arrayType()  + "{}");
			return true;
		}
		return false;
	}

}
