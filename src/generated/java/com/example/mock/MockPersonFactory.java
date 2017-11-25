package com.example.mock;

import  static org.easymock.EasyMock.*;
import com.advancedpwr.record.factory.BaseFactory;
import com.advancedpwr.samples.Person;

public class MockPersonFactory extends BaseFactory
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
