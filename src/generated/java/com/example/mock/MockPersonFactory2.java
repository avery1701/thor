package com.example.mock;

import  static org.easymock.EasyMock.*;
import com.advancedpwr.record.factory.BaseFactory;
import com.advancedpwr.samples.Person;

public class MockPersonFactory2 extends BaseFactory
{

	protected Person person;

	public Person buildPerson()
	{
		if ( person != null ) 
		{
			return person;
		}
		person = createStrictMock( Person.class );
		person.setName( "Joe" );
		expect( person.getName() ).andReturn( "Joe" );
		expect( person.getDad() ).andReturn( buildPerson_3_1() );
		expect( person.getDad() ).andReturn( buildPerson_3_1() );
		person.setMom( buildPerson_5_1() );
		expect( person.getMom() ).andReturn( buildPerson_5_1() );
		person.setMom( buildPerson_5_1() );
		person.setMom( null );
		expect( person.getMom() ).andReturn( null );
		replay( person );
		return person;
	}

	protected Person person_3_1;

	protected Person buildPerson_3_1()
	{
		if ( person_3_1 != null ) 
		{
			return person_3_1;
		}
		person_3_1 = createStrictMock( Person.class );
		expect( person_3_1.getName() ).andReturn( "dad" );
		expect( person_3_1.getName() ).andReturn( "dad" );
		replay( person_3_1 );
		return person_3_1;
	}

	protected Person person_5_1;

	protected Person buildPerson_5_1()
	{
		if ( person_5_1 != null ) 
		{
			return person_5_1;
		}
		person_5_1 = createStrictMock( Person.class );
		expect( person_5_1.getName() ).andReturn( "mom" );
		replay( person_5_1 );
		return person_5_1;
	}
}
