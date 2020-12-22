package com.example.anonymous;

import com.advancedpwr.record.factory.BaseFactory;
import com.advancedpwr.samples.AnonymousClassExample;
import com.advancedpwr.samples.Person;
import java.util.Calendar;
import java.util.GregorianCalendar;
import com.advancedpwr.samples.BirthdayException;

public class AnonymousClassFactory extends BaseFactory
{

	protected AnonymousClassExample anonymousclassexample;

	public AnonymousClassExample buildAnonymousClassExample() throws BirthdayException
	{
		if ( anonymousclassexample != null ) 
		{
			return anonymousclassexample;
		}
		anonymousclassexample = new AnonymousClassExample();
		anonymousclassexample.setPerson( buildPerson_1_1() );
		return anonymousclassexample;
	}

	protected Person person_1_1;

	protected Person buildPerson_1_1() throws BirthdayException
	{
		if ( person_1_1 != null ) 
		{
			return person_1_1;
		}
		person_1_1 = new Person();
		person_1_1.setBirthday( buildGregorianCalendar_2_2() );
		return person_1_1;
	}

	protected Calendar gregoriancalendar_2_2;

	protected Calendar buildGregorianCalendar_2_2()
	{
		gregoriancalendar_2_2 = GregorianCalendar.getInstance();
		return gregoriancalendar_2_2;
	}

}
