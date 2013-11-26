package com.example.list;

import com.advancedpwr.samples.Person;
import java.util.ArrayList;
import com.advancedpwr.record.factory.MockFactory;

public class ListInstanceFactory extends MockFactory
{

	protected Person person;

	public Person buildPerson()
	{
		if ( person != null ) 
		{
			return person;
		}
		person = createStrictMock( Person.class );
		expect( person.getChildren() ).andReturn( buildArrayList_1_1() );
		replay( person );
		return person;
	}

	protected ArrayList arraylist_1_1;

	protected ArrayList buildArrayList_1_1()
	{
		if ( arraylist_1_1 != null ) 
		{
			return arraylist_1_1;
		}
		arraylist_1_1 = createStrictMock( ArrayList.class );
		expect( arraylist_1_1.get( new Integer( 0 ) ) ).andReturn( buildPerson_2_2() );
		replay( arraylist_1_1 );
		return arraylist_1_1;
	}

	protected Person person_2_2;

	protected Person buildPerson_2_2()
	{
		if ( person_2_2 != null ) 
		{
			return person_2_2;
		}
		person_2_2 = createStrictMock( Person.class );
		expect( person_2_2.getName() ).andReturn( "jack" );
		expect( person_2_2.getDad() ).andReturn( person );
		replay( person_2_2 );
		return person_2_2;
	}
}
