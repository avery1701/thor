package com.example.mock;

import com.advancedpwr.samples.Person;
import com.advancedpwr.record.factory.MockFactory;

public class MockPersonFactory extends MockFactory
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
		replay( person );
		return person;
	}
}
