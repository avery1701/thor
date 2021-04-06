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

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import com.advancedpwr.record.AccessPath;
import com.advancedpwr.record.InstanceTree;
import com.advancedpwr.record.descriptor.ClassDescriptor;
import com.advancedpwr.record.descriptor.ObjectDescriptor;
import com.advancedpwr.record.inspect.ArrayInspector;
import com.advancedpwr.record.inspect.InspectorList;

public class BehaviorInstanceTree extends InstanceTree
{
	protected ClassDescriptor fieldPreferredInterface;

	public ClassDescriptor getPreferredInterface()
	{
		return fieldPreferredInterface;
	}

	public void setPreferredInterface( ClassDescriptor preferredInterface )
	{
		fieldPreferredInterface = preferredInterface;
	}

	protected InspectorList initializeInspectorList()
	{
		InspectorList inspectors = new InspectorList();
		inspectors.add( new ArrayInspector() );
		return inspectors;
	}

	public BehaviorInstanceTree( ObjectDescriptor object )
	{
		super( object );
	}

	public BehaviorInstanceTree( ObjectDescriptor object, InstanceTree inTree )
	{
		super( object, inTree );
	}

	public InstanceTree createTree( ObjectDescriptor result )
	{
		return new BehaviorInstanceTree( result, this );
	}

	public void addAccessPaths( List<ObjectDescriptor> inArguments, ObjectDescriptor result )
	{
		MethodCallPath accessor = createMethodCallPath( inArguments, result );
		getAccessPaths().add( accessor );
		getAccessPaths().addAll( accessor.getArguments() );
	}

	protected MethodCallPath createMethodCallPath( List<ObjectDescriptor> inArguments,
			ObjectDescriptor result )
	{
		MethodCallPath path = new MethodCallPath();
		path.setMethod( getCurrentMethod() );
		InstanceTree tree = createInstanceTree( result );
		path.setTree( tree );
		List<AccessPath> paths = new ArrayList<AccessPath>();
		for ( ObjectDescriptor object : inArguments )
		{
			AccessPath argPath = new ArgumentPath();
			argPath.setTree( createInstanceTree( object ) );
			paths.add( argPath );
		}
		path.setArguments( paths );
		return path;
	}

	protected Set<ClassDescriptor> fieldDeclaredExceptions;

	protected Set<ClassDescriptor> getDeclaredExceptions()
	{
		if ( fieldDeclaredExceptions == null )
		{
			fieldDeclaredExceptions = new LinkedHashSet<ClassDescriptor>();

		}

		return fieldDeclaredExceptions;
	}

	public void addDeclaredExceptions( List<ClassDescriptor> exceptionTypes )
	{
		getDeclaredExceptions().addAll( exceptionTypes );
	}

	public Set<ClassDescriptor> getExceptions()
	{
		Set<ClassDescriptor> exceptions = super.getExceptions();
		exceptions.addAll( getDeclaredExceptions() );
		return exceptions;
	}

	public ClassDescriptor objectClass()
	{
		if ( getPreferredInterface() != null )
		{
			return getPreferredInterface();
		}
		return getObject().getClassDescriptor();
	}

}
