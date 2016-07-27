package com.advancedpwr.record.methods;

import com.advancedpwr.record.AbstractRecorderTest;
import com.advancedpwr.samples.AnonymousClassExample;

public class AnonymousClassTest extends AbstractRecorderTest
{
	public void testRecordNestedClass()
	{
		AnonymousClassExample example = new AnonymousClassExample();
		
		recorder.setClassName( "com.example.anonymous.AnonymousClassFactory" );
		recorder.record( example );
		assertResult();
	}
}
