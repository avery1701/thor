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

import java.util.ArrayList;
import java.util.List;

import com.advancedpwr.samples.Person;

public class ListInstanceTest extends AbstractRecorderTest
{
	@Override
	protected void setUp()
	{
		setWriteFiles();
		super.setUp();
	}

	public void testListInstance()
	{
		Person dad = new Person();
		dad.setName( "dad" );
		
		Person jack = new Person();
		jack.setName( "jack" );
		jack.setDad( dad );
		
		Person jill = new Person();
		jill.setName( "Jill" );
		jill.setDad( dad );
		
		dad.setMom( jill );
		
		Person joe = new Person();
		joe.setName( "joe" );
		joe.setDad( dad );
		joe.setMom( jill );
		
		List list = new ArrayList();
		list.add( jack );
		list.add( jill );
		list.add( joe );
		dad.setChildren( list );
		
		recorder.setClassName( "com.example.list.PersonListFactory" );
		recorder.record( dad );
		assertResult();
	}
}
