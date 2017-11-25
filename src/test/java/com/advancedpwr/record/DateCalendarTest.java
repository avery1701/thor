/*
 * Copyright 2011 Matthew Avery, mavery@advancedpwr.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.advancedpwr.record;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.advancedpwr.samples.Person;

public class DateCalendarTest extends AbstractRecorderTest
{

	
	protected void setUp()
	{
		setWriteFiles();
		super.setUp();
	}

	public void testRecordPerson() throws Exception
	{
		Person person = Person.createExamplePerson();
		Person dad = person.getDad();
		Calendar calendar = GregorianCalendar.getInstance();
		calendar.setTimeInMillis( 123456789 );
		dad.setBirthday( calendar );
		dad.setAnniversary( new Date( 987654321 ) );
		recorder.setClassName( "com.example.date.PersonFactory1" );
		recorder.record( person );
		assertResult();
	}

	
	public void testRecordPerson_sql_date() throws Exception
	{
		Person person = Person.createExamplePerson();
		Person dad = person.getDad();
		Calendar calendar = GregorianCalendar.getInstance();
		calendar.setTimeInMillis( 123456789 );
		dad.setBirthday( calendar );
		dad.setAnniversary( new java.sql.Date( 987654321 ) );
		recorder.setClassName( "com.example.date.PersonFactory2" );
		recorder.record( person );
		assertResult();
	}
}