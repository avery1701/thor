/*
 * Copyright 2021 Matthew Avery, mavery@advancedpwr.com
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

import java.util.List;

import com.advancedpwr.record.descriptor.ClassDescriptor;
import com.advancedpwr.record.descriptor.JavaArrayObjectDescriptor;
import com.advancedpwr.record.descriptor.MethodDescriptor;
import com.advancedpwr.record.descriptor.ObjectDescriptor;

/**
 * @author Matthew Avery, mavery@advancedpwr.com on Mar 23, 2021
 *
 */
public class BeanObjectDescriptor implements ObjectDescriptor
{

	protected Object fieldObject;

	protected Object getObject()
	{
		return fieldObject;
	}

	protected void setObject( Object object )
	{
		fieldObject = object;
	}

	@Override
	public ClassDescriptor getClassDescriptor()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MethodDescriptor> getMethods()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isArray()
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public JavaArrayObjectDescriptor asArrayObjectDescriptor()
	{
		// TODO Auto-generated method stub
		return null;
	}

}
