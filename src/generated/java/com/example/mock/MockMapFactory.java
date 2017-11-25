package com.example.mock;

import  static org.easymock.EasyMock.*;
import com.advancedpwr.record.factory.BaseFactory;
import com.advancedpwr.samples.MapContainer;
import com.advancedpwr.samples.Person;
import java.util.LinkedHashMap;

public class MockMapFactory extends BaseFactory
{

	protected MapContainer mapcontainer;

	public MapContainer buildMapContainer()
	{
		if ( mapcontainer != null ) 
		{
			return mapcontainer;
		}
		mapcontainer = createStrictMock( MapContainer.class );
		expect( mapcontainer.getPerson() ).andReturn( buildPerson_1_1() );
		expect( mapcontainer.getMap() ).andReturn( buildLinkedHashMap_2_1() );
		expect( mapcontainer.getMap() ).andReturn( buildLinkedHashMap_2_1() );
		replay( mapcontainer );
		return mapcontainer;
	}

	protected Person person_1_1;

	protected Person buildPerson_1_1()
	{
		if ( person_1_1 != null ) 
		{
			return person_1_1;
		}
		person_1_1 = createStrictMock( Person.class );
		expect( person_1_1.getDad() ).andReturn( buildPerson_3_2() );
		expect( person_1_1.getMom() ).andReturn( buildPerson_5_2() );
		replay( person_1_1 );
		return person_1_1;
	}

	protected Person person_3_2;

	protected Person buildPerson_3_2()
	{
		if ( person_3_2 != null ) 
		{
			return person_3_2;
		}
		person_3_2 = createStrictMock( Person.class );
		expect( person_3_2.getName() ).andReturn( "dad" );
		replay( person_3_2 );
		return person_3_2;
	}

	protected Person person_5_2;

	protected Person buildPerson_5_2()
	{
		if ( person_5_2 != null ) 
		{
			return person_5_2;
		}
		person_5_2 = createStrictMock( Person.class );
		expect( person_5_2.getName() ).andReturn( "mom" );
		replay( person_5_2 );
		return person_5_2;
	}

	protected LinkedHashMap linkedhashmap_2_1;

	protected LinkedHashMap buildLinkedHashMap_2_1()
	{
		if ( linkedhashmap_2_1 != null ) 
		{
			return linkedhashmap_2_1;
		}
		linkedhashmap_2_1 = createStrictMock( LinkedHashMap.class );
		expect( linkedhashmap_2_1.get( "dad" ) ).andReturn( person_3_2 );
		expect( linkedhashmap_2_1.get( "mom" ) ).andReturn( person_5_2 );
		replay( linkedhashmap_2_1 );
		return linkedhashmap_2_1;
	}
}
