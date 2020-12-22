package com.example.lang;

import com.advancedpwr.record.factory.BaseFactory;
import com.advancedpwr.samples.LangObjects;
import java.math.BigDecimal;
import java.math.BigInteger;

public class LangFactory extends BaseFactory
{

	protected LangObjects langobjects;

	public LangObjects buildLangObjects()
	{
		if ( langobjects != null ) 
		{
			return langobjects;
		}
		langobjects = new LangObjects();
		langobjects.setBigDecimal( new BigDecimal( "5.3" ) );
		langobjects.setBigInteger( new BigInteger( "3" ) );
		langobjects.setBoolean(  Boolean.TRUE );
		langobjects.setByte( new Byte( (byte)123) );
		langobjects.setCharacter( new Character('c') );
		langobjects.setClassArgument( com.advancedpwr.samples.Person.class );
		langobjects.setDouble( new Double( 12.0) );
		langobjects.setFloat( new Float( 11.0) );
		langobjects.setInteger( new Integer( 5 ) );
		langobjects.setLong( new Long( 16l ) );
		langobjects.setShort( new Short( (short)3) );
		return langobjects;
	}

}
