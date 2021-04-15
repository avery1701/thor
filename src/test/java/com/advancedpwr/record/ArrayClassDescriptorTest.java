package com.advancedpwr.record;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.advancedpwr.record.descriptor.JavaArrayClassReference;

class ArrayClassDescriptorTest
{

	@Test
	void test() {
		String[] strings = {"hello", "world"};
		JavaArrayClassReference desc = new JavaArrayClassReference(strings.getClass());
		assertNotNull(desc.subject());
		assertEquals("StringArrayFactory", desc.getClassName());
		assertEquals(desc.subject(), String.class);
	}

}
