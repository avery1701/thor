package com.advancedpwr.record.factory;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests
{

	public static Test suite()
	{
		TestSuite suite = new TestSuite( "Test for com.advancedpwr.record.factory" );
		//$JUnit-BEGIN$
		suite.addTestSuite( MockBeanFactoryTest.class );
		suite.addTestSuite( BaseFactoryTest.class );
		//$JUnit-END$
		return suite;
	}

}
