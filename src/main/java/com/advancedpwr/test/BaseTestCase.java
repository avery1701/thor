package com.advancedpwr.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Matthew Avery, mavery@advancedpwr.com
 * Created: Mar 14, 2016
 *
 */
public abstract class BaseTestCase //extends TestCase
{

	protected List<String> fieldCalls;

	public List<String> getCalls()
	{
		if ( fieldCalls == null )
		{
			fieldCalls = new ArrayList<>();
			
		}
	
		return fieldCalls;
	}

	public void addCall()
	{
		Throwable throwable = new Throwable();
		String methodName = throwable.getStackTrace()[1].getMethodName();
		getCalls().add( methodName );
	}
	
	public void addCall( String inArgument )
	{
		Throwable throwable = new Throwable();
		String methodName = throwable.getStackTrace()[1].getMethodName();
		getCalls().add( methodName + " : " + inArgument );
	}

//	public void failCall()
//	{
//		Throwable throwable = new Throwable();
//		String methodName = throwable.getStackTrace()[1].getMethodName();
//		fail( "should not have called " + methodName );
//	}
//	
//	public void assertCalls( String calls )
//	{
//		assertEquals( calls, getCalls().toString() );
//	}

	public void clearCalls()
	{
		getCalls().clear();
	}
	
}
