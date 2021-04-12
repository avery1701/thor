package com.example.array;

import com.advancedpwr.record.factory.generatedBaseFactoryFactory;

public class StringArrayFactory extends BaseFactoryFactory
{

	protected StringArrayFactory stringarrayfactory;

	public StringArrayFactory buildStringArrayFactory()
	{
		if ( stringarrayfactory != null ) 
		{
			return stringarrayfactory;
		}
		stringarrayfactory = (StringArrayFactory)newInstance( StringArrayFactory.class );
		stringarrayfactory.( buildStringFactory_1_1() );
		stringarrayfactory.( buildStringFactory_2_1() );
		stringarrayfactory.( buildStringFactory_3_1() );
		return stringarrayfactory;
	}

	protected StringFactory stringfactory_1_1;

	protected StringFactory buildStringFactory_1_1()
	{
		if ( stringfactory_1_1 != null ) 
		{
			return stringfactory_1_1;
		}
		stringfactory_1_1 = new StringFactory();
		return stringfactory_1_1;
	}

	protected StringFactory stringfactory_2_1;

	protected StringFactory buildStringFactory_2_1()
	{
		if ( stringfactory_2_1 != null ) 
		{
			return stringfactory_2_1;
		}
		stringfactory_2_1 = new StringFactory();
		return stringfactory_2_1;
	}

	protected StringFactory stringfactory_3_1;

	protected StringFactory buildStringFactory_3_1()
	{
		if ( stringfactory_3_1 != null ) 
		{
			return stringfactory_3_1;
		}
		stringfactory_3_1 = new StringFactory();
		return stringfactory_3_1;
	}

}
