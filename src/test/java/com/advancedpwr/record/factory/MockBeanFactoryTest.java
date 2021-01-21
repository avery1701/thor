package com.advancedpwr.record.factory;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Locale;

import org.junit.jupiter.api.Test;

public class MockBeanFactoryTest {

	@Test
	public void testNewInstance() {
		MockBeanFactory factory = new MockBeanFactory() {
		};

		Locale locale = (Locale) factory.newInstance(Locale.class);
		assertNotNull(locale);
	}

}
