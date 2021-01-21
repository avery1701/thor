package com.advancedpwr.record.methods;

import java.util.Date;

import org.junit.jupiter.api.Test;

import com.advancedpwr.record.BeanRecorderTest;

public class DateBuilderTest extends BeanRecorderTest {

	@Test
	public void testSameDateInstance() {
		DateHolder dateHolder = new DateHolder();
		Date date = new Date(1234567689);

		dateHolder.setDate(date);
		dateHolder.setOtherDate(date);
		recorder.setClassName("com.example.methods.DateHolderFactory");
		recorder.record(dateHolder);
		assertResult();

	}
}
