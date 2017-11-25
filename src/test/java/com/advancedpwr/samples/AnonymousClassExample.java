package com.advancedpwr.samples;

import java.util.Calendar;

public class AnonymousClassExample
{
	protected Person createPerson()
	{
		return new Person()
		{
			public Calendar getBirthday()
			{
				return Calendar.getInstance();
			}
		};
	}
	
	protected Person fieldPerson;
	
	public Person getPerson()
	{
		if ( fieldPerson == null )
		{
			fieldPerson = createPerson();
		}
		return fieldPerson;
	}

	public void setPerson( Person person )
	{
		fieldPerson = person;
	}
}
