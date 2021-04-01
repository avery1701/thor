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

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import com.advancedpwr.record.descriptor.ClassDescriptor;
import com.advancedpwr.record.descriptor.JavaArrayClassDescriptor;
import com.advancedpwr.record.descriptor.JavaClassDescriptor;
import com.advancedpwr.record.descriptor.MethodDescriptor;
import com.advancedpwr.record.descriptor.ObjectDescriptor;
import com.advancedpwr.record.inspect.ArrayInspector;
import com.advancedpwr.record.inspect.BeanInspector;
import com.advancedpwr.record.inspect.CollectionInspector;
import com.advancedpwr.record.inspect.Inspector;
import com.advancedpwr.record.inspect.InspectorList;
import com.advancedpwr.record.inspect.MapInspector;

public class InstanceTree
{
	protected ObjectDescriptor fieldObject;
	protected MethodDescriptor fieldCurrentMethod;
	protected AccessPathList fieldAccessPaths;
	protected int depth;
	protected InstanceTree fieldParent;
	protected InstanceTreeFactory fieldFactory;
	protected InspectorList fieldInspectors;

	protected int fieldIndex;

	protected Set<ClassDescriptor> fieldStopClasses;
	protected InterfaceClassSubstitutor fieldClassesForInterface;

	public InstanceTree getParent()
	{
		if ( fieldParent == null )
		{
			fieldParent = this;
		}
		return fieldParent;
	}

	public int getDepth()
	{
		return depth;
	}

	public void setDepth( int depth )
	{
		this.depth = depth;
	}

	public boolean isTop()
	{
		return getParent().equals( this );
	}

	public void setParent( InstanceTree parent )
	{
		fieldParent = parent;
	}

	public MethodDescriptor getCurrentMethod()
	{
		return fieldCurrentMethod;
	}

	public void setCurrentMethod( MethodDescriptor method )
	{
		fieldCurrentMethod = method;
	}

	public InstanceTree( Set<ClassDescriptor> stopClasses,
			InterfaceClassSubstitutor classForInterface, ObjectDescriptor object )
	{
		this( object, null );
		setStopClasses( stopClasses );
		setClassesForInterface( classForInterface );
		getFactory().getTrees().put( object, this );
		setIndex( getFactory().count++ );
		inspectObject();
	}

	public InstanceTree( ObjectDescriptor object )
	{
		this( object, null );
		getFactory().getTrees().put( object, this );
		setIndex( getFactory().count++ );
		inspectObject();
	}

	public InstanceTree( ObjectDescriptor object, InstanceTree inTree )
	{
		setParent( inTree );
		if ( inTree != null )
		{
			setFactory( inTree.getFactory() );
			setStopClasses( inTree.getStopClasses() );
			setClassesForInterface( inTree.getClassesForInterface() );
		}
		setObject( object );
	}

	protected void inspectObject()
	{
		for ( Inspector inspector : getInspectors() )
		{
			inspector.inspect( this );
		}
	}

	public InspectorList getInspectors()
	{
		if ( fieldInspectors == null )
		{
			fieldInspectors = initializeInspectorList();
		}
		return fieldInspectors;
	}

	protected InspectorList initializeInspectorList()
	{
		InspectorList inspectors = new InspectorList();
		inspectors.add( new BeanInspector() );
		inspectors.add( new CollectionInspector() );
		inspectors.add( new MapInspector() );
		inspectors.add( new ArrayInspector() );
		return inspectors;
	}

	public void addInspector( Inspector inspector )
	{
		getInspectors().add( inspector );
	}

	public String currentInstanceName()
	{
		if ( getParent().equals( this ) )
		{
			return objectClass().getClassName();
		}
		return getParent().getCurrentMethod().getName().replaceFirst( "set", "" ) + "_" + depth;
	}

	public ClassDescriptor objectClass()
	{
		return getClassesForInterface().substitute( targetClass() );
	}

	protected ClassDescriptor targetClass()
	{
		return getObject().getClassDescriptor();
	}

	public InstanceTree createInstanceTree( ObjectDescriptor result )
	{
		return getFactory().createInstanceTree( result, this );
	}

	public InstanceTree createTree( ObjectDescriptor result )
	{
		return new InstanceTree( result, this );
	}

	public AccessPathList getAccessPaths()
	{
		if ( fieldAccessPaths == null )
		{
			fieldAccessPaths = new AccessPathList();
		}
		return fieldAccessPaths;
	}

	public ObjectDescriptor getObject()
	{
		return fieldObject;
	}

	public void setObject( ObjectDescriptor object )
	{
		fieldObject = object;
	}

	protected Set<ClassDescriptor> classes()
	{
		Set<ClassDescriptor> classes = new LinkedHashSet<ClassDescriptor>();
		if ( !objectClass().isArray() && !objectClass().isAnonymousClass() )
		{
			addClassToSet( classes, objectClass() );
		}
		for ( AccessPath path : getAccessPaths() )
		{
			addClassToSet( classes, path.getParameterClass() );
			addClassToSet( classes, path.getResultClass() );
			for ( ClassDescriptor aClass : path.getExceptions() )
			{
				addClassToSet( classes, aClass );
			}
		}
		return classes;
	}

	protected void addClassToSet( Set<ClassDescriptor> classes, ClassDescriptor inClass )
	{
		if ( ignoredClass( inClass ) )
		{
			return;
		}
		if ( inClass.isArray() )
		{
			inClass = ( (JavaArrayClassDescriptor) inClass ).getComponentType();
			if ( inClass.isPrimitive() )
			{
				return;
			}
		}
		classes.add( inClass );
	}

	public boolean ignoredClass( ClassDescriptor inClass )
	{
		JavaClassDescriptor voidClassDescriptor = new JavaClassDescriptor( void.class );
		JavaClassDescriptor nullClassDescriptor = new JavaClassDescriptor( Null.class );
		return inClass == null || inClass.isPrimitive()
				|| inClass.getInterfaces().contains( voidClassDescriptor )
				|| inClass.getInterfaces().contains( nullClassDescriptor )
				|| inClass.getPackageName().startsWith( "java.lang." );

	}

	public int getIndex()
	{
		return fieldIndex;
	}

	public void setIndex( int index )
	{
		fieldIndex = index;
	}

	public InstanceTreeFactory getFactory()
	{
		if ( fieldFactory == null )
		{
			fieldFactory = createFactory();
		}
		return fieldFactory;
	}

	protected InstanceTreeFactory createFactory()
	{
		return new InstanceTreeFactory();
	}

	public void setFactory( InstanceTreeFactory factory )
	{
		fieldFactory = factory;
	}

	public Set<ClassDescriptor> getExceptions()
	{
		Map<InstanceTree, Set<ClassDescriptor>> cache = new HashMap<InstanceTree, Set<ClassDescriptor>>();
		cache.put( this, new LinkedHashSet<ClassDescriptor>() );
		Set<ClassDescriptor> exceptions = getExceptions( cache );
		cache.put( this, exceptions );
		return exceptions;
	}

	protected Set<ClassDescriptor> getExceptions( Map<InstanceTree, Set<ClassDescriptor>> cache )
	{
		Set<ClassDescriptor> exceptions = new LinkedHashSet<ClassDescriptor>();
		for ( AccessPath path : getAccessPaths() )
		{
			Set<ClassDescriptor> cached = cache.get( path.getInstanceTree() );
			if ( cached != null )
			{
				exceptions.addAll( cached );
			}
			else
			{
				cache.put( path.getInstanceTree(), new LinkedHashSet<ClassDescriptor>() );
				exceptions.addAll( path.getExceptions() );
				exceptions.addAll( path.getInstanceTree().getExceptions( cache ) );
				cache.put( path.getInstanceTree(), exceptions );
			}
		}
		return exceptions;
	}

	public Set<ClassDescriptor> getStopClasses()
	{
		if ( fieldStopClasses == null )
		{
			fieldStopClasses = new HashSet<ClassDescriptor>();
		}
		return fieldStopClasses;
	}

	public boolean isStop()
	{
		return getStopClasses().contains( objectClass() );
	}

	public void setStopClasses( Set<ClassDescriptor> stopClasses )
	{
		fieldStopClasses = stopClasses;
	}

	public InterfaceClassSubstitutor getClassesForInterface()
	{
		if ( fieldClassesForInterface == null )
		{
			fieldClassesForInterface = new InterfaceClassSubstitutor();
		}
		return fieldClassesForInterface;
	}

	public void setClassesForInterface( InterfaceClassSubstitutor classForInterface )
	{
		fieldClassesForInterface = classForInterface;
	}

}
