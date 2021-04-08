/**
 * 
 * @author Elijah Hopp, github.mrzeusthecoder@gmail.com. Created: Apr 8, 2021
 * 
 */
package com.advancedpwr.record.descriptor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SimpleClassDescriptor implements ClassDescriptor
{
	protected String fieldClassName;
	protected String fieldPackageName;

	public String getClassName()
	{
		return fieldClassName;
	}

	public void setClassName( String className )
	{
		fieldClassName = className;
	}

	public String getPackageName()
	{
		return fieldPackageName;
	}

	public void setPackageName( String packageName )
	{
		fieldPackageName = packageName;
	}


	@Override
	public Set<ConstructorDescriptor> getConstructors()
	{
		return new HashSet<ConstructorDescriptor>();
	}

	@Override
	public List<MethodDescriptor> getMethods()
	{
		return null;
	}

	@Override
	public Set<ClassDescriptor> getInterfaces()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAssignableFrom( ClassDescriptor inClass )
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ClassDescriptor getSuperclass()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAnonymousClass()
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isArray()
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayClassDescriptor asArrayDescriptor()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isPrimitive()
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnum()
	{
		// TODO Auto-generated method stub
		return false;
	}

	public String toString()
	{
		return getPackageName() + "." + getClassName();
	}
}
