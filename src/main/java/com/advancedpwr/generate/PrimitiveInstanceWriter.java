package com.advancedpwr.generate;

import static com.advancedpwr.record.ClassWriter.SPACE;

import java.lang.reflect.Parameter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.Random;

import com.advancedpwr.record.ClassWriter;

public class PrimitiveInstanceWriter extends BaseInstanceWriter
{


	public PrimitiveInstanceWriter( ClassWriter inWriter )
	{
		super( inWriter );
	}

	public boolean writeInstance( Class inClass )
	{
		setInstanceClass( inClass );
		return writePrimitiveInstance();
	}

	public boolean writePrimitiveInstance()
	{
		if ( isPrimitive() )
		{
			writeLine( instanceType() + SPACE + getInstanceName() + " = " + primitiveValue() );
			return true;
		}
		return false;
	}

	public boolean writeInstance( Parameter param )
	{
		setInstanceClass( param.getType() );
		setInstanceName( param.getName() );
		return writePrimitiveInstance();
	}

	protected String primitiveValue()
	{
		if ( getInstanceClass().equals( String.class ) )
		{
			return "\"" + randomString() + "\"";
		}
		if ( getInstanceClass().equals( Date.class ) )
		{
			return "new Date()";
		}
		if ( getInstanceClass().equals( long.class ) || getInstanceClass().equals( Long.class ) )
		{
			return randomInt() + "l";
		}
		if ( getInstanceClass().equals( int.class ) || getInstanceClass().equals( Integer.class ) )
		{
			return randomInt();
		}
		if ( getInstanceClass().equals( float.class ) || getInstanceClass().equals( Float.class ) )
		{
			return randomFloat();
		}
		if ( getInstanceClass().equals( double.class )
				|| getInstanceClass().equals( Double.class ) )
		{
			return randomFloat() + "d";
		}
		if ( getInstanceClass().equals( boolean.class ) || getInstanceClass().equals( Boolean.class ) )
		{
			return "true";
		}
		if ( getInstanceClass().equals( BigDecimal.class ) )
		{
			return "new BigDecimal(" + randomFloat() + " )";
		}
		if ( getInstanceClass().equals( BigInteger.class ) )
		{
			return "new BigInteger(" + randomInt() + " )";
		}
		return null;
	}

	protected String randomFloat()
	{
		Random rnd = new Random();
		return String.valueOf( rnd.nextFloat() );
	}

	protected String randomInt()
	{
		Random rnd = new Random();
		return String.valueOf( rnd.nextInt() );
	}

	protected String randomString()
	{
		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while ( salt.length() < 18 )
		{ // length of the random string.
			int index = (int) ( rnd.nextFloat() * SALTCHARS.length() );
			salt.append( SALTCHARS.charAt( index ) );
		}
		String saltStr = salt.toString();
		return saltStr;
	}

	protected String instanceType()
	{
		return getInstanceClass().getSimpleName();
	}

	public String instanceName()
	{
		return instanceType().toLowerCase();
	}

	protected boolean isPrimitive()
	{
		return getInstanceClass().isPrimitive() || getInstanceClass().equals( String.class )
				|| getInstanceClass().equals( BigDecimal.class )
				|| getInstanceClass().equals( BigInteger.class )
				|| getInstanceClass().equals( Boolean.class )
				|| getInstanceClass().equals( Double.class )
				|| getInstanceClass().equals( Float.class )
				|| getInstanceClass().equals( Integer.class )
				|| getInstanceClass().equals( Long.class );
	}

}
