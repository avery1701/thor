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

import static com.advancedpwr.record.ClassWriter.PROTECTED;
import static com.advancedpwr.record.ClassWriter.PUBLIC;
import static com.advancedpwr.record.ClassWriter.SPACE;

import java.lang.reflect.Constructor;
import java.util.Iterator;
import java.util.Set;

import com.advancedpwr.record.AccessPath;
import com.advancedpwr.record.ClassWriterDelagate;
import com.advancedpwr.record.InstanceTree;

public class BuildMethodWriter extends ClassWriterDelagate
{

	protected AccessPath fieldAccessPath;

	protected String fieldScope;
	protected MethodBuilderFactory fieldFactory;
	
	public MethodBuilderFactory getFactory()
	{
		return fieldFactory;
	}

	public void setFactory( MethodBuilderFactory methodBuilderFactory )
	{
		fieldFactory = methodBuilderFactory;
	}

	public void buildMethod()
	{
//		System.out.println( "writing " + returnType() + SPACE + resultBuilder() + " : " + toString() );
		newLine();
		writeField();
		writeMethodSignature();
		openBrace();
		writeInstance();
		writePopulators();
		writeLine( "return " + instanceName() );
		closeBrace();
		// This instance is built, so we can cache it
		getFactory().storeBuilder( this );
		writeBuilderMethods();
		
	}

	protected void writeMethodSignature()
	{
		write( scope() + returnType() + SPACE + resultBuilder() + exceptions() );
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
		return getInstanceTree().getExceptions();
	}

	protected boolean hasDeclaredException()
	{
		return declaredExceptions().size() > 0;
	}

	protected void writeInstance()
	{
		writeIfNotNullReturnInstance();
		if ( hasDefaultConstructor() )
		{
			writeLine( instanceName() + " = new " + instanceType() + "()");
		}
		else
		{
			writeLine( instanceName() + " = (" + instanceType() + ")newInstance( " + instanceType() + ".class )");
		}
	}
	
	protected boolean hasDefaultConstructor()
	{
		Constructor[] constructors = getAccessPath().getResultClass().getConstructors();
		for ( int i = 0; i < constructors.length; i++ )
		{
			if ( constructors[i].getParameterTypes().length == 0 )
			{
				return true;
			}
		}
		return false;
	}
	
	protected void writeField()
	{
		writeLine( PROTECTED + instanceType() + SPACE + instanceName() );
		newLine();
	}
	
	protected void writeBuilderMethods()
	{
		for ( AccessPath result : getInstanceTree().getAccessPaths() )
		{
			BuildMethodWriter builder = createMethodBuilder( result );
			builder.buildMethod();
		}
	}
	
	protected String scope()
	{
		if ( fieldScope == null )
		{
			fieldScope = PROTECTED;
		}
		return fieldScope;
	}
	
	public void setScopePublic()
	{
		fieldScope = PUBLIC;
	}
	
	public void setScopeProtected()
	{
		fieldScope = PROTECTED;
	}
	
	protected void writePopulators()
	{
		for ( AccessPath result : getInstanceTree().getAccessPaths() )
		{
			BuildMethodWriter builder = createMethodBuilder( result );
			writeLine( builder.populator( instanceName() ) );
		}
	}
	
	protected String populator( String inInstanceName )
	{
		return inInstanceName + "." + getAccessPath().pathName() + "( " + resultBuilder() + " )";
	}

	public InstanceTree getInstanceTree()
	{
		return getAccessPath().getInstanceTree();
	}
	
	protected BuildMethodWriter createMethodBuilder( AccessPath result )
	{
		BuildMethodWriter builder = getFactory().createMethodBuilder( result );
		builder.setClassWriter( getClassWriter() );
		return builder;
	}

	public AccessPath getAccessPath()
	{
		return fieldAccessPath;
	}

	public void setAccessPath( AccessPath result )
	{
		fieldAccessPath = result;
	}


	public String resultBuilder()
	{
		return "build" + getAccessPath().nameRoot() + depth() + "()";
	}
	
	protected String depth()
	{
		int depth = getInstanceTree().getDepth();
		if ( depth > 0 )
		{
			return "_" + depth;
		}
		return "";
	}

	protected String instanceType()
	{
		return getAccessPath().getResultClass().getSimpleName();
	}

	protected String instanceName()
	{
		return getAccessPath().nameRoot().toLowerCase() + depth();
	}

	protected String returnType()
	{
		return getAccessPath().getParameterClass().getSimpleName();
	}
	

	protected void writeIfNotNullReturnInstance()
	{
		write( "if ( " + instanceName() + " != null ) " );
		openBrace();
		writeLine( "return " + instanceName() );
		closeBrace();
	}

	protected void wrapException( String line )
	{
		write("try");
		openBrace();
		writeLine( line );
		closeBrace();
		write( "catch( Exception e )" );
		openBrace();
		writeLine( "throw new RuntimeException( e )");
		closeBrace();
	}

}
