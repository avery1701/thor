package com.advancedpwr.record.factory;

import java.util.Locale;

import junit.framework.TestCase;

public class MockBeanFactoryTest extends TestCase
{

	
	public void testNewInstance()
	{
		MockBeanFactory factory = new MockBeanFactory()
		{
		};
		
		Locale locale = (Locale)factory.newInstance( Locale.class );
		assertNotNull( locale );
	}

}
