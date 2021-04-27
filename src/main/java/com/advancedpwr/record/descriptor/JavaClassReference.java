package com.advancedpwr.record.descriptor;

public class JavaClassReference implements ClassReference
{

	protected Class<?> fieldClass;

	protected Class<?> subject()
	{
		return fieldClass;
	}

	protected void setClass( Class<?> inClass )
	{
		fieldClass = inClass;
	}

	public JavaClassReference( Class<?> inClass )
	{
		setClass( inClass );
	}

	@Override
	public String getClassName()
	{
		return subject().getSimpleName();
	}

	@Override
	public String getPackageName()
	{
		return subject().getPackage().getName();
	}

	@Override
	public boolean isAnonymousClass()
	{
		return subject().isAnonymousClass();
	}

	@Override
	public boolean isArray()
	{
		return subject().isArray();
	}

	@Override
	public boolean isPrimitive()
	{
		return subject().isPrimitive();
	}

	@Override
	public boolean isEnum()
	{
		return subject().isEnum();
	}
}
