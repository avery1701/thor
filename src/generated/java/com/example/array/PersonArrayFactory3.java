package com.example.array;

import com.advancedpwr.record.factory.BaseFactory;
import com.advancedpwr.samples.Person;

public class PersonArrayFactory3 extends BaseFactory
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
		personArray[1] = buildPerson_3_1();
		personArray[2] = person_3_1;
		return personArray;
	}

	protected Person person_1_1;

	protected Person buildPerson_1_1()
	{
		if ( person_1_1 != null ) 
		{
			return person_1_1;
		}
		person_1_1 = new Person();
		person_1_1.setName( "Joe" );
		return person_1_1;
	}

	protected Person person_3_1;

	protected Person buildPerson_3_1()
	{
		if ( person_3_1 != null ) 
		{
			return person_3_1;
		}
		person_3_1 = new Person();
		person_3_1.setName( "Frank" );
		return person_3_1;
	}

}
