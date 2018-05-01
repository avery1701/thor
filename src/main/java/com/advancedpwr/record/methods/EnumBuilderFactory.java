package com.advancedpwr.record.methods;

import com.advancedpwr.record.AccessPath;

public class EnumBuilderFactory implements MethodWriterFactory
{

	@Override
	public boolean accept( Class inClass )
	{
		return inClass.isEnum();
	}

	@Override
	public BuildMethodWriter createMethodBuilder( AccessPath inPath )
	{
		return new EnumBuilder();
	}

}
