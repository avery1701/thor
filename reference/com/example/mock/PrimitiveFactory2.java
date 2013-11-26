package com.example.mock;

import java.util.ArrayList;
import com.advancedpwr.samples.Primitives;
import com.advancedpwr.record.factory.MockFactory;

public class PrimitiveFactory2 extends MockFactory
{

	protected ArrayList arraylist;

	public ArrayList buildArrayList()
	{
		if ( arraylist != null ) 
		{
			return arraylist;
		}
		arraylist = createStrictMock( ArrayList.class );
		expect( arraylist.get( new Integer( 0 ) ) ).andReturn( buildPrimitives_1_1() );
		replay( arraylist );
		return arraylist;
	}

	protected Primitives primitives_1_1;

	protected Primitives buildPrimitives_1_1()
	{
		if ( primitives_1_1 != null ) 
		{
			return primitives_1_1;
		}
		primitives_1_1 = createStrictMock( Primitives.class );
		primitives_1_1.setChar( new Character('c') );
		primitives_1_1.setDouble( new Double( 12.0) );
		primitives_1_1.setFloat( new Float( 11.0) );
		primitives_1_1.setInt( new Integer( 5 ) );
		primitives_1_1.setLong( new Long( 16l ) );
		primitives_1_1.setShort( new Short( (short)3) );
		primitives_1_1.setString( "astring" );
		primitives_1_1.setBoolean( Boolean.FALSE );
		primitives_1_1.setByte( new Byte( (byte)123) );
		expect( primitives_1_1.getInt() ).andReturn( new Integer( 5 ) );
		replay( primitives_1_1 );
		return primitives_1_1;
	}
}
