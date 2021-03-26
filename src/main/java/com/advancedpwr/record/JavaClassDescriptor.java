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
package com.advancedpwr.record;

import java.lang.reflect.Constructor;
import java.util.HashSet;
import java.util.Set;

public class JavaClassDescriptor implements ClassDescriptor
{

	public static final String GENERATED = ".generated";

	public static final String FACTORY = "Factory";

	protected Class<?> fieldClass;

	public JavaClassDescriptor()
	{

	}

	public JavaClassDescriptor( Class<?> inClass )
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

	public String getClassName()
	{
		return subject().getSimpleName() + FACTORY;
	}

	public String getPackageName()
	{
		return subject().getPackage().getName() + GENERATED;
	}

	public String toString()
	{
		return getPackageName() + "." + getClassName();
	}

	@Override
	public Set<ClassDescriptor> getInterfaces()
	{
		Set<ClassDescriptor> interfaces = new HashSet<ClassDescriptor>();
		for ( Class<?> anInterface : subject().getInterfaces() )
		{
			interfaces.add( new JavaClassDescriptor( anInterface ) );
		}
		return interfaces;
	}
	
	@Override
	public boolean isAssignableFrom( ClassDescriptor inClass )
	{
		return getInterfaces().contains( inClass );
	}

	@Override
	public ClassDescriptor getSuperclass()
	{
		return new JavaClassDescriptor( subject().getSuperclass() );
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

	@Override
	public Set<Constructor<?>> getConstructors()
	{
		HashSet<Constructor<?>> constructorsSet = new HashSet<Constructor<?>>();
		Constructor<?>[] constructors = subject().getConstructors();
		for(Constructor<?> constructor : constructors ) {
			constructorsSet.add( constructor );
		}
		return constructorsSet;
	}
}
