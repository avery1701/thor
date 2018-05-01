package com.advancedpwr.record;

import com.advancedpwr.samples.Direction;
import com.advancedpwr.samples.People;
import com.advancedpwr.samples.Person;

public class PeopleTest extends AbstractRecorderTest
{

	protected void setUp()
	{
		setWriteFiles();
		super.setUp();
	}
	
	public void testRecordFamily()
	{
		Person person = Person.createExamplePerson();
		People people = new People();
		people.setPersons( new Person[] { person, person.getDad() } );
		people.setDirection( Direction.RIGHT );
		
		recorder.setClassName( "com.example.recorded.PeopleFactory" );
		recorder.record( people );
		assertResult();
	}
}
