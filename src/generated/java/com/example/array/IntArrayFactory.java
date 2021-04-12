package com.example.array;

import com.advancedpwr.record.factory.generatedBaseFactoryFactory;

public class IntArrayFactory extends BaseFactoryFactory
{

	protected intArrayFactory intarrayfactory;

	public intArrayFactory buildintArrayFactory()
	{
		if ( intarrayfactory != null ) 
		{
			return intarrayfactory;
		}
		intarrayfactory = (intArrayFactory)newInstance( intArrayFactory.class );
		intarrayfactory.( buildintFactory_1_1() );
		intarrayfactory.( buildintFactory_2_1() );
		intarrayfactory.( buildintFactory_3_1() );
		return intarrayfactory;
	}

	protected IntegerFactory intfactory_1_1;

	protected IntegerFactory buildintFactory_1_1()
	{
		if ( intfactory_1_1 != null ) 
		{
			return intfactory_1_1;
		}
		intfactory_1_1 = (IntegerFactory)newInstance( IntegerFactory.class );
		return intfactory_1_1;
	}

	protected IntegerFactory intfactory_2_1;

	protected IntegerFactory buildintFactory_2_1()
	{
		if ( intfactory_2_1 != null ) 
		{
			return intfactory_2_1;
		}
		intfactory_2_1 = (IntegerFactory)newInstance( IntegerFactory.class );
		return intfactory_2_1;
	}

	protected IntegerFactory intfactory_3_1;

	protected IntegerFactory buildintFactory_3_1()
	{
		if ( intfactory_3_1 != null ) 
		{
			return intfactory_3_1;
		}
		intfactory_3_1 = (IntegerFactory)newInstance( IntegerFactory.class );
		return intfactory_3_1;
	}

}
