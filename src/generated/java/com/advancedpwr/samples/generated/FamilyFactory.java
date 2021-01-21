package com.advancedpwr.samples.generated;

import  static org.easymock.EasyMock.*;
import com.advancedpwr.record.factory.BaseFactory;
import com.advancedpwr.samples.Family;
import com.advancedpwr.samples.Person;
import com.advancedpwr.samples.Restricted;

public class FamilyFactory extends BaseFactory
{

	protected Family family;

	public Family buildFamily()
	{
		if ( family != null ) 
		{
			return family;
		}
		family = createStrictMock( Family.class );
		expect( family.getDad() ).andReturn( buildPerson_1_1() );
		expect( family.getDad() ).andReturn( buildPerson_1_1() );
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
		expect( person_1_1.getRestricted() ).andReturn( buildRestricted_2_2() );
		person_1_1.callSynced();
		replay( person_1_1 );
		return person_1_1;
	}

	protected Restricted restricted_2_2;

	protected Restricted buildRestricted_2_2()
	{
		if ( restricted_2_2 != null ) 
		{
			return restricted_2_2;
		}
		restricted_2_2 = createStrictMock( Restricted.class );
		replay( restricted_2_2 );
		return restricted_2_2;
	}
}
