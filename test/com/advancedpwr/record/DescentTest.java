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

import com.advancedpwr.samples.Person;

public class DescentTest extends AbstractRecorderTest
{

	@Override
	protected void setUp()
	{
		// TODO Auto-generated method stub
		super.setUp();
	}

	public void testRecordDescent()
	{
		recorder.setClassName( "com.example.recursion.PersonFactory1" );
		recorder.record( Person.createExamplePerson() );
		assertResult();
	}
	
	public void testRecursion()
	{
		recorder.setClassName( "com.example.recursion.PersonFactory2" );
		Person son = Person.createExamplePerson();
		son.setMom( null );
		// Back to Future situation
		son.getDad().getDad().setDad( son );
		
		recorder.record( son );
		assertResult();
	}
	
	public void testRecursion_2()
	{
		Person son = Person.createExamplePerson();
		son.setMom( null );
		// Back to Future situation
		Person dad = son.getDad();
		Person grandpa = dad.getDad();
		grandpa.setDad( son );
		recorder.setClassName( "com.example.recursion.PersonFactory3" );		
		recorder.record( son );
		assertResult();
	}
	
	public void testStopDescent()
	{
		recorder.setClassName( "com.example.recursion.PersonFactory4" );
		recorder.stopDescent( Person.class );
		recorder.record( Person.createExamplePerson() );
		assertResult();
	}
}
