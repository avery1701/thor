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

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;

import com.advancedpwr.record.descriptor.ClassDescriptor;
import com.advancedpwr.record.descriptor.ObjectDescriptor;

import java.util.Set;

public class InstanceTreeFactory
{
	protected Map<ObjectDescriptor, InstanceTree> fieldTrees;
	protected int count;

	protected Map<ObjectDescriptor, InstanceTree> getTrees()
	{
		if ( fieldTrees == null )
		{
			fieldTrees = new LinkedHashMap<ObjectDescriptor, InstanceTree>();
		}
		return fieldTrees;
	}

	public InstanceTree createInstanceTree( ObjectDescriptor result, InstanceTree inParent )
	{
		InstanceTree tree = getTrees().get( result );
		if ( tree == null )
		{
			tree = createTree( result, inParent );
			tree.setDepth( inParent.depth + 1 );
			getTrees().put( result, tree );
			tree.setIndex( count++ );
			tree.inspectObject();
		}
		return tree;
	}

	protected InstanceTree createTree( ObjectDescriptor result, InstanceTree inParent )
	{
		return inParent.createTree( result );
	}

	public Set<ClassDescriptor> classes()
	{
		Set<ClassDescriptor> classes = new LinkedHashSet<ClassDescriptor>();
		for ( Entry<ObjectDescriptor, InstanceTree> entry : getTrees().entrySet() )
		{
			classes.addAll( entry.getValue().classes() );
		}
		return classes;
	}
}
