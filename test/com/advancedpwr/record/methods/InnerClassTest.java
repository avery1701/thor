package com.advancedpwr.record.methods;

import com.advancedpwr.record.AbstractRecorderTest;
import com.advancedpwr.samples.InnerClassExample;
import com.advancedpwr.samples.InnerClassExample.InnerClass;

public class InnerClassTest extends AbstractRecorderTest
{
	protected void setUp()
	{
		super.setUp();
	}
	
	public void testRecordInnerClass()
	{
		InnerClassExample example = new InnerClassExample();
		InnerClass obj = example.new InnerClass();
		obj.setName( "Joe" );
		example.setInnerInstance( obj );
		recorder.setClassName( "com.examples.inner.InnerClassFactory" );
		recorder.record( example );
		assertResult();
	}
	
//	public void testFactory()
//	{
//		InnerClassExample example = new InnerClassFactory().buildInnerClassExample();
//		assertNotNull( example.getInnerInstance() );
//		assertEquals( "Joe", example.getInnerInstance().getName() );
//	}
}
