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
package com.advancedpwr.record.mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

import com.advancedpwr.samples.Family;
import com.advancedpwr.samples.People;
import com.advancedpwr.samples.Person;

public class ArrayTest extends AbstractMockRecorderTest {

	@Test
	public void testArray() {
		Person person = Person.createExamplePerson();
		Person[] array = new Person[] { person.getDad(), person.getMom(), person };
		assertEquals("mom", array[1].getName());

		recorder.setClassName("com.example.array.mock.ArrayFactory");
		array = recorder.record(array);
//		System.out.println( array[0].getName() );
//		System.out.println( array[1].getName() );
//		System.out.println( array[2].getName() );
		assertEquals("mom", array[1].getName());

		recorder.endRecording();
		assertResult();
	}

	@Test
	public void testArray_argument() {
		Person person = Person.createExamplePerson();
		Family family = new Family(person.getDad(), person.getMom());
		recorder.setClassName("com.example.array.mock.ArrayArgumentFactory");
		family = recorder.record(family);
		Person[] children = family.people(new String[] { "Frank", "Joe" });
		assertEquals("Frank", children[0].getName());
		assertEquals("Joe", children[1].getName());

		recorder.endRecording();
		assertResult();
	}

	@Test
	public void testArray_null_element() {
		Person person = Person.createExamplePerson();
		Family family = new Family(person.getDad(), person.getMom());
		recorder.setClassName("com.example.array.mock.ArrayNullElementFactory");
		family = recorder.record(family);
		Person[] children = family.people(new String[] { "Frank", null });
		assertEquals(2, children.length);
		assertEquals("Frank", children[0].getName());

		recorder.endRecording();
		assertResult();
	}

	@Test
	public void testArray_exception() {
		Person person = Person.createExamplePerson();
		Family family = new Family(person.getDad(), person.getMom());
		Family family2 = new Family(person.getDad(), new Person());
		Family[] families = new Family[] { family, family2 };
		recorder.setClassName("com.example.array.mock.ArrayExceptionFactory");
		families = recorder.record(families);

		try {
			families[0].fued();
		} catch (Exception e) {
			e.getMessage();
		}

		recorder.endRecording();
		assertResult();

	}

	@Test
	public void testArray_exception_2() throws Exception {
		Person person = Person.createExamplePerson();
		Person[] folks = new Person[] { person.getDad(), person.getMom() };
		People people = new People();
		people.setPersons(folks);
		recorder.setClassName("com.example.array.mock.ArrayException2Factory");
		people = recorder.record(people);

		Date anniversary = new SimpleDateFormat("MM/dd/yyyy").parse("12/4/2000");
		people.getPersons()[0].setAnniversary(anniversary);

		recorder.endRecording();
		assertResult();

	}

	@Test
	public void testArrayPrimitive() {
		int[] array = { 5, 4, 3, 2, 1 };
		int[] newArray = recorder.record(array);
		assertEquals(4, newArray[1]);
	}

	@Test
	public void testCanInstrumentArray() {
		int[] array = { 5, 4, 3, 2, 1 };
		assertFalse(recorder.canInstrumentArray(null));
		assertFalse(recorder.canInstrumentArray(array));
		Person person = Person.createExamplePerson();
		Person[] folks = new Person[] { person.getDad(), person.getMom() };
		assertTrue(recorder.canInstrumentArray(folks));

	}
}
