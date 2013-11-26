/**
 * 
 */
package com.advancedpwr.record.factory;

import org.objenesis.Objenesis;
import org.objenesis.ObjenesisStd;

/**
 * @author Matthew Avery, mavery@advancedpwr.com
 * Created: Feb 6, 2012
 *
 *	The resulting factories will have no dependencies.
 */
public abstract class BaseFactory
{
	protected Objenesis fieldObjenesis;
	
	protected Object newInstance( Class inClass )
	{
		return objenesis().newInstance( inClass );
	}
	
	protected Objenesis objenesis()
	{
		if ( fieldObjenesis == null )
		{
			fieldObjenesis = new ObjenesisStd();
		}
		return fieldObjenesis;
	}
}
