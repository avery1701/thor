package com.advancedpwr.record;

import java.util.List;
import java.util.Set;

import com.advancedpwr.record.descriptor.ArrayClassDescriptor;
import com.advancedpwr.record.descriptor.ClassDescriptor;
import com.advancedpwr.record.descriptor.ConstructorDescriptor;
import com.advancedpwr.record.descriptor.MethodDescriptor;

public class BlankClassDescriptor implements ClassDescriptor
{
	protected String fieldClassName;
	protected String fieldPackageName;

	public BlankClassDescriptor()
	{
	}

	protected void setClassName( String className )
	{
		fieldClassName = className;
	}

	protected void setPackageName( String packageName )
	{
		fieldPackageName = packageName;
	}

	@Override
	public String getClassName()
	{
		return null;
	}

	@Override
	public String getPackageName()
	{
		return null;
	}

	@Override
	public Set<ConstructorDescriptor> getConstructors()
	{
		return null;
	}

	@Override
	public List<MethodDescriptor> getMethods()
	{
		return null;
	}

	@Override
	public Set<ClassDescriptor> getInterfaces()
	{
		return null;
	}

	@Override
	public boolean isAssignableFrom( ClassDescriptor inClass )
	{
		return false;
	}

	@Override
	public ClassDescriptor getSuperclass()
	{
		return null;
	}

	@Override
	public boolean isAnonymousClass()
	{
		return false;
	}

	@Override
	public boolean isArray()
	{
		return false;
	}

	@Override
	public ArrayClassDescriptor asArrayDescriptor()
	{
		return null;
	}

	@Override
	public boolean isPrimitive()
	{
		return false;
	}

	@Override
	public boolean isEnum()
	{
		return false;
	}

}
