package com.example.recorded;

import com.advancedpwr.record.factory.BaseFactory;
import com.advancedpwr.samples.NoDefaultConstructorPerson;
import com.advancedpwr.samples.Person;

public class ObjenesisPersonFactory extends BaseFactory
{

	protected NoDefaultConstructorPerson nodefaultconstructorperson;

	public NoDefaultConstructorPerson buildNoDefaultConstructorPerson()
	{
		if ( nodefaultconstructorperson != null ) 
		{
			return nodefaultconstructorperson;
		}
		nodefaultconstructorperson = (NoDefaultConstructorPerson)newInstance( NoDefaultConstructorPerson.class );
		nodefaultconstructorperson.setDad( buildPerson_1_1() );
		return nodefaultconstructorperson;
	}

	protected Person person_1_1;

	protected Person buildPerson_1_1()
	{
		if ( person_1_1 != null ) 
		{
			return person_1_1;
		}
		person_1_1 = new Person();
		person_1_1.setName( "Jim" );
		return person_1_1;
	}

}
