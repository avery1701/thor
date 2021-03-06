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
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class ClassWriterTest {
	ClassWriter writer;
	StringWriter out;

	public ClassWriterTest() {
		writer = new ClassWriter() {

			protected Set<Class> classes() {
				return null;
			}

			protected ClassDescriptor createDefaultDescriptor() {
				return null;
			}

			protected void writeObjectBuilderMethod() {}
		};
		out = new StringWriter();
		writer.setWriter(new PrintWriter(out));
	}

	@Test
	public void testGettersSetters() {
		writer.setObject(ClassWriter.class);
		assertEquals(ClassWriter.class, writer.getObject());
	}
	
	@Test
	public void testExtendsClass() {
		writer.setSuperClass(null);
		assertEquals("", writer.extendClass());
		writer.setSuperClass(String.class);
		assertEquals(" extends " + writer.getSuperClass().getSimpleName(), writer.extendClass());
	}
	
	@Test
	public void testWriteLine() {
		writer.writeLine("package com.advancedpwr.foo");
		assertResult("package com.advancedpwr.foo;\n");
	}

	public void assertResult(String inString) {
		assertEquals(inString, out.toString().replaceAll("\r\n", "\n"));
	}

	@Test
	public void testWrite() {
		writer.write("if ( foo == null )");
		assertResult("if ( foo == null )\n");
	}

	@Test
	public void testOpenCloseBrace() {
		writer.openBrace();
		writer.write("if ( foo == null )");
		writer.openBrace();
		writer.writeLine("bar");
		writer.closeBrace();
		writer.closeBrace();

		assertResult("{\n" + "\tif ( foo == null )\n" + "\t{\n" + "\t\tbar;\n" + "\t}\n" + "}\n");

		assertThrows(ClassWriterException.class, () -> {
			writer.closeBrace();
		});
	}

	@Test
	public void testSetClassName() {
		writer.setClassName("com.company.BusinessFactory");
		assertEquals("com.company", writer.getDescriptor().getPackageName());
		assertEquals("BusinessFactory", writer.getDescriptor().getClassName());
	}

}
