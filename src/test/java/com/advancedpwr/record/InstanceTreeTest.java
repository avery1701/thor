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
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.junit.jupiter.api.Test;

import com.advancedpwr.record.inspect.Inspector;
import com.advancedpwr.samples.BadPerson;
import com.advancedpwr.samples.ListExample;
import com.advancedpwr.samples.ListExampleFactory;
import com.advancedpwr.samples.Person;

public class InstanceTreeTest {
	InstanceTree tree;

	@Test
	public void testGetResults() {
		tree = new InstanceTree(new ListExampleFactory().buildListExample());
		assertEquals(1, tree.getAccessPaths().size());
		AccessPath result = tree.getAccessPaths().get(0);
		assertTrue(result.getResult() instanceof Vector);
	}

	@Test
	public void testClasses() {
		tree = new InstanceTree(new ListExampleFactory().buildListExample());
		assertEquals(3, tree.classes().size());
		assertTrue(tree.classes().contains(ListExample.class));
		assertTrue(tree.classes().contains(Vector.class));
		assertTrue(tree.classes().contains(List.class));
	}

	@Test
	public void testIsTop() {
		Person son = Person.createExamplePerson();

		tree = new InstanceTree(son);
		assertTrue(tree.isTop());
		assertEquals(3, tree.getAccessPaths().size());
	}

	@Test
	public void testInstanceAware() {
		Person son = Person.createExamplePerson();
		// Back to the Future scenario
		son.getDad().getDad().setDad(son);
		tree = new InstanceTree(son);
		System.out.println("top " + tree.getObject() + " : " + tree);
		Map<?, ?> map = tree.getFactory().getTrees();
		boolean foundSonAsParentOfGrandpa = false;
		for (Iterator<?> iterator = map.entrySet().iterator(); iterator.hasNext();) {
			Map.Entry<?, ?> entry = (Map.Entry<?, ?>) iterator.next();
			System.out.println("tree " + entry.getKey() + " : " + entry.getValue());
			if (entry.getKey() instanceof Person) {
				Person person = (Person) entry.getKey();
				if (person.getName().equals("grandpa")) {
					InstanceTree gtree = (InstanceTree) entry.getValue();
					for (Iterator<?> iterator2 = gtree.getAccessPaths().iterator(); iterator2.hasNext();) {
						AccessPath result = (AccessPath) iterator2.next();
						if (result.getResult() instanceof Person) {
							foundSonAsParentOfGrandpa = result.getResult().equals(son);
						}
						System.out.println("result: " + result.getResult());
					}
				}
			}
		}
		assertTrue(foundSonAsParentOfGrandpa);
		// and also we didn't get a stack overflow
	}

	@Test
	public void testInvoke_exception() throws Exception {
		Person person = new BadPerson();

		try {
			tree = new InstanceTree(person);
			fail("should have thrown an exception");
		} catch (RecorderException e) {
			assertTrue(e.getCause() instanceof InvocationTargetException);
		}
	}

	@Test
	public void testDepth() {
		tree = new InstanceTree(new Person());
		assertEquals(0, tree.getDepth());
	}
	
	@Test
	public void testAddInspector() {
		tree = new InstanceTree(new Person());
		assertEquals(4, tree.getInspectors().size());
		tree.addInspector(new Inspector() {

			public void inspect(InstanceTree inTree) {}
		});

		assertEquals(5, tree.getInspectors().size());
	}
}
