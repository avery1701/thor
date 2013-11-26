package com.advancedpwr.samples.generated;

import com.advancedpwr.record.factory.BaseFactory;
import com.advancedpwr.samples.Person;
import java.util.Date;

public class PersonArrayFactory extends BaseFactory
{

	protected Person[] personArray;

	public Person[] buildPersonArray() throws Exception
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

	protected Person buildPerson_1_1() throws Exception
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

	protected Person buildPerson_2_2() throws Exception
	{
		if ( person_2_2 != null ) 
		{
			return person_2_2;
		}
		person_2_2 = new Person();
		person_2_2.setAnniversary( buildDate_3_3() );
		person_2_2.setName( "dad" );
		return person_2_2;
	}

	protected Date date_3_3;

	protected Date buildDate_3_3()
	{
		date_3_3 = new Date( 975906000000l );
		return date_3_3;
	}

}
