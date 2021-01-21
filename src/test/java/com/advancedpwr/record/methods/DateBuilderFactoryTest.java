/**
 * 
 */
package com.advancedpwr.record.methods;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * @author Matthew Avery, mavery@advancedpwr.com Created: Jan 17, 2012
 *
 */
public class DateBuilderFactoryTest {
	@Test
	public void testAccept() {
		DateBuilderFactory factory = new DateBuilderFactory();
		assertTrue(factory.accept(java.util.Date.class));
		assertTrue(factory.accept(java.sql.Date.class));
	}
}
