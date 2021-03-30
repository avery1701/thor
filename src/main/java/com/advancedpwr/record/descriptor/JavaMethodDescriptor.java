package com.advancedpwr.record.descriptor;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

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
	public Set<ClassDescriptor> getParameterTypes()
	{
		return makeDescriptorSet( subject().getParameterTypes() );
	}

	@Override
	public Set<ClassDescriptor> getExceptionTypes()
	{
		return makeDescriptorSet( subject().getExceptionTypes() );
	}

	protected Set<ClassDescriptor> makeDescriptorSet( Class<?>[] types )
	{
		HashSet<ClassDescriptor> descriptors = new HashSet<ClassDescriptor>();
		for ( Class<?> type : types )
		{
			descriptors.add( new JavaClassDescriptor( type ) );
		}
		return descriptors;
	}

}
