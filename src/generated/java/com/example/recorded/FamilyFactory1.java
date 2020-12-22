package com.example.recorded;

import com.advancedpwr.record.factory.BaseFactory;
import com.advancedpwr.samples.Family;
import com.advancedpwr.samples.Person;
import java.util.Locale;

public class FamilyFactory1 extends BaseFactory
{

	protected Family family;

	public Family buildFamily()
	{
		if ( family != null ) 
		{
			return family;
		}
		family = new Family();
		family.setDad( buildPerson_1_1() );
		family.setLocale( buildLocale_5_1() );
		family.setMom( buildPerson_6_1() );
		return family;
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

	protected Locale locale_5_1;

	protected Locale buildLocale_5_1()
	{
		if ( locale_5_1 != null ) 
		{
			return locale_5_1;
		}
		locale_5_1 = new Locale( "en", "CA" );
		return locale_5_1;
	}

	protected Person person_6_1;

	protected Person buildPerson_6_1()
	{
		if ( person_6_1 != null ) 
		{
			return person_6_1;
		}
		person_6_1 = new Person();
		person_6_1.setName( "mom" );
		return person_6_1;
	}

}
