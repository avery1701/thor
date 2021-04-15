/*
 * Copyright 2011 Matthew Avery, mavery@advancedpwr.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.advancedpwr.record.descriptor;

/**
 * A {@link ClassDescriptor} for array factories.  If the object to be recorded is a Java array, this
 * class descriptor will create an appropriately named class.
 * 
 * For example, if the target object to be recorded is an array of <code>com.example.Person</code> objects, this 
 * {@link ClassDescriptor} will generate a class name of "PersonArrayFactory" in the package "com.example.generated".
 * 
 * @author Matthew Avery, mavery@advancedpwr.com on Sep 30, 2010
 *
 */
public class JavaArrayClassReference implements ClassReference
{

	public static final String ARRAY = "Array";

	protected Class<?> fieldClass;
	
	protected Class<?>  subject()
	{
		return fieldClass.getComponentType();
	}

	protected void setClass( Class<?>  class1 )
	{
		fieldClass = class1;
	}

	public JavaArrayClassReference( Class<?> inClass )
	{
		setClass( inClass );
	}

	public String getClassName()
	{
		return subject().getSimpleName() + ARRAY + FACTORY;
	}

	@Override
	public String getPackageName()
	{
		return subject().getPackageName();
	}



}
