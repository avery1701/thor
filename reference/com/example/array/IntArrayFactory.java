package com.example.array;

import com.advancedpwr.record.factory.BaseFactory;

public class IntArrayFactory extends BaseFactory
{

	protected int[] intArray;

	public int[] buildintArray()
	{
		if ( intArray != null ) 
		{
			return intArray;
		}
		intArray = new int[3];
		intArray[0] = new Integer( 10 );
		intArray[1] = new Integer( 12 );
		intArray[2] = new Integer( 14 );
		return intArray;
	}

}
