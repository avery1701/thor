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
package com.advancedpwr.record.methods;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.junit.jupiter.api.Test;

import com.advancedpwr.record.AbstractRecorderTest;
import com.advancedpwr.samples.LangObjects;
import com.advancedpwr.samples.Person;
import com.advancedpwr.samples.Primitives;

public class PrimitivesTest extends AbstractRecorderTest {

	@Test
	public void testPrimitives() {
		Primitives primitives = new Primitives();
		primitives.setChar('c');
		primitives.setDouble(12d);
		primitives.setFloat(11f);
		primitives.setInt(5);
		primitives.setLong(16l);
		primitives.setShort((short) 3);
		primitives.setString("astring");
		primitives.setBoolean(true);
		primitives.setByte((byte) 123);

		recorder.setClassName("com.example.lang.PrimitiveFactory");
		recorder.record(primitives);
		assertResult();
	}

	@Test
	public void testPrimitives2() {
		Primitives primitives = new Primitives();
		primitives.setChar('c');
		primitives.setDouble(12d);
		primitives.setFloat(11f);
		primitives.setInt(5);
		primitives.setLong(16l);
		primitives.setShort((short) 3);
		primitives.setString("astring");
		primitives.setBoolean(false);
		primitives.setByte((byte) 123);

		recorder.setClassName("com.example.lang.PrimitiveFactory2");
		recorder.record(primitives);
		assertResult();
	}

	@Test
	public void testLangObjects() {
		LangObjects langs = new LangObjects();
		langs.setCharacter('c');
		langs.setDouble(12d);
		langs.setFloat(11f);
		langs.setInteger(5);
		langs.setLong(16l);
		langs.setShort((short) 3);
		langs.setBoolean(true);
		langs.setByte((byte) 123);
		langs.setClassArgument(Person.class);
		langs.setBigDecimal(new BigDecimal("5.3"));
		langs.setBigInteger(new BigInteger("3"));
		recorder.setClassName("com.example.lang.LangFactory");
		recorder.record(langs);
		assertResult();
	}

}
