package com.example.mock;

import com.advancedpwr.samples.Family;
import com.advancedpwr.samples.Person;
import com.advancedpwr.record.factory.MockFactory;

public class MockPersonFactory6 extends MockFactory
{

	protected Family family;

	public Family buildFamily() throws Exception
	{
		if ( family != null ) 
		{
			return family;
		}
		family = createStrictMock( Family.class );
		expect( family.fued( buildPerson_1_1() ) ).andThrow( buildException_4_1() );
		replay( family );
		return family;
	}

	protected Exception exception_4_1;

	protected Exception buildException_4_1()
	{
		if ( exception_4_1 != null ) 
		{
			return exception_4_1;
		}
		exception_4_1 = createStrictMock( Exception.class );
		replay( exception_4_1 );
		return exception_4_1;
	}

	protected Person person_1_1;

	protected Person buildPerson_1_1()
	{
		if ( person_1_1 != null ) 
		{
			return person_1_1;
		}
		person_1_1 = createStrictMock( Person.class );
		person_1_1.setName( "jerk" );
		replay( person_1_1 );
		return person_1_1;
	}
}
