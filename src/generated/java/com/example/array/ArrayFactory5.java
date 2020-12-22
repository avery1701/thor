package com.example.array;

import com.advancedpwr.record.factory.BaseFactory;
import com.advancedpwr.samples.StringArrayHolder;
import java.lang.String;

public class ArrayFactory5 extends BaseFactory
{

	protected StringArrayHolder stringarrayholder;

	public StringArrayHolder buildStringArrayHolder()
	{
		if ( stringarrayholder != null ) 
		{
			return stringarrayholder;
		}
		stringarrayholder = new StringArrayHolder();
		stringarrayholder.setArray1( buildStringArray_1_1() );
		stringarrayholder.setArray2( buildStringArray_4_1() );
		return stringarrayholder;
	}

	protected String[] stringArray_1_1;

	protected String[] buildStringArray_1_1()
	{
		if ( stringArray_1_1 != null ) 
		{
			return stringArray_1_1;
		}
		stringArray_1_1 = new String[2];
		stringArray_1_1[0] = "Joe";
		stringArray_1_1[1] = "Frank";
		return stringArray_1_1;
	}

	protected String[] stringArray_4_1;

	protected String[] buildStringArray_4_1()
	{
		if ( stringArray_4_1 != null ) 
		{
			return stringArray_4_1;
		}
		stringArray_4_1 = new String[2];
		stringArray_4_1[0] = "Mary";
		stringArray_4_1[1] = "Jane";
		return stringArray_4_1;
	}

}
