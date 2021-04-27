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

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JavaClassDescriptor extends JavaClassReference implements ClassDescriptor
{

	public JavaClassDescriptor( Class<?> inClass )
	{
		super( inClass );
	}

	@Override
	public Set<ConstructorDescriptor> getConstructors()
	{
		HashSet<ConstructorDescriptor> constructorsSet = new HashSet<ConstructorDescriptor>();
		Constructor<?>[] constructors = subject().getConstructors();
		for ( Constructor<?> constructor : constructors )
		{
			constructorsSet.add( new JavaConstructorDescriptor( constructor ) );
		}
		return constructorsSet;
	}

	@Override
	public List<MethodDescriptor> getMethods()
	{
		ArrayList<MethodDescriptor> descriptors = new ArrayList<MethodDescriptor>();
		Method[] methods = subject().getMethods();
		for ( Method method : methods )
		{
			descriptors.add( new JavaMethodDescriptor( method ) );
		}
		return descriptors;
	}

	@Override
	public Set<ClassReference> getInterfaces()
	{
		Set<ClassReference> interfaces = new HashSet<ClassReference>();
		for ( Class<?> anInterface : subject().getInterfaces() )
		{
			interfaces.add( new JavaClassDescriptor( anInterface ) );
		}
		if ( subject().isInterface() )
		{
			interfaces.add( this );
		}
		return interfaces;
	}

	protected Set<ClassDescriptor> getAllSuperClasses()
	{
		Set<ClassDescriptor> superClasses = new HashSet<ClassDescriptor>();
		Class<?> superClass = subject();
		while ( superClass != null )
		{
			superClasses.add( new JavaClassDescriptor( superClass ) );
			superClass = superClass.getSuperclass();
		}
		return superClasses;
	}

	@Override
	public boolean isAssignableFrom( ClassDescriptor inClass )
	{
		return getInterfaces().contains( inClass ) || inClass.equals( this )
				|| getAllSuperClasses().contains( inClass );
	}

	@Override
	public ClassReference getSuperclass()
	{
		return new JavaClassDescriptor( subject().getSuperclass() );
	}

	@Override
	public ClassDescriptor getComponentType()
	{
		if ( isArray() )
		{
			return new JavaClassDescriptor( subject().getComponentType() );
		}

		return null;
	}

	@Override
	public String toString()
	{
		return getPackageName() + "." + getClassName();
	}

	@Override
	public int hashCode()
	{
		return subject().hashCode();
	}

	@Override
	public boolean equals( Object obj )
	{
		if ( obj instanceof ClassReference )
		{
			ClassReference lhs = (ClassReference) obj;
			return getPackageName().equals( lhs.getPackageName() )
					&& getClassName().equals( lhs.getClassName() );
		}
		else
		{
			return super.equals( obj );
		}
	}

}
