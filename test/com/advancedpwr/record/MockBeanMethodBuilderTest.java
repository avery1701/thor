package com.advancedpwr.record;

import junit.framework.TestCase;

public class MockBeanMethodBuilderTest extends TestCase
{

	protected void setUp() throws Exception
	{
		super.setUp();
	}
	
	public void testMethod()
	{
		MockBeanMethodBuilder builder = new MockBeanMethodBuilder();
		assertEquals( "", builder.methodName( new AccessPath() ) );
	}

}
