package com.advancedpwr.record.descriptor;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class JavaMethodDescriptor implements MethodDescriptor
{
	protected Method fieldSubject;

	public Method subject()
	{
		return fieldSubject;
	}

	public void setSubject( Method method )
	{
		fieldSubject = method;
	}

	public JavaMethodDescriptor()
	{

	}

	public JavaMethodDescriptor( Method method )
	{
		setSubject( method );
	}

	@Override
	public String getName()
	{
		return subject().getName();
	}

	@Override
	public List<ClassDescriptor> getParameterTypes()
	{
		return toList( subject().getParameterTypes() );
	}

	@Override
	public List<ClassDescriptor> getExceptionTypes()
	{
		return toList( subject().getExceptionTypes() );
	}

	protected ArrayList<ClassDescriptor> toList( Class<?>[] classArray )
	{
		ArrayList<ClassDescriptor> descriptors = new ArrayList<ClassDescriptor>();
		for ( Class<?> aClass : classArray )
		{
			descriptors.add( new JavaClassDescriptor( aClass ) );
		}
		return descriptors;
	}

}
