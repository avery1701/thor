/**
 * 
 * @author Elijah Hopp, github.mrzeusthecoder@gmail.com. Created: Apr 8, 2021
 * 
 */
package com.advancedpwr.record.descriptor;

public class SimpleClassReference implements ClassReference
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


	public String toString()
	{
		return getPackageName() + "." + getClassName();
	}
}
