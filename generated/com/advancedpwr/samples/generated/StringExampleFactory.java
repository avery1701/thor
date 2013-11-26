package com.advancedpwr.samples.generated;

import com.advancedpwr.record.factory.BaseFactory;
import com.advancedpwr.samples.StringExample;

public class StringExampleFactory extends BaseFactory
{

	protected StringExample stringexample;

	public StringExample buildStringExample()
	{
		if ( stringexample != null ) 
		{
			return stringexample;
		}
		stringexample = new StringExample();
		stringexample.setString( "a string" );
		stringexample.setString2( "another string\r\ntwo lines long" );
		return stringexample;
	}

}
