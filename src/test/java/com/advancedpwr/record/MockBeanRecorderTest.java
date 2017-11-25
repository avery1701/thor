package com.advancedpwr.record;

import com.advancedpwr.record.factory.MockBeanFactory;
import com.advancedpwr.samples.Person;

public class MockBeanRecorderTest extends AbstractRecorderTest
{
	
	protected void setUp()
	{
		setWriteFiles();
		recorder = new MockBeanRecorder();
		configureRecorder( recorder );
	}

	protected MockBeanRecorder getRecorder()
	{
		return (MockBeanRecorder)recorder;
	}
	public void testMockBean()
	{
		recorder.setClassName( "com.example.mock.MockBeanPersonFactory" );
		recorder.setSuperClass( MockBeanFactory.class );
		getRecorder().mock( Person.class );
		
		Person person = Person.createExamplePerson();
		recorder.record( person );
		
		assertResult();
	}
}
