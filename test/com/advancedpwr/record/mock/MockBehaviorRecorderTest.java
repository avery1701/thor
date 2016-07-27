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

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

import com.advancedpwr.record.SimpleClassDescriptor;
//import com.advancedpwr.record.examples.generated.PersonFactory;
import com.advancedpwr.samples.Being;
import com.advancedpwr.samples.Family;
import com.advancedpwr.samples.Person;
import com.advancedpwr.samples.PersonMaker;

public class MockBehaviorRecorderTest extends AbstractMockRecorderTest
{
	
	protected void setUp()
	{
		super.setUp();
	}
	
	public void testRecord()
	{
		SimpleClassDescriptor descriptor = new SimpleClassDescriptor();
		descriptor.setClassName( "MockPersonFactory" );
		descriptor.setPackageName( "com.example.mock" );
		recorder.setDescriptor( descriptor );
		
		Person person = new Person();
		
		person = recorder.record( person );
		
		person.setName( "Joe" );
		person.getName();
		
		person = (Person)recorder.endRecording();
		assertResult();
	}

	
	public void testRecord_2()
	{
		recorder.setClassName( "com.example.mock.MockPersonFactory2" );
		Person person = new Person();
		
		Person dad = new Person();
		dad.setName( "dad" );
		person.setDad( dad );
		
		person = recorder.record( person );
		
		person.setName( "Joe" );
		assertEquals( "Joe", person.getName() );
		assertEquals( "dad", person.getDad().getName() );
		assertEquals( "dad", person.getDad().getName() );
		
		Person mom = new Person();
		mom.setName( "mom" );
		person.setMom( mom );
		
		assertEquals( "mom", person.getMom().getName() );
		
		person.setMom( mom );
		
		person.setMom( null );
		assertNull( person.getMom() );
		
		person = (Person)recorder.endRecording();
		
		assertResult();
	}
	
	public void testRecord_3()
	{
		
		Person person = Person.createExamplePerson();
		recorder.setClassName( "com.example.mock.MockPersonFactory3" );
		
		person = recorder.record( person );
		
		Person gramps = person.getDad().getDad();
		
		assertEquals( "grandpa", gramps.getName() );
		gramps.setName( "Grandpa Joe" );
		assertEquals( "Grandpa Joe", gramps.getName() );
		
		person = (Person)recorder.endRecording();
		assertResult();
	}
	
	public void testRecord_4()
	{
		
		Person person = Person.createExamplePerson();
		Family family = new Family(person.getDad(), person.getMom());
		recorder.setClassName( "com.example.mock.MockPersonFactory4" );

		family = recorder.record( family );
		
		family.setParents( person.getDad(), person.getMom() ); 
		
		recorder.endRecording();
		assertResult();
	}
	
	public void testRecord_5()
	{
		
		Person person = Person.createExamplePerson();
		Family family = new Family(person.getDad(), person.getMom());
		recorder.setClassName( "com.example.mock.MockPersonFactory5" );

		family = recorder.record( family );
		
		try
		{
			family.fued();
		}
		catch ( Exception e )
		{
			
		} 
		
		recorder.endRecording();
		assertResult();
	}
	
	public void testRecord_6()
	{
		
		Person person = Person.createExamplePerson();
		Family family = new Family(person.getDad(), person.getMom());
		recorder.setClassName( "com.example.mock.MockPersonFactory6" );

		family = recorder.record( family );
		
		try
		{
			family.fued( new Person() );
		}
		catch ( Exception e )
		{
			
		} 
		
		recorder.endRecording();
		assertResult();
	}

	public void testRecordNice()
	{
		
		Person person = Person.createExamplePerson();
		Family family = new Family(person.getDad(), person.getMom());
		recorder.setNice( true );
		recorder.setClassName( "com.example.mock.NiceMockFactory" );
		family = recorder.record( family );
		
		try
		{
			family.fued( new Person() );
		}
		catch ( Exception e )
		{
			
		} 
		recorder.endRecording();
		assertResult();
	}
	
//	public void testRecord_Object()
//	{
//		Object object = new Object();
//		
//		Object instrumented = recorder.record( object );
//		assertTrue( instrumented.equals( object ) );
//		// this is a bug.  Need to mock hashCode() as well
////		assertEquals( object, instrumented );
//		recorder.endRecording();
//		assertResult( "" );
//	}
	
	// This is a known issue and I'm not sure how to handle it correctly.
	public void XtestRecordRestricted() 
	{
		Person person = Person.createExamplePerson();
		Family family = new Family();
		family.setDad( person );
		family = recorder.record( family );
		
		family.getDad().getRestricted();
		family.getDad().callSynced();
		
		recorder.endRecording();
		
		assertResult(  "package com.advancedpwr.record.examples.generated;\n" + 
				"\n" + 
				"import com.advancedpwr.record.examples.Family;\n" + 
				"import com.advancedpwr.record.examples.Person;\n" + 
				"import com.advancedpwr.record.examples.Restricted$1;\n" + 
				"import com.advancedpwr.record.mock.MockFactory;\n" + 
				"\n" + 
				"public class FamilyFactory extends MockFactory\n" + 
				"{\n" + 
				"\n" + 
				"	protected Family family;\n" + 
				"\n" + 
				"	public Family buildFamily()\n" + 
				"	{\n" + 
				"		if ( family != null ) \n" + 
				"		{\n" + 
				"			return family;\n" + 
				"		}\n" + 
				"		family = createStrictMock( Family.class );\n" + 
				"		expect( family.getDad() ).andReturn( buildPerson_1_1() );\n" + 
				"		expect( family.getDad() ).andReturn( buildPerson_1_1() );\n" + 
				"		replay( family );\n" + 
				"		return family;\n" + 
				"	}\n" + 
				"\n" + 
				"	protected Person person_1_1;\n" + 
				"\n" + 
				"	protected Person buildPerson_1_1()\n" + 
				"	{\n" + 
				"		if ( person_1_1 != null ) \n" + 
				"		{\n" + 
				"			return person_1_1;\n" + 
				"		}\n" + 
				"		person_1_1 = createStrictMock( Person.class );\n" +  
				"		person_1_1.callSynced();\n" + 
				"		replay( person_1_1 );\n" + 
				"		return person_1_1;\n" + 
				"	}\n" + 
				"\n" + 
				"}\n");
	}
	
	public void testEquals()
	{
		Person person = Person.createExamplePerson();	
		Person proxy = recorder.record( person );
		assertTrue( proxy.equals( person ) );
	}
	
	public void testHashCode()
	{
		Person person = Person.createExamplePerson();
		
		Person proxy = recorder.record( person );
		assertEquals( person.hashCode(), proxy.hashCode() );
	}
	
	public void testInstrument()
	{
		Person person = Person.createExamplePerson();
		recorder.instrument( person );
	}
	
	public void testAddPreferredInterface()
	{
		recorder.setClassName( "com.example.mock.MockPreferredInterfaceFactory" );

		recorder.addPreferredInterface( Being.class );
		Person person = Person.createExamplePerson();
		
		Being being = recorder.record( person );
		
		being.getDad();
		being.getMom();
		
		recorder.endRecording();
		
		assertResult();
	}
	
	public void testInterfacesArePublic()
	{
		Being privatePerson = PersonMaker.createPrivatePerson();
		
		assertFalse( recorder.isPublic( privatePerson ) );
		recorder.addPreferredInterface( Being.class );
		assertTrue( recorder.isPublic( privatePerson ) );
	}
	
	public void testOutputStream_preferred_class() throws Exception
	{
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		recorder.addPreferredInterface( OutputStream.class );
		recorder.setClassName( "com.example.mock.MockPreferredClassFactory" );

		out = recorder.record( out );
	
		out.write( "Hello world".getBytes() );
		out.flush();
		out.close();
		recorder.endRecording();
		assertResult();
	}
	public void XtestRecordJavadocExample()
	{
		MockBehaviorRecorder recorder = new MockBehaviorRecorder();
		recorder.setDestination( "generated" );
		
		Person person = new Person();
		
		Person dad = new Person();
		dad.setName( "dad" );
		person.setDad( dad );
		
		person = recorder.record( person );
		
		person.setName( "Joe" );
		assertEquals( "Joe", person.getName() );
		assertEquals( "dad", person.getDad().getName() );
		assertEquals( "dad", person.getDad().getName() );
		
		Person mom = new Person();
		mom.setName( "mom" );
		person.setMom( mom );
		
		recorder.endRecording();
		
	}
	
//	public void XtestPlaybackJavadocExample()
//	{
//		Person person = new PersonFactory().buildPerson();
//		
//		person.setName( "Joe" );
//		assertEquals( "Joe", person.getName() );
//		assertEquals( "dad", person.getDad().getName() );
//		assertEquals( "dad", person.getDad().getName() );
//		
//		Person mom = new Person();
//		mom.setName( "mom" );
//		person.setMom( mom );
//	}
}
