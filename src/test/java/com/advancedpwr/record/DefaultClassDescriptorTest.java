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

import org.junit.jupiter.api.Test;

import com.advancedpwr.samples.ListExample;

public class DefaultClassDescriptorTest {
	DefaultClassDescriptor descriptor;

	public DefaultClassDescriptorTest() {
		descriptor = new DefaultClassDescriptor();
		descriptor.setClass(ListExample.class);
	}

	@Test
	public void testDefaultClassDescriptorClass() {
		descriptor = new DefaultClassDescriptor(String.class);
		assertEquals(String.class, descriptor.subject());
	}

	@Test
	public void testSubject() {
		assertEquals(ListExample.class, descriptor.subject());
	}

	@Test
	public void testGetClassName() {
		assertEquals("ListExampleFactory", descriptor.getClassName());
	}

	@Test
	public void testGetPackageName() {
		assertEquals("com.advancedpwr.samples.generated", descriptor.getPackageName());
	}

	@Test
	public void testToString() {
		assertEquals("com.advancedpwr.samples.generated.ListExampleFactory", descriptor.toString());
	}

}
