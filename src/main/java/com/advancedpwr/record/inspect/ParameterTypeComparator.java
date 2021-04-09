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
package com.advancedpwr.record.inspect;

import java.util.Comparator;

import com.advancedpwr.record.descriptor.ClassDescriptor;
import com.advancedpwr.record.descriptor.MethodDescriptor;
import com.advancedpwr.record.descriptor.StateModifier;

public abstract class ParameterTypeComparator implements Comparator<MethodDescriptor>
{

	public int compare( MethodDescriptor m1, MethodDescriptor m2 )
	{
		if ( isSetter( m1 ) && isSetter( m2 ) )
		{
			ClassDescriptor c1 = parameterClass( m1 );
			ClassDescriptor c2 = parameterClass( m2 );
			if ( isParameterType( c1 ) == isParameterType( c2 ) )
			{
				return 0;
			}
			if ( !isParameterType( c1 ) && isParameterType( c2 ) )
			{
				return -1;
			}
			if ( isParameterType( c1 ) && !isParameterType( c2 ) )
			{
				return 1;
			}
		}
		return 0;
	}

	protected ClassDescriptor parameterClass( MethodDescriptor m2 )
	{
		return m2.getParameterTypes().get( 0 );
	}

	protected abstract boolean isParameterType( ClassDescriptor c1 );

	protected boolean isSetter( MethodDescriptor method )
	{
		return method.getModifiers().contains( StateModifier.PUBLIC )
				&& method.getName().startsWith( "set" ) && method.getParameterTypes().size() == 1;
	}
}
