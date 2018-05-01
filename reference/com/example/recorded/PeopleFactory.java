package com.example.recorded;

import com.advancedpwr.record.factory.BaseFactory;
import com.advancedpwr.samples.People;
import com.advancedpwr.samples.Direction;
import com.advancedpwr.samples.Person;

public class PeopleFactory extends BaseFactory
{

	protected People people;

	public People buildPeople()
	{
		if ( people != null ) 
		{
			return people;
		}
		people = new People();
		people.setDirection( buildDirection_1_1() );
		people.setPersons( buildPersonArray_2_1() );
		return people;
	}

	protected Direction buildDirection_1_1()
	{
		return Direction.RIGHT;
	}

	protected Person[] personArray_2_1;

	protected Person[] buildPersonArray_2_1()
	{
		if ( personArray_2_1 != null ) 
		{
			return personArray_2_1;
		}
		personArray_2_1 = new Person[2];
		personArray_2_1[0] = buildPerson_3_2();
		personArray_2_1[1] = person_4_3;
		return personArray_2_1;
	}

	protected Person person_3_2;

	protected Person buildPerson_3_2()
	{
		if ( person_3_2 != null ) 
		{
			return person_3_2;
		}
		person_3_2 = new Person();
		person_3_2.setDad( buildPerson_4_3() );
		person_3_2.setMom( buildPerson_8_3() );
		person_3_2.setName( "son" );
		return person_3_2;
	}

	protected Person person_4_3;

	protected Person buildPerson_4_3()
	{
		if ( person_4_3 != null ) 
		{
			return person_4_3;
		}
		person_4_3 = new Person();
		person_4_3.setDad( buildPerson_5_4() );
		person_4_3.setName( "dad" );
		return person_4_3;
	}

	protected Person person_5_4;

	protected Person buildPerson_5_4()
	{
		if ( person_5_4 != null ) 
		{
			return person_5_4;
		}
		person_5_4 = new Person();
		person_5_4.setName( "grandpa" );
		return person_5_4;
	}

	protected Person person_8_3;

	protected Person buildPerson_8_3()
	{
		if ( person_8_3 != null ) 
		{
			return person_8_3;
		}
		person_8_3 = new Person();
		person_8_3.setName( "mom" );
		return person_8_3;
	}

}
