package com.example.list;

import com.advancedpwr.record.factory.BaseFactory;
import com.advancedpwr.samples.Person;
import java.util.List;
import java.util.ArrayList;

public class PersonListFactory extends BaseFactory
{

	protected Person person;

	public Person buildPerson()
	{
		if ( person != null ) 
		{
			return person;
		}
		person = new Person();
		person.setMom( buildPerson_1_1() );
		person.setName( "dad" );
		person.setChildren( buildArrayList_4_1() );
		return person;
	}

	protected Person person_1_1;

	protected Person buildPerson_1_1()
	{
		if ( person_1_1 != null ) 
		{
			return person_1_1;
		}
		person_1_1 = new Person();
		person_1_1.setDad( person );
		person_1_1.setName( "Jill" );
		return person_1_1;
	}

	protected ArrayList arraylist_4_1;

	protected List buildArrayList_4_1()
	{
		if ( arraylist_4_1 != null ) 
		{
			return arraylist_4_1;
		}
		arraylist_4_1 = new ArrayList();
		arraylist_4_1.add( buildChildren_1_5_2() );
		arraylist_4_1.add( person_1_1 );
		arraylist_4_1.add( buildChildren_1_7_2() );
		return arraylist_4_1;
	}

	protected Person children_1_5_2;

	protected Person buildChildren_1_5_2()
	{
		if ( children_1_5_2 != null ) 
		{
			return children_1_5_2;
		}
		children_1_5_2 = new Person();
		children_1_5_2.setDad( person );
		children_1_5_2.setName( "jack" );
		return children_1_5_2;
	}

	protected Person children_1_7_2;

	protected Person buildChildren_1_7_2()
	{
		if ( children_1_7_2 != null ) 
		{
			return children_1_7_2;
		}
		children_1_7_2 = new Person();
		children_1_7_2.setDad( person );
		children_1_7_2.setMom( person_1_1 );
		children_1_7_2.setName( "joe" );
		return children_1_7_2;
	}

}
