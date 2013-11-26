/**
 * 
 */
package com.advancedpwr.record.methods;

import junit.framework.TestCase;

/**
 * @author Matthew Avery, mavery@advancedpwr.com
 * Created: Jan 17, 2012
 *
 */
public class DateBuilderFactoryTest extends TestCase
{
	public void testAccept()
	{
		DateBuilderFactory factory = new DateBuilderFactory();
		assertTrue( factory.accept( java.util.Date.class ) );
		assertTrue( factory.accept( java.sql.Date.class ) );
	}
}
