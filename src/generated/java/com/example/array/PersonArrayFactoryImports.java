package com.example.array;

import com.advancedpwr.record.factory.BaseFactory;
import com.advancedpwr.samples.Family;
import com.advancedpwr.samples.Person;

public class PersonArrayFactoryImports extends BaseFactory
{

	protected Family[] familyArray;

	public Family[] buildFamilyArray()
	{
		if ( familyArray != null ) 
		{
			return familyArray;
		}
		familyArray = new Family[2];
		familyArray[0] = buildFamily_1_1();
		familyArray[1] = buildFamily_8_1();
		return familyArray;
	}

	protected Family family_1_1;

	protected Family buildFamily_1_1()
	{
		if ( family_1_1 != null ) 
		{
			return family_1_1;
		}
		family_1_1 = new Family();
		family_1_1.setDad( buildPerson_2_2() );
		family_1_1.setMom( buildPerson_6_2() );
		return family_1_1;
	}

	protected Person person_2_2;

	protected Person buildPerson_2_2()
	{
		if ( person_2_2 != null ) 
		{
			return person_2_2;
		}
		person_2_2 = new Person();
		person_2_2.setDad( buildPerson_3_3() );
		person_2_2.setName( "dad" );
		return person_2_2;
	}

	protected Person person_3_3;

	protected Person buildPerson_3_3()
	{
		if ( person_3_3 != null ) 
		{
			return person_3_3;
		}
		person_3_3 = new Person();
		person_3_3.setName( "grandpa" );
		return person_3_3;
	}

	protected Person person_6_2;

	protected Person buildPerson_6_2()
	{
		if ( person_6_2 != null ) 
		{
			return person_6_2;
		}
		person_6_2 = new Person();
		person_6_2.setName( "mom" );
		return person_6_2;
	}

	protected Family family_8_1;

	protected Family buildFamily_8_1()
	{
		if ( family_8_1 != null ) 
		{
			return family_8_1;
		}
		family_8_1 = new Family();
		family_8_1.setDad( person_3_3 );
		return family_8_1;
	}

}
