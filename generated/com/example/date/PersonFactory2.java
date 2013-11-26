package com.example.date;

import com.advancedpwr.record.factory.BaseFactory;
import com.advancedpwr.samples.Person;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import com.advancedpwr.samples.BirthdayException;

public class PersonFactory2 extends BaseFactory
{

	protected Person person;

	public Person buildPerson() throws Exception, BirthdayException
	{
		if ( person != null ) 
		{
			return person;
		}
		person = new Person();
		person.setDad( buildPerson_1_1() );
		person.setMom( buildPerson_7_1() );
		person.setName( "son" );
		return person;
	}

	protected Person person_1_1;

	protected Person buildPerson_1_1() throws Exception, BirthdayException
	{
		if ( person_1_1 != null ) 
		{
			return person_1_1;
		}
		person_1_1 = new Person();
		person_1_1.setAnniversary( buildDate_2_2() );
		person_1_1.setBirthday( buildGregorianCalendar_3_2() );
		person_1_1.setDad( buildPerson_4_2() );
		person_1_1.setName( "dad" );
		return person_1_1;
	}

	protected java.sql.Date date_2_2;

	protected Date buildDate_2_2()
	{
		date_2_2 = new java.sql.Date( 987654321l );
		return date_2_2;
	}

	protected Calendar gregoriancalendar_3_2;

	protected Calendar buildGregorianCalendar_3_2()
	{
		gregoriancalendar_3_2 = GregorianCalendar.getInstance();
		return gregoriancalendar_3_2;
	}

	protected Person person_4_2;

	protected Person buildPerson_4_2()
	{
		if ( person_4_2 != null ) 
		{
			return person_4_2;
		}
		person_4_2 = new Person();
		person_4_2.setName( "grandpa" );
		return person_4_2;
	}

	protected Person person_7_1;

	protected Person buildPerson_7_1()
	{
		if ( person_7_1 != null ) 
		{
			return person_7_1;
		}
		person_7_1 = new Person();
		person_7_1.setName( "mom" );
		return person_7_1;
	}

}
