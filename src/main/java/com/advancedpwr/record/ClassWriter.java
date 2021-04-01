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
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.advancedpwr.record.descriptor.ClassDescriptor;
import com.advancedpwr.record.descriptor.ObjectDescriptor;

/**
 * <code>ClassWriter</code> wraps a {@link PrintWriter} with convenience methods for creating Java source code output.
 * 
 *  @author Matthew Avery, mavery@advancedpwr.com on Mar 26, 2010
 */
public abstract class ClassWriter
{
	public static final String SPACE = " ";
	public static final String PACKAGE = "package ";
	public static final String IMPORT = "import ";
	public static final String CLASS = "class ";
	public static final String PUBLIC = "public ";
	public static final String PROTECTED = "protected ";
	public static final String PRIVATE = "private ";

	protected PrintWriter fieldPrintWriter;
	protected int tabDepth;
	protected ObjectDescriptor fieldObject;
	protected ClassDescriptor fieldSuperClass;

	protected List<String> fieldStaticClassNames;

	protected ObjectDescriptor getObjectDescriptor()
	{
		return fieldObject;
	}

	protected void setObject( ObjectDescriptor object )
	{
		fieldObject = object;
	}

	public PrintWriter getPrintWriter()
	{
		return fieldPrintWriter;
	}

	public void setWriter( Writer writer )
	{
		fieldPrintWriter = new PrintWriter( writer );
	}

	public void writeLine( String inString )
	{
		tabs();
		getPrintWriter().println( inString + ";" );
	}

	public void write( String inString )
	{
		tabs();
		getPrintWriter().println( inString );
	}

	protected ClassWriter tab()
	{
		getPrintWriter().print( '\t' );
		return this;
	}

	protected ClassWriter tabs()
	{
		for ( int i = 0; i < tabDepth; i++ )
		{
			tab();
		}
		return this;
	}

	public ClassWriter openBrace()
	{
		write( "{" );
		tabDepth++;
		return this;
	}

	public ClassWriter closeBrace()
	{
		tabDepth--;
		if ( tabDepth < 0 )
		{
			throw new ClassWriterException( "Possible unmatched opening brace." );
		}
		write( "}" );
		return this;
	}

	public ClassWriter newLine()
	{
		getPrintWriter().println();
		return this;
	}

	public ClassDescriptor getDescriptor()
	{
		return getObjectDescriptor().getClassDescriptor();
	}

	protected void writeClassDeclaration()
	{
		write( PUBLIC + CLASS + getDescriptor().getClassName() + extendClass() );
	}

	protected String extendClass()
	{
		if ( getSuperClass() != null )
		{
			return " extends " + getSuperClass().getClassName();
		}
		return "";
	}

	protected void writePackage()
	{
		writeLine( PACKAGE + packageName() );
		newLine();
	}

	protected void writeImports()
	{
		writeStaticImports();
		for ( ClassDescriptor aClass : classes() )
		{
			writeLine( IMPORT + aClass.getClassName().replace( "$", "." ) );
		}
		newLine();
	}

	protected void writeStaticImports()
	{
		for ( String aClass : getStaticClassNames() )
		{
			writeLine( IMPORT + " static " + aClass + ".*" );
		}
	}

	protected abstract Set<ClassDescriptor> classes();

	protected String packageName()
	{
		return getDescriptor().getPackageName();
	}

	public String getClassName()
	{
		return getDescriptor().getClassName();
	}

	public String getPackageName()
	{
		return getDescriptor().getPackageName();
	}

	protected void writeObject()
	{
		writePackage();
		writeImports();
		writeClassDeclaration();
		openBrace();
		writeObjectBuilderMethod();
		newLine();
		closeBrace();
	}

	protected abstract void writeObjectBuilderMethod();

	public ClassDescriptor getSuperClass()
	{
		return fieldSuperClass;
	}

	public void setSuperClass( ClassDescriptor superClass )
	{
		fieldSuperClass = superClass;
	}

	public List<String> getStaticClassNames()
	{
		if ( fieldStaticClassNames == null )
		{
			fieldStaticClassNames = new ArrayList<String>();
		}
		return fieldStaticClassNames;
	}

	public void addStaticImport( ClassDescriptor inClass )
	{
		getStaticClassNames().add( inClass.getClassName().replace( "$", "." ) );
	}
}
