package com.advancedpwr.samples;

public class InnerClassExample
{
	public class InnerClass
	{
		protected String fieldName;

		public String getName()
		{
			return fieldName;
		}

		public void setName( String name )
		{
			fieldName = name;
		}
	}
	
	protected InnerClass fieldInnerInstance;

	public InnerClass getInnerInstance()
	{
		return fieldInnerInstance;
	}

	public void setInnerInstance( InnerClass innerInstance )
	{
		fieldInnerInstance = innerInstance;
	}
	
	
}
