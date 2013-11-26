package com.example.array;

import com.advancedpwr.record.factory.BaseFactory;
import com.advancedpwr.samples.Person;

public class PersonArrayFactory4 extends BaseFactory
{

	protected Person[] personArray;

	public Person[] buildPersonArray()
	{
		if ( personArray != null ) 
		{
			return personArray;
		}
		personArray = new Person[2];
		personArray[0] = buildPerson_1_1();
		personArray[1] = person_2_2;
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
		person_1_1.setDad( buildPerson_2_2() );
		person_1_1.setName( "joe" );
		return person_1_1;
	}

	protected Person person_2_2;

	protected Person buildPerson_2_2()
	{
		if ( person_2_2 != null ) 
		{
			return person_2_2;
		}
		person_2_2 = new Person();
		person_2_2.setName( "dad" );
		return person_2_2;
	}

}
