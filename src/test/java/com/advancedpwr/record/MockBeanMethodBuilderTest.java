package com.advancedpwr.record;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MockBeanMethodBuilderTest {

	@Test
	public void testMethod() {
		MockBeanMethodBuilder builder = new MockBeanMethodBuilder();
		assertEquals("", builder.methodName(new AccessPath()));
	}

}
