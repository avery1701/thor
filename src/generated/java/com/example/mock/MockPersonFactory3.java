package com.example.mock;

import  static org.easymock.EasyMock.*;
import com.advancedpwr.record.factory.BaseFactory;
import com.advancedpwr.samples.Person;

public class MockPersonFactory3 extends BaseFactory
{

	protected Person person;

	public Person buildPerson()
	{
		if ( person != null ) 
		{
			return person;
		}
		person = createStrictMock( Person.class );
		expect( person.getDad() ).andReturn( buildPerson_1_1() );
		replay( person );
		return person;
	}

	protected Person person_1_1;

	protected Person buildPerson_1_1()
	{
		if ( person_1_1 != null ) 
		{
			return person_1_1;
		}
		person_1_1 = createStrictMock( Person.class );
		expect( person_1_1.getDad() ).andReturn( buildPerson_2_2() );
		replay( person_1_1 );
		return person_1_1;
	}

	protected Person person_2_2;

	protected Person buildPerson_2_2()
	{
		if ( person_2_2 != null ) 
		{
			return person_2_2;
		}
		person_2_2 = createStrictMock( Person.class );
		expect( person_2_2.getName() ).andReturn( "grandpa" );
		person_2_2.setName( "Grandpa Joe" );
		expect( person_2_2.getName() ).andReturn( "Grandpa Joe" );
		replay( person_2_2 );
		return person_2_2;
	}
}
