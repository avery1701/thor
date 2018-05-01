package com.advancedpwr.test;

import org.junit.Test;

import junit.framework.AssertionFailedError;

public class BaseTestCaseTest extends BaseTestCase
{

	@Test
	public void testCalls()
	{
		someMethod();
		anotherMethod();
		assertCalls( "[someMethod, anotherMethod : another one]" );
		clearCalls();
		assertCalls( "[]" );
		
		try
		{
			failCall();
			throw new RuntimeException();
		}
		catch ( AssertionFailedError e )
		{
			
		}
	}
	
	protected void someMethod()
	{
		addCall();
	}
	
	protected void anotherMethod()
	{
		addCall( "another one" );
	}

}
