/**
 * 
 */
package com.advancedpwr.record.methods;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.advancedpwr.record.descriptor.JavaClassDescriptor;

/**
 * @author Matthew Avery, mavery@advancedpwr.com Created: Jan 17, 2012
 *
 */
public class DateBuilderFactoryTest
{
	@Test
	public void testAccept()
	{
		DateBuilderFactory factory = new DateBuilderFactory();
		JavaClassDescriptor descp1 = new JavaClassDescriptor( java.util.Date.class );
		JavaClassDescriptor descp2 = new JavaClassDescriptor( java.sql.Date.class );
		assertTrue( factory.accept(descp1) );
		assertTrue( factory.accept( descp2 ) );
	}
}
