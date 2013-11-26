package com.examples.inner;

import com.advancedpwr.record.factory.BaseFactory;
import com.advancedpwr.samples.InnerClassExample;
import com.advancedpwr.samples.InnerClassExample.InnerClass;

public class InnerClassFactory extends BaseFactory
{

	protected InnerClassExample innerclassexample;

	public InnerClassExample buildInnerClassExample()
	{
		if ( innerclassexample != null ) 
		{
			return innerclassexample;
		}
		innerclassexample = new InnerClassExample();
		innerclassexample.setInnerInstance( buildInnerClass_1_1() );
		return innerclassexample;
	}

	protected InnerClass innerclass_1_1;

	protected InnerClass buildInnerClass_1_1()
	{
		if ( innerclass_1_1 != null ) 
		{
			return innerclass_1_1;
		}
		innerclass_1_1 = (InnerClass)newInstance( InnerClass.class );
		innerclass_1_1.setName( "Joe" );
		return innerclass_1_1;
	}

}
