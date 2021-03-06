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
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import org.junit.jupiter.api.Test;

import com.advancedpwr.samples.ListExample;

public class ListRecorderTest extends AbstractRecorderTest {
	@Test
	public void testWriteObject_list() {
		Vector<String> vector = new Vector<String>();
		vector.add("entry 1");
		vector.add("entry 2");

		ListExample listHolder = new ListExample();
		listHolder.setList(vector);
		recorder.setClassName("com.example.list.ListExampleVectorFactory");
		recorder.record(listHolder);
		assertResult();
	}

	@Test
	public void testSubstitute() {
		recorder.useTypeForInterface(List.class, ArrayList.class);

		MyList<String> vector = new MyList<String>();
		vector.add("entry 1");
		vector.add("entry 2");

		ListExample listHolder = new ListExample();
		listHolder.setList(vector);
		recorder.setClassName("com.example.list.ListExampleSubstitutionFactory");
		recorder.useTypeForInterface(List.class, ArrayList.class);
		recorder.record(listHolder);

		assertResult();
	}

	public void testSubstitute_failure() {
		recorder.useTypeForInterface(List.class, ArrayList.class);

		Vector<String> vector = new Vector<String>();
		vector.add("entry 1");
		vector.add("entry 2");

		ListExample listHolder = new ListExample();
		listHolder.setList(vector);

		try {
			recorder.useTypeForInterface(List.class, HashMap.class);
			fail("Should have thrown an exception");
		} catch (Exception e) {
			assertEquals("class java.util.HashMap cannot be used for interface java.util.List", e.getMessage());
		}

	}
}
