/**
 * 
 */
package com.advancedpwr.record.factory;

import java.util.Locale;

import com.advancedpwr.record.factory.BaseFactory;

import junit.framework.TestCase;

/**
 * @author Matthew Avery, mavery@advancedpwr.com
 * Created: Feb 10, 2012
 *
 */
public class BaseFactoryTest extends TestCase
{
	public void testNewInstance()
	{
		BaseFactory factory = new BaseFactory()
		{
		};
		
		Locale locale = (Locale)factory.newInstance( Locale.class );
		assertNotNull( locale );
	}
}
