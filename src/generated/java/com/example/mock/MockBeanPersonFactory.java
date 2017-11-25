package com.example.mock;

import  static org.easymock.EasyMock.*;
import com.advancedpwr.record.factory.MockBeanFactory;
import com.advancedpwr.samples.Person;

public class MockBeanPersonFactory extends MockBeanFactory
{

	protected Person person;

	public Person buildPerson()
	{
		if ( person != null ) 
		{
			return person;
		}
		person = createNiceMock( Person.class );
		expect( person.getDad( ) ).andReturn( buildPerson_1_1() );
		expect( person.getMom( ) ).andReturn( buildPerson_5_1() );
		expect( person.getName( ) ).andReturn( "son" );
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
		person_1_1 = createNiceMock( Person.class );
		expect( person_1_1.getDad( ) ).andReturn( buildPerson_2_2() );
		expect( person_1_1.getName( ) ).andReturn( "dad" );
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
		person_2_2 = createNiceMock( Person.class );
		expect( person_2_2.getName( ) ).andReturn( "grandpa" );
		replay( person_2_2 );
		return person_2_2;
	}

	protected Person person_5_1;

	protected Person buildPerson_5_1()
	{
		if ( person_5_1 != null ) 
		{
			return person_5_1;
		}
		person_5_1 = createNiceMock( Person.class );
		expect( person_5_1.getName( ) ).andReturn( "mom" );
		replay( person_5_1 );
		return person_5_1;
	}

}
