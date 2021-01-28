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

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.advancedpwr.samples.MapContainer;
import com.advancedpwr.samples.Person;

public class MapTest extends AbstractMockRecorderTest {

	@Test
	public void testMap() {
		Person person = Person.createExamplePerson();

		Person cousin = new Person();
		cousin.setName("cousin");

		Map<Object, Person> family = new LinkedHashMap<Object, Person>();
		family.put(person.getName(), person);
		family.put(person.getDad().getName(), person.getDad());
		family.put(person.getMom().getName(), person.getMom());
		family.put(person, cousin);

		MapContainer container = new MapContainer();
		container.setPerson(person);
		container.setMap(family);
		recorder.setClassName("com.example.mock.MockMapFactory");

		container = recorder.record(container);

		person = container.getPerson();

		container.getMap().get(person.getDad().getName());
		container.getMap().get(person.getMom().getName());

		recorder.endRecording();
		assertResult();
	}
}