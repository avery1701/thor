package com.advancedpwr.record.descriptor;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ArrayClassDescriptorTest
{

	@Test
	void test()
	{
		JavaArrayClassDescriptor desc = new JavaArrayClassDescriptor( String[].class );
		assertEquals( "StringArray", desc.getClassName() );
		assertEquals( "StringArrayFactory", desc.getFactoryClassName() );
		assertEquals( "java.lang", desc.getPackageName() );
		assertEquals( "java.lang.generated", desc.getFactoryPackageName() );
		ClassDescriptor compDesc = desc.getComponentType();
		JavaClassDescriptor realDesc = new JavaClassDescriptor( String.class );
		assertEquals( compDesc, realDesc );
	}

}
