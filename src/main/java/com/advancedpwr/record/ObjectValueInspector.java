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

/**
 * @author Matthew Avery, mavery@advancedpwr.com on Mar 20, 2021
 *
 */
public class ObjectValueInspector implements ValueInspector
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

	public ObjectValueInspector( Object inObject )
	{
		setObject( inObject );
	}

	@Override
	public List<MethodAccessor> methods()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ValueInspector> interfaces()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ValueInspector value( MethodAccessor method )
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String name()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String type()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String value()
	{
		// TODO Auto-generated method stub
		return null;
	}
}