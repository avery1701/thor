package com.example.mock;

import com.advancedpwr.samples.Family;
import com.advancedpwr.samples.Person;
import com.advancedpwr.record.factory.MockFactory;

public class MockPersonFactory4 extends MockFactory
{

	protected Family family;

	public Family buildFamily()
	{
		if ( family != null ) 
		{
			return family;
		}
		family = createStrictMock( Family.class );
		family.setParents( buildPerson_1_1(),buildPerson_2_1() );
		replay( family );
		return family;
	}

	protected Person person_1_1;

	protected Person buildPerson_1_1()
	{
		if ( person_1_1 != null ) 
		{
			return person_1_1;
		}
		person_1_1 = createStrictMock( Person.class );
		replay( person_1_1 );
		return person_1_1;
	}

	protected Person person_2_1;

	protected Person buildPerson_2_1()
	{
		if ( person_2_1 != null ) 
		{
			return person_2_1;
		}
		person_2_1 = createStrictMock( Person.class );
		replay( person_2_1 );
		return person_2_1;
	}
}
