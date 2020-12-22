package com.example.recursion;

import com.advancedpwr.record.factory.BaseFactory;
import com.advancedpwr.samples.Person;

public class PersonFactory3 extends BaseFactory
{

	protected Person person;

	public Person buildPerson()
	{
		if ( person != null ) 
		{
			return person;
		}
		person = new Person();
		person.setDad( buildPerson_1_1() );
		person.setName( "son" );
		return person;
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
		person_1_1.setName( "dad" );
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
		person_2_2.setDad( person );
		person_2_2.setName( "grandpa" );
		return person_2_2;
	}

}
