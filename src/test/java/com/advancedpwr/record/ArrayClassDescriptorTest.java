package com.advancedpwr.record;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.advancedpwr.record.descriptor.JavaArrayClassReference;

class ArrayClassDescriptorTest
{

	@Test
	void test() {
		String[] strings = {"hello", "world"};
		JavaArrayClassReference desc = new JavaArrayClassReference(strings.getClass());
		assertEquals("StringArrayFactory", desc.getClassName());
		assertEquals("java.lang", desc.getPackageName());
	}

}
