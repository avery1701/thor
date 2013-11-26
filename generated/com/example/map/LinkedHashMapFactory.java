package com.example.map;

import com.advancedpwr.record.factory.BaseFactory;
import java.util.LinkedHashMap;
import com.advancedpwr.samples.Person;

public class LinkedHashMapFactory extends BaseFactory
{

	protected LinkedHashMap linkedhashmap;

	public LinkedHashMap buildLinkedHashMap()
	{
		if ( linkedhashmap != null ) 
		{
			return linkedhashmap;
		}
		linkedhashmap = new LinkedHashMap();
		linkedhashmap.put( "son", buildLinkedHashMap_2_1() );
		linkedhashmap.put( "dad", person_3_2 );
		linkedhashmap.put( "alias", linkedhashmap_2_1 );
		return linkedhashmap;
	}

	protected Person linkedhashmap_2_1;

	protected Person buildLinkedHashMap_2_1()
	{
		if ( linkedhashmap_2_1 != null ) 
		{
			return linkedhashmap_2_1;
		}
		linkedhashmap_2_1 = new Person();
		linkedhashmap_2_1.setDad( buildPerson_3_2() );
		linkedhashmap_2_1.setMom( buildPerson_7_2() );
		linkedhashmap_2_1.setName( "son" );
		return linkedhashmap_2_1;
	}

	protected Person person_3_2;

	protected Person buildPerson_3_2()
	{
		if ( person_3_2 != null ) 
		{
			return person_3_2;
		}
		person_3_2 = new Person();
		person_3_2.setDad( buildPerson_4_3() );
		person_3_2.setName( "dad" );
		return person_3_2;
	}

	protected Person person_4_3;

	protected Person buildPerson_4_3()
	{
		if ( person_4_3 != null ) 
		{
			return person_4_3;
		}
		person_4_3 = new Person();
		person_4_3.setName( "grandpa" );
		return person_4_3;
	}

	protected Person person_7_2;

	protected Person buildPerson_7_2()
	{
		if ( person_7_2 != null ) 
		{
			return person_7_2;
		}
		person_7_2 = new Person();
		person_7_2.setName( "mom" );
		return person_7_2;
	}

}
