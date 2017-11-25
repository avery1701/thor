package com.example.array;

import com.advancedpwr.record.factory.BaseFactory;

public class StringArrayFactory extends BaseFactory
{

	protected String[] stringArray;

	public String[] buildStringArray()
	{
		if ( stringArray != null ) 
		{
			return stringArray;
		}
		stringArray = new String[3];
		stringArray[0] = "Joe";
		stringArray[1] = "Fred";
		stringArray[2] = "Bob";
		return stringArray;
	}

}
