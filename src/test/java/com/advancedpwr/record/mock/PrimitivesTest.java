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

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.advancedpwr.samples.LangObjects;
import com.advancedpwr.samples.Person;
import com.advancedpwr.samples.Primitives;

public class PrimitivesTest extends AbstractMockRecorderTest {

	@Test
	public void testPrimitives() {
		Primitives primitives = new Primitives();
		recorder.setClassName("com.example.mock.PrimitiveFactory");
		primitives = recorder.record(primitives);
		primitives.setChar('c');
		primitives.setDouble(12d);
		primitives.setFloat(11f);
		primitives.setInt(5);
		primitives.setLong(16l);
		primitives.setShort((short) 3);
		primitives.setString("astring");
		primitives.setBoolean(true);
		primitives.setByte((byte) 123);
		primitives.getInt();
		recorder.endRecording();
		assertResult();
	}

	@Test
	public void testPrimitives2() {
		List<Primitives> list = new ArrayList<Primitives>();
		Primitives primitives = new Primitives();
		list.add(primitives);
		recorder.setClassName("com.example.mock.PrimitiveFactory2");
		list = recorder.record(list);
		primitives = (Primitives) list.get(0);

		primitives.setChar('c');
		primitives.setDouble(12d);
		primitives.setFloat(11f);
		primitives.setInt(5);
		primitives.setLong(16l);
		primitives.setShort((short) 3);
		primitives.setString("astring");
		primitives.setBoolean(false);
		primitives.setByte((byte) 123);

		primitives.getInt();
		recorder.endRecording();

		assertResult();
	}

	@Test
	public void testLangObjects() {
		recorder.setClassName("com.example.mock.LangFactory");

		LangObjects langs = new LangObjects();
		langs = recorder.record(langs);
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
		recorder.endRecording();
		assertResult();
	}

}
