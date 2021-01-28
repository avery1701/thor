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

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

import com.advancedpwr.samples.Family;
import com.advancedpwr.samples.Person;
import com.advancedpwr.samples.StringArrayHolder;

public class ArrayTest extends AbstractRecorderTest {

	@Test
	public void testArray() {
		Person person = Person.createExamplePerson();
		Person[] array = new Person[] { person.getDad(), person.getMom(), person };
		recorder.setClassName("com.example.array.PersonArrayFactory1");
		recorder.record(array);
		ClassDescriptor defaultDescriptor = recorder.createDefaultDescriptor();
		assertEquals("com.advancedpwr.samples.generated.PersonArrayFactory", defaultDescriptor.getPackageName() + "." + defaultDescriptor.getClassName());
		assertResult();
	}

	@Test
	public void testArray_2() {

		Person person = Person.createExamplePerson();
		Person person2 = Person.createExamplePerson();
		person2.getDad().setName("dad2");
		person2.getMom().setName("mom2");
//		person2.setBirthday( GregorianCalendar.getInstance() );
//		person2.setAnniversary( new Date() );
		Person[] array = new Person[] { person.getDad(), person.getMom(), person, person2, person2.getDad() };
		recorder.setClassName("com.example.array.PersonArrayFactory2");
		recorder.record(array);
		assertResult();
	}

	@Test
	public void testArray_3() {

		Person joe = new Person();
		joe.setName("Joe");
		Person frank = new Person();
		frank.setName("Frank");

//		person2.setBirthday( GregorianCalendar.getInstance() );
//		person2.setAnniversary( new Date() );
		Person[] array = new Person[] { joe, frank, frank };
		recorder.setClassName("com.example.array.PersonArrayFactory3");
		recorder.record(array);
	}

	@Test
	public void testArray_4() {
		Person joe = new Person();
		joe.setName("joe");

		Person dad = new Person();
		dad.setName("dad");

		joe.setDad(dad);

		Person[] array = new Person[] { joe, dad };
		recorder.setClassName("com.example.array.PersonArrayFactory4");
		recorder.record(array);
		assertResult();
	}

	@Test
	public void testArray_recursion() {
		Person joe = new Person();
		joe.setName("joe");

		Person dad = new Person();
		dad.setName("dad");

		joe.setDad(dad);
		dad.setDad(joe);
		Person[] array = new Person[] { joe, dad };
		recorder.setClassName("com.example.array.PersonArrayFactoryRecursion");
		recorder.record(array);
		assertResult();
	}

	@Test
	public void testArray_imports() {
		Person person = Person.createExamplePerson();
		Family family = new Family();
		family.setDad(person.getDad());
		family.setMom(person.getMom());

		Family oldFamily = new Family();
		oldFamily.setDad(person.getDad().getDad());
		Family[] fams = new Family[] { family, oldFamily };
		recorder.setClassName("com.example.array.PersonArrayFactoryImports");
		recorder.record(fams);
		assertResult();
	}

	@Test
	public void testArray_5() {
		StringArrayHolder holder = new StringArrayHolder();
		holder.setArray1(new String[] { "Joe", "Frank" });
		holder.setArray2(new String[] { "Mary", "Jane" });
		recorder.setClassName("com.example.array.ArrayFactory5");
		recorder.record(holder);
		assertResult();
	}

	@Test
	public void testArray_6() throws Exception {
		Person joe = new Person();
		joe.setName("joe");

		Person dad = new Person();
		dad.setName("dad");
		Date anniversary = new SimpleDateFormat("MM/dd/yyyy").parse("12/4/2000");
		dad.setAnniversary(anniversary);
		joe.setDad(dad);

		Person[] array = new Person[] { joe, dad };
		// Force the recorder to default to the ArrayClassDescriptor
//		recorder.setClassName( "com.example.array.PersonArrayFactory6" );
		recorder.record(array);
		assertResult();
	}

	@Test
	public void testArray_string() throws Exception {
		String[] array = new String[] { "Joe", "Fred", "Bob" };
		recorder.setClassName("com.example.array.StringArrayFactory");
		recorder.record(array);
		assertResult();
	}

	@Test
	public void testArray_bytes() throws Exception {
		byte[] array = "Hello World!".getBytes();
		recorder.setClassName("com.example.array.ByteArrayFactory");
		recorder.record(array);
		assertResult();
	}

	@Test
	public void testArray_int() throws Exception {
		int[] array = new int[] { 10, 12, 14 };
		recorder.setClassName("com.example.array.IntArrayFactory");
		recorder.record(array);
		assertResult();
	}
}
