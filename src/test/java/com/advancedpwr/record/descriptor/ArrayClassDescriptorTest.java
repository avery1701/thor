package com.advancedpwr.record.descriptor;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.advancedpwr.samples.Person;

class ArrayClassDescriptorTest
{

	@Test
	void test()
	{
		Class<?> type = Person[].class;
		JavaArrayClassDescriptor desc = new JavaArrayClassDescriptor( type );
		assertEquals( type.getComponentType().getSimpleName() + "ArrayFactory", desc.getClassName() );
		assertEquals( type.getComponentType().getPackage().getName() + ".generated",
				desc.getPackageName() );
		ClassDescriptor compDesc = desc.getComponentType();
		JavaClassDescriptor realDesc = new JavaClassDescriptor( Person.class );
		assertEquals( compDesc, realDesc );

		System.out.println( desc.getConstructors() );
	}

}
