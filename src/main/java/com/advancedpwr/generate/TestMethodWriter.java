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
package com.advancedpwr.generate;

import static com.advancedpwr.record.ClassWriter.PUBLIC;
import static com.advancedpwr.record.ClassWriter.SPACE;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.advancedpwr.record.ClassWriter;
import com.advancedpwr.record.ClassWriterDelagate;

public class TestMethodWriter extends ClassWriterDelagate
{

	protected TestWriter fieldTestWriter;
	protected Method fieldMethod;
	protected Method fieldAccessor;

	public Method getMethod()
	{
		return fieldMethod;
	}

	public void setMethod( Method method )
	{
		fieldMethod = method;
	}

	public void buildMethod()
	{
//		System.out.println( "writing " + returnType() + SPACE + resultBuilder() + " : " + toString() );
		newLine();
		write("@Test");
		writeMethodSignature();
		openBrace();
		writeInstance();
		writeMethodArguments();
		writeTestMethod();
		writeAccessorAssertion();
//		writeAssertions();
		closeBrace();
		
	}
	
	protected void writeMethodArguments()
	{
		Parameter[] params = getMethod().getParameters();
	
		for ( Parameter param : params )
		{
			new InstanceWriterFactory().writeInstance( getTestWriter(), param );
		}
	}
	
	protected void writeTestMethod()
	{
		StringBuilder sb = new StringBuilder();
		sb.append( "(" );
		Parameter[] params = getMethod().getParameters();
		if ( params.length == 0 )
		{
			sb.append( ")" );
		}
		for ( Parameter param : params )
		{
			sb.append( param.getName() );
			sb.append(",");
		}
		String parameters = sb.toString().replaceAll( ",$", ")" );
		writeLine( getTestWriter().instanceName() + "." +  getMethod().getName() + parameters);
	}
	
	protected void writeAccessorAssertion()
	{
		Parameter[] params = getMethod().getParameters();
		
		if ( params.length != 1 )
		{
			return;
		}
		if ( getAccessor() == null )
		{
			return;
		}
		String paramName = params[0].getName();
		writeLine( "assertEquals( " + paramName + ", " + getTestWriter().instanceName() + "." +  getAccessor().getName() + "() )");
	}

	public Method getAccessor()
	{
		if ( getMethod().getName().startsWith( "set" ) && getMethod().getParameters().length == 1 )
		{
			return getTestWriter().accessorFor( getMethod() );
		}
		return null;
	}

	public void setAccessor( Method accessor )
	{
		fieldAccessor = accessor;
	}

	protected void writeMethodSignature()
	{
		write( scope() + "void" + SPACE + testMethodName() + "()" + exceptions() );
	}
	
	protected String testMethodName()
	{
		String methodName = getMethod().getName();
		String firstChar = methodName.toUpperCase().substring( 0, 1 );
		return "test" + firstChar + methodName.substring( 1, methodName.length() );
	}

	protected String exceptions()
	{
		if ( hasDeclaredException() )
		{
			return " throws " + formattedExceptionList();
		}
		return "";
	}
	

	protected String formattedExceptionList()
	{
		StringBuffer sb = new StringBuffer();
		for ( Iterator iterator = declaredExceptions().iterator(); iterator.hasNext(); )
		{
			Class exception = (Class) iterator.next();
			sb.append( exception.getSimpleName() );
			if ( iterator.hasNext() )
			{
				sb.append( ", ");
			}
		}
		return sb.toString();
	}

	protected Set<Class> declaredExceptions()
	{
		Set<Class> set = new HashSet<Class>();
		set.addAll( Arrays.asList( getMethod().getExceptionTypes() ) );
		return set;
	}

	protected boolean hasDeclaredException()
	{
		return declaredExceptions().size() > 0;
	}

	protected void writeInstance()
	{
		getTestWriter().writeInstance();
	}
	
	protected String scope()
	{
		return PUBLIC;
	}


	public TestWriter getTestWriter()
	{
		return (TestWriter) getClassWriter();
	}

	public void setTestWriter( TestWriter classWriter )
	{
		setClassWriter( classWriter );
	}


}
