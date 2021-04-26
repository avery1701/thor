package com.advancedpwr.record.descriptor;

public class JavaClassReference implements ClassReference
{

	protected Class<?> fieldClass;

	public JavaClassReference( Class<?> inClass )
	{
		setClass( inClass );
	}

	public Class<?> subject()
	{
		return fieldClass;
	}

	public void setClass( Class<?> inClass )
	{
		fieldClass = inClass;
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

	public String getFactoryClassName()
	{
		return getClassName() + FACTORY;
	}

	public String getFactoryPackageName()
	{
		return getPackageName() + GENERATED;
	}
}
