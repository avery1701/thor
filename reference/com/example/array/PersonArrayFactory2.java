package com.example.array;

import com.advancedpwr.record.factory.BaseFactory;
import com.advancedpwr.samples.Person;

public class PersonArrayFactory2 extends BaseFactory
{

	protected Person[] personArray;

	public Person[] buildPersonArray()
	{
		if ( personArray != null ) 
		{
			return personArray;
		}
		personArray = new Person[5];
		personArray[0] = buildPerson_1_1();
		personArray[1] = buildPerson_5_1();
		personArray[2] = buildPerson_7_1();
		personArray[3] = buildPerson_9_1();
		personArray[4] = person_10_2;
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
		person_2_2.setName( "grandpa" );
		return person_2_2;
	}

	protected Person person_5_1;

	protected Person buildPerson_5_1()
	{
		if ( person_5_1 != null ) 
		{
			return person_5_1;
		}
		person_5_1 = new Person();
		person_5_1.setName( "mom" );
		return person_5_1;
	}

	protected Person person_7_1;

	protected Person buildPerson_7_1()
	{
		if ( person_7_1 != null ) 
		{
			return person_7_1;
		}
		person_7_1 = new Person();
		person_7_1.setDad( person_1_1 );
		person_7_1.setMom( person_5_1 );
		person_7_1.setName( "son" );
		return person_7_1;
	}

	protected Person person_9_1;

	protected Person buildPerson_9_1()
	{
		if ( person_9_1 != null ) 
		{
			return person_9_1;
		}
		person_9_1 = new Person();
		person_9_1.setDad( buildPerson_10_2() );
		person_9_1.setMom( buildPerson_13_2() );
		person_9_1.setName( "son" );
		return person_9_1;
	}

	protected Person person_10_2;

	protected Person buildPerson_10_2()
	{
		if ( person_10_2 != null ) 
		{
			return person_10_2;
		}
		person_10_2 = new Person();
		person_10_2.setDad( buildPerson_11_3() );
		person_10_2.setName( "dad2" );
		return person_10_2;
	}

	protected Person person_11_3;

	protected Person buildPerson_11_3()
	{
		if ( person_11_3 != null ) 
		{
			return person_11_3;
		}
		person_11_3 = new Person();
		person_11_3.setName( "grandpa" );
		return person_11_3;
	}

	protected Person person_13_2;

	protected Person buildPerson_13_2()
	{
		if ( person_13_2 != null ) 
		{
			return person_13_2;
		}
		person_13_2 = new Person();
		person_13_2.setName( "mom2" );
		return person_13_2;
	}

}
