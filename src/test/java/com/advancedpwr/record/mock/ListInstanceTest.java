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

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.advancedpwr.samples.Person;

public class ListInstanceTest extends AbstractMockRecorderTest {

	@Test
	public void testListInstance() {
		Person dad = new Person();
		dad.setName("dad");

		Person jack = new Person();
		jack.setName("jack");
		jack.setDad(dad);

		Person jill = new Person();
		jill.setName("Jill");
		jill.setDad(dad);

		dad.setMom(jill);

		Person joe = new Person();
		joe.setName("joe");
		joe.setDad(dad);
		joe.setMom(jill);

		List<Person> list = new ArrayList<Person>();
		list.add(jack);
		list.add(jill);
		list.add(joe);
		dad.setChildren(list);

		dad = recorder.record(dad);

		List<?> children = dad.getChildren();

		Person child1 = (Person) children.get(0);
		assertEquals("jack", child1.getName());
//		Person dadTest = child1.getDad();
//		assertEquals( dad, child1.getDad() );

		recorder.setClassName("com.example.list.ListInstanceFactory");
		recorder.endRecording();
		assertResult();
	}
}
