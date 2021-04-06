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
package com.advancedpwr.record.mock;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.advancedpwr.record.AccessPath;
import com.advancedpwr.record.descriptor.ClassDescriptor;
import com.advancedpwr.record.descriptor.MethodDescriptor;

public class MethodCallPath extends AccessPath
{

	protected List<AccessPath> fieldArguments;

	public List<AccessPath> getArguments()
	{
		return fieldArguments;
	}

	public void setArguments( List<AccessPath> arguments )
	{
		fieldArguments = arguments;
	}

	public String pathName()
	{
		return getMethod().getName();
	}

	protected MethodDescriptor fieldMethod;

	public MethodDescriptor getMethod()
	{
		return fieldMethod;
	}

	public void setMethod( MethodDescriptor method )
	{
		fieldMethod = method;
	}

	public ClassDescriptor getReturnType()
	{
		return getMethod().getReturnType();
	}

	public Set<ClassDescriptor> getExceptions()
	{
		return new HashSet<>( getMethod().getExceptionTypes() );
	}

}
