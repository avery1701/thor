package com.example.map;

import com.advancedpwr.record.factory.BaseFactory;
import com.advancedpwr.samples.MapContainer;
import com.advancedpwr.samples.Person;
import java.util.Map;
import java.util.LinkedHashMap;

public class MapFactory1 extends BaseFactory
{

	protected MapContainer mapcontainer;

	public MapContainer buildMapContainer()
	{
		if ( mapcontainer != null ) 
		{
			return mapcontainer;
		}
		mapcontainer = new MapContainer();
		mapcontainer.setPerson( buildPerson_1_1() );
		mapcontainer.setMap( buildLinkedHashMap_9_1() );
		return mapcontainer;
	}

	protected Person person_1_1;

	protected Person buildPerson_1_1()
	{
		if ( person_1_1 != null ) 
		{
			return person_1_1;
		}
		person_1_1 = new Person();
		person_1_1.setDad( buildPerson_2_2() );
		person_1_1.setMom( buildPerson_6_2() );
		person_1_1.setName( "son" );
		return person_1_1;
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

	protected LinkedHashMap linkedhashmap_9_1;

	protected Map buildLinkedHashMap_9_1()
	{
		if ( linkedhashmap_9_1 != null ) 
		{
			return linkedhashmap_9_1;
		}
		linkedhashmap_9_1 = new LinkedHashMap();
		linkedhashmap_9_1.put( "son", person_1_1 );
		linkedhashmap_9_1.put( "dad", person_2_2 );
		linkedhashmap_9_1.put( "mom", person_6_2 );
		linkedhashmap_9_1.put( person_1_1, buildMap_1_10_2() );
		return linkedhashmap_9_1;
	}

	protected Person map_1_10_2;

	protected Person buildMap_1_10_2()
	{
		if ( map_1_10_2 != null ) 
		{
			return map_1_10_2;
		}
		map_1_10_2 = new Person();
		map_1_10_2.setName( "cousin" );
		return map_1_10_2;
	}

}
