package com.advancedpwr.record.methods;

import java.util.Date;

import com.advancedpwr.record.BeanRecorderTest;

public class DateBuilderTest extends BeanRecorderTest
{
	protected void setUp()
	{
		setWriteFiles();
		super.setUp();
	}
	
	public void testSameDateInstance()
	{
		DateHolder dateHolder = new DateHolder();
		Date date = new Date( 1234567689 );
		
		dateHolder.setDate( date );
		dateHolder.setOtherDate( date );
		recorder.setClassName( "com.example.methods.DateHolderFactory" );
		recorder.record( dateHolder );
		assertResult();
		
	}
}
