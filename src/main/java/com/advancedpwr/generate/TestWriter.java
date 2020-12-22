package com.advancedpwr.generate;

import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import com.advancedpwr.record.AbstractRecorder;
import com.advancedpwr.record.ClassDescriptor;
import com.advancedpwr.test.BaseTestCase;

public class TestWriter extends AbstractRecorder
{
	
	public TestWriter()
	{
		setSuperClass( BaseTestCase.class );
	}

	@Override
	protected ClassDescriptor createDefaultDescriptor()
	{
		return new TestClassDescriptor( objectClass() );
	}

	@Override
	protected Set<Class> classes()
	{
		Set<Class> classes = new LinkedHashSet<Class>();
		if ( getSuperClass() != null )
		{
			classes.add( getSuperClass() );
		}
		classes.add( org.junit.Test.class );
		Method[] methods = objectClass().getDeclaredMethods();
		for ( Method method : methods )
		{
			Parameter[] params = method.getParameters();
			for ( Parameter param : params )
			{
				if( param.getType().isPrimitive() || param.getType().isArray() || param.getType().getPackageName().equals( "java.lang" ) )
				{
					continue;
				}
				classes.add( param.getType() );
			}
		}
		return classes;
	}

	@Override
	protected void writeObjectBuilderMethod()
	{
		Method[] methods = objectClass().getDeclaredMethods();
		List<Method> accessors = new ArrayList<>();
		for ( Method method : methods )
		{
			Method accessor = accessorFor( method );
			if ( accessor != null )
			{
				accessors.add( accessor );
			}
		}
		for ( Method method : methods )
		{
			if( accessors.contains( method ) )
			{
				continue;
			}
			TestMethodWriter methodWriter = new TestMethodWriter();
			methodWriter.setTestWriter( this );
			methodWriter.setMethod( method );
			methodWriter.buildMethod();
		}
	}
	
	protected void writeInstance()
	{
		new DefaultInstanceWriter( this ).writeInstance( objectClass() );
	}
	
	@Override
	public <T> T record( T inObject )
	{
		setObject( inObject );
		if ( javaFile().exists() )
		{
			return inObject;
		}
		writeObject();
		getPrintWriter().flush();
		getPrintWriter().close();
		return inObject;
	}

	public PrintWriter getPrintWriter()
	{
		if ( fieldPrintWriter == null && getDestination() != null )
		{
			setWriter( getJavaFileWriter() );
		}
		return fieldPrintWriter;
	}

	public String instanceName()
	{
		return new DefaultInstanceWriter( this ).withInstanceClass( objectClass() ).instanceName();
	}

	public Method accessorFor( Method inMethod )
	{
		if ( !inMethod.getName().startsWith( "set" ) )
		{
			return null;
		}
		String accessorOption1 = inMethod.getName().replaceFirst( "set", "get" );
		String accessorOption2 = inMethod.getName().replaceFirst( "set", "is" );
		Method[] methods = objectClass().getDeclaredMethods();
		for ( Method method : methods )
		{
			if ( method.getName().equals( accessorOption1 ) || method.getName().equals( accessorOption2 ) )
			{
				return method;
			}
		}
		return null;
	}

}
