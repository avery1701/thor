package com.example.recursion;

import com.advancedpwr.record.factory.BaseFactory;
import com.advancedpwr.samples.Person;

public class PersonFactory4 extends BaseFactory
{

	protected Person person;

	public Person buildPerson()
	{
		if ( person != null ) 
		{
			return person;
		}
		person = new Person();
		return person;
	}

}
