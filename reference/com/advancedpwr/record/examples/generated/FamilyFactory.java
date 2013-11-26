package com.advancedpwr.record.examples.generated;

import com.advancedpwr.record.examples.Family;
import com.advancedpwr.record.examples.Person;
import com.advancedpwr.record.mock.MockFactory;

public class FamilyFactory extends MockFactory
{

	protected Family family;

	public Family buildFamily() throws Exception
	{
		if ( family != null ) 
		{
			return family;
		}
		family = createNiceMock( Family.class );
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
		exception_4_1 = createNiceMock( Exception.class );
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
		person_1_1 = createNiceMock( Person.class );
		person_1_1.setName( "jerk" );
		replay( person_1_1 );
		return person_1_1;
	}
}
