package com.advancedpwr.record.examples.generated;

import com.advancedpwr.record.BaseFactory;
import com.advancedpwr.record.examples.StringExample;

public class StringExampleFactory extends BaseFactory
{

	protected StringExample stringexample;

	public StringExample buildStringExample()
	{
		stringexample = (StringExample)newInstance( StringExample.class );
		stringexample.setString( "a string" );
		stringexample.setString2( "another string\r\ntwo lines long" );
		return stringexample;
	}

}
