/**
 * 
 */
package com.advancedpwr.record.factory;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Locale;

/**
 * @author Matthew Avery, mavery@advancedpwr.com Created: Feb 10, 2012
 *
 */
public class BaseFactoryTest {
	public void testNewInstance() {
		BaseFactory factory = new BaseFactory() {
		};

		Locale locale = (Locale) factory.newInstance(Locale.class);
		assertNotNull(locale);
	}
}
