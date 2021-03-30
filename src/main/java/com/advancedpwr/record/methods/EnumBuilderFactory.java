package com.advancedpwr.record.methods;

import com.advancedpwr.record.AccessPath;
import com.advancedpwr.record.descriptor.ClassDescriptor;

public class EnumBuilderFactory implements MethodWriterFactory
{

	@Override
	public boolean accept( ClassDescriptor inClass )
	{
		return inClass.isEnum();
	}

	@Override
	public BuildMethodWriter createMethodBuilder( AccessPath inPath )
	{
		return new EnumBuilder();
	}

}
