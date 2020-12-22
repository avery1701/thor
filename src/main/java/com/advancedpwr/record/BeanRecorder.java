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

import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import com.advancedpwr.record.factory.BaseFactory;
import com.advancedpwr.record.methods.BuildMethodWriter;
import com.advancedpwr.record.methods.CollectionBuilderFactory;
import com.advancedpwr.record.methods.EnumBuilderFactory;
import com.advancedpwr.record.methods.MapBuilderFactory;
import com.advancedpwr.record.methods.MethodBuilderFactory;
import com.advancedpwr.record.methods.MethodWriterFactory;

/**
 * An {@link ObjectRecorder} that records the <i>state</i> of an object tree as a Java class file. This recorder uses 
 * reflection to inspect an object tree for Java Bean style setter / getter accessor methods, therefore it is only 
 * capable of reconstructing an object tree through that convention.  Many web service return data structures adhere
 * to the Java Bean accessor convention, so this class may be of use in recording a web service response for use in 
 * unit testing.
 * <p>
 * Recording example:
 * </p>
 *<p><blockquote><pre>
	Person person = new Person();
	person.setName( "Jim" );
	Person dad = new Person();
	dad.setName( "John" );
	person.setDad( dad );
	
	BeanRecorder recorder = new BeanRecorder();
	recorder.setDestination( "recordings" );
	recorder.record( person );
 * </pre></blockquote></p>
 * 
 * The above example will record the object tree of the "person" instance as a Java class:
 * 
 * <p><blockquote><pre>
  	public class PersonFactory
	{
	
		protected Person person;
	
		public Person buildPerson()
		{
			person = new Person();
			person.setDad( buildPerson_1_1() );
			person.setName( "Jim" );
			return person;
		}
	
		protected Person person_1_1;
	
		protected Person buildPerson_1_1()
		{
			dad_1_1 = new Person();
			dad_1_1.setName( "John" );
			return person_1_1;
		}
	
	}
 * </pre></blockquote></p>
 * 
 * To reconstruct the instance of "person" in a unit test:
 * 
 * <p><blockquote><pre>
  	Person person = new PersonFactory().buildPerson();
 * </pre></blockquote></p>
 * 
 * The BeanRecorder is "instance aware" and supports {@link Collection} and {@link Map} objects.
 * 
 * @author Matthew Avery, mavery@advancedpwr.com on Jun 22, 2010
 *
 */
public class BeanRecorder extends AbstractRecorder
{
	protected InstanceTree fieldInstanceTree;
	protected MethodBuilderFactory fieldFactoryBuilder;
	protected Set<Class> fieldStopClasses;
	protected Map<Class,Class> fieldClassesForInterfaces;
	
	public BeanRecorder()
	{
		setSuperClass( BaseFactory.class );
	}
	/**
	 * Use this method to substitute one class for another if they both implement the same interface.
	 * For example, if an object has an instance of a java.util.Vector, use this method to force the 
	 * recorder to record the list as a java.util.ArrayList, e.g.
	 * 
	 * 	<code>useTypeForInterface( List.class, ArrayList.class );</code>
	 * 
	 * @param inInterface
	 * @param inClass
	 */
	public void useTypeForInterface( Class inInterface, Class inClass )
	{
		if ( !inInterface.isAssignableFrom( inClass ) )
		{
			throw new RuntimeException( inClass + " cannot be used for " + inInterface );
		}
		getClassesForInterfaces().put( inInterface, inClass );
		
	}
	protected void setObject( Object object )
	{
		if ( object == null )
		{
			throw new RecorderException( "Called setObject with null argument");
		}
		fieldInstanceTree = createInstanceTree( object );
	}

	protected InstanceTree createInstanceTree( Object object )
	{
		return new InstanceTree( getStopClasses(), getClassesForInterfaces(), object );
	}

	/* (non-Javadoc)
	 * @see com.advancedpwr.record.ObjectRecorder#record(java.lang.Object)
	 */
	public <T> T record( T inObject )
	{
		setObject( inObject );
		writeObject();
		closeFile();
		return inObject;
	}
	

	protected void writeObjectBuilderMethod()
	{
		AccessPath result = new AccessPath();
		result.setTree( getInstanceTree() );
		BuildMethodWriter builder = createMethodBuilder( result );
		builder.setScopePublic();
		builder.buildMethod();
	}

	protected BuildMethodWriter createMethodBuilder( AccessPath result )
	{
		BuildMethodWriter builder = getFactoryBuilder().createMethodBuilder( result );
		builder.setClassWriter( this );
		return builder;
	}
	
	protected Object getObject()
	{
		return getInstanceTree().getObject();
	}

	protected InstanceTree getInstanceTree()
	{
		return fieldInstanceTree;
	}

	protected Set<Class> classes()
	{
		Set<Class> classes = new LinkedHashSet<Class>();
		if ( getSuperClass() != null )
		{
			classes.add( getSuperClass() );
		}
		classes.addAll( getInstanceTree().getFactory().classes() );
		if ( classes.contains( java.util.Date.class ) && classes.contains( java.sql.Date.class ) )
		{
			classes.remove( java.sql.Date.class );
		}
		return classes;
	}
	
	protected MethodBuilderFactory getFactoryBuilder()
	{
		if ( fieldFactoryBuilder == null )
		{
			fieldFactoryBuilder = createMethodBuilderFactory();
			
		}
		return fieldFactoryBuilder;
	}

	protected MethodBuilderFactory createMethodBuilderFactory()
	{
		MethodBuilderFactory factory = new MethodBuilderFactory();
		factory.addBuilderFactory( new CollectionBuilderFactory() );
		factory.addBuilderFactory( new MapBuilderFactory() );
		factory.addBuilderFactory( new EnumBuilderFactory() );
		return factory;
	}
	
	public void addBuilderFactory( MethodWriterFactory inFactory )
	{
		getFactoryBuilder().addBuilderFactory( inFactory );
	}
	
	public void stopDescent( Class inClass )
	{
		getStopClasses().add( inClass );
	}
	
	public Set getStopClasses()
	{
		if ( fieldStopClasses == null )
		{
			fieldStopClasses = new HashSet();
			fieldStopClasses.add( Date.class );
			fieldStopClasses.add( java.sql.Date.class );
			fieldStopClasses.add( Calendar.class );
			fieldStopClasses.add( GregorianCalendar.class );
		}
		return fieldStopClasses;
	}
	
	public Map getClassesForInterfaces()
	{
		if( fieldClassesForInterfaces == null )
		{
			fieldClassesForInterfaces = new HashMap();
		}
		return fieldClassesForInterfaces;
	}
	
}
