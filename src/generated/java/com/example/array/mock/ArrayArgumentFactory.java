package com.example.array.mock;

import  static org.easymock.EasyMock.*;
import com.advancedpwr.record.factory.BaseFactory;
import com.advancedpwr.samples.Family;
import com.advancedpwr.samples.Person;
import java.lang.String;

public class ArrayArgumentFactory extends BaseFactory
{

	protected Family family;

	public Family buildFamily()
	{
		if ( family != null ) 
		{
			return family;
		}
		family = createStrictMock( Family.class );
		expect( family.people( buildStringArray_4_1() ) ).andReturn( buildPersonArray_1_1() );
		replay( family );
		return family;
	}

	protected Person[] personArray_1_1;

	protected Person[] buildPersonArray_1_1()
	{
		if ( personArray_1_1 != null ) 
		{
			return personArray_1_1;
		}
		personArray_1_1 = new Person[2];
		personArray_1_1[0] = buildPerson_2_2();
		personArray_1_1[1] = buildPerson_3_2();
		return personArray_1_1;
	}

	protected Person person_2_2;

	protected Person buildPerson_2_2()
	{
		if ( person_2_2 != null ) 
		{
			return person_2_2;
		}
		person_2_2 = createStrictMock( Person.class );
		expect( person_2_2.getName() ).andReturn( "Frank" );
		replay( person_2_2 );
		return person_2_2;
	}

	protected Person person_3_2;

	protected Person buildPerson_3_2()
	{
		if ( person_3_2 != null ) 
		{
			return person_3_2;
		}
		person_3_2 = createStrictMock( Person.class );
		expect( person_3_2.getName() ).andReturn( "Joe" );
		replay( person_3_2 );
		return person_3_2;
	}

	protected String[] stringArray_4_1;

	protected String[] buildStringArray_4_1()
	{
		if ( stringArray_4_1 != null ) 
		{
			return stringArray_4_1;
		}
		stringArray_4_1 = new String[2];
		stringArray_4_1[0] = "Frank";
		stringArray_4_1[1] = "Joe";
		return stringArray_4_1;
	}
}
