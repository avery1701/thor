package com.advancedpwr.record.examples.generated;

import com.advancedpwr.record.examples.Person;
import com.advancedpwr.record.mock.MockFactory;

public class PersonArrayFactory extends MockFactory
{

	protected Person[] personArray;

	public Person[] buildPersonArray()
	{
		if ( personArray != null ) 
		{
			return personArray;
		}
		personArray = new Person[3];
		personArray[0] = buildPerson_1_1();
		personArray[1] = buildPerson_2_1();
		personArray[2] = buildPerson_3_1();
		return personArray;
	}

	protected Person person_1_1;

	protected Person buildPerson_1_1()
	{
		if ( person_1_1 != null ) 
		{
			return person_1_1;
		}
		person_1_1 = createStrictMock( Person.class );
		replay( person_1_1 );
		return person_1_1;
	}

	protected Person person_2_1;

	protected Person buildPerson_2_1()
	{
		if ( person_2_1 != null ) 
		{
			return person_2_1;
		}
		person_2_1 = createStrictMock( Person.class );
		expect( person_2_1.getName() ).andReturn( "mom" );
		replay( person_2_1 );
		return person_2_1;
	}

	protected Person person_3_1;

	protected Person buildPerson_3_1()
	{
		if ( person_3_1 != null ) 
		{
			return person_3_1;
		}
		person_3_1 = createStrictMock( Person.class );
		replay( person_3_1 );
		return person_3_1;
	}
}
