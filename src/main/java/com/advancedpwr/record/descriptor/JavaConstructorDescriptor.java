package com.advancedpwr.record.descriptor;

import java.lang.reflect.Constructor;

public class JavaConstructorDescriptor implements ConstructorDescriptor
{
	Constructor<?> fieldConstructor;

	public Constructor<?> subject()
	{
		return fieldConstructor;
	}

	public void setSubject( Constructor<?> constructor )
	{
		fieldConstructor = constructor;
	}

	public JavaConstructorDescriptor()
	{

	}

	public JavaConstructorDescriptor( Constructor<?> constructor )
	{
		setSubject( constructor );
	}

	@Override
	public int getParameterCount()
	{
		return subject().getParameterCount();
	}
	
	

}
