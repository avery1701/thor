package com.example.lang;

import com.advancedpwr.record.factory.BaseFactory;
import com.advancedpwr.samples.Primitives;

public class PrimitiveFactory extends BaseFactory
{

	protected Primitives primitives;

	public Primitives buildPrimitives()
	{
		if ( primitives != null ) 
		{
			return primitives;
		}
		primitives = new Primitives();
		primitives.setBoolean(  Boolean.TRUE );
		primitives.setByte( new Byte( (byte)123) );
		primitives.setChar( new Character('c') );
		primitives.setDouble( new Double( 12.0) );
		primitives.setFloat( new Float( 11.0) );
		primitives.setInt( new Integer( 5 ) );
		primitives.setLong( new Long( 16l ) );
		primitives.setShort( new Short( (short)3) );
		primitives.setString( "astring" );
		return primitives;
	}

}
