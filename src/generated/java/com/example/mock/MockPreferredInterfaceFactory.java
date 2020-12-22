package com.example.mock;

import  static org.easymock.EasyMock.*;
import com.advancedpwr.record.factory.BaseFactory;
import com.advancedpwr.samples.Being;

public class MockPreferredInterfaceFactory extends BaseFactory
{

	protected Being being;

	public Being buildBeing()
	{
		if ( being != null ) 
		{
			return being;
		}
		being = createStrictMock( Being.class );
		expect( being.getDad() ).andReturn( buildBeing_1_1() );
		expect( being.getMom() ).andReturn( buildBeing_2_1() );
		replay( being );
		return being;
	}

	protected Being being_1_1;

	protected Being buildBeing_1_1()
	{
		if ( being_1_1 != null ) 
		{
			return being_1_1;
		}
		being_1_1 = createStrictMock( Being.class );
		replay( being_1_1 );
		return being_1_1;
	}

	protected Being being_2_1;

	protected Being buildBeing_2_1()
	{
		if ( being_2_1 != null ) 
		{
			return being_2_1;
		}
		being_2_1 = createStrictMock( Being.class );
		replay( being_2_1 );
		return being_2_1;
	}
}
