package com.advancedpwr.record.inspect;

import java.util.Collections;
import java.util.List;

import com.advancedpwr.record.AccessPath;
import com.advancedpwr.record.InstanceTree;
import com.advancedpwr.record.RecorderException;
import com.advancedpwr.record.descriptor.ClassDescriptor;
import com.advancedpwr.record.descriptor.JavaClassDescriptor;
import com.advancedpwr.record.descriptor.MethodDescriptor;
import com.advancedpwr.record.descriptor.ObjectDescriptor;
import com.advancedpwr.record.descriptor.StateModifier;

public class BeanInspector extends Inspector
{

	protected MethodDescriptor getCurrentMethod()
	{
		return getInstanceTree().getCurrentMethod();
	}

	protected void setCurrentMethod( MethodDescriptor method )
	{
		getInstanceTree().setCurrentMethod( method );
	}

	protected String getterName()
	{
		JavaClassDescriptor booleanDescriptor = new JavaClassDescriptor( boolean.class );
		ClassDescriptor parameterDescriptor = getCurrentMethod().getParameterTypes().get( 0 );
		if ( parameterDescriptor.isAssignableFrom( booleanDescriptor ) )
		{
			return getCurrentMethod().getName().replaceFirst( "set", "is" );
		}
		return getCurrentMethod().getName().replaceFirst( "set", "get" );
	}

	protected MethodDescriptor getterMethod()
	{
		List<MethodDescriptor> methods = objectClass().getMethods();
		for ( MethodDescriptor method : methods )
		{
			if ( isGetter( method ) )
			{
				return method;
			}
		}
		return null;
	}

	protected List<MethodDescriptor> sortedMethods()
	{
		if ( getInstanceTree().isStop() )
		{
			return Collections.emptyList();
		}
		List<MethodDescriptor> methods = objectClass().getMethods();
		Collections.sort( methods, new MethodNameComparator() );
		Collections.sort( methods, new CollectionMethodComparator() );
		Collections.sort( methods, new MapMethodComparator() );
		Collections.sort( methods, new ArrayMethodComparator() );
		return methods;
	}

	public void inspect( InstanceTree inTree )
	{
		setInstanceTree( inTree );
		List<MethodDescriptor> methods = sortedMethods();
		for ( MethodDescriptor method : methods )
		{
			setCurrentMethod( method );
			addMethodAccessPath();
		}

	}

	protected void addMethodAccessPath()
	{
		if ( isSetter() && hasGetterMethod() )
		{
			MethodDescriptor getter = getterMethod();
			ObjectDescriptor result = invoke( getter );
			if ( result != null )
			{
				addAccessPathForResult( getter, result );
			}
		}
	}

	protected void addAccessPathForResult( MethodDescriptor inGetter, ObjectDescriptor result )
	{
		AccessPath path = createAccessorMethodPath( inGetter, result );
		addAccessPath( path );
	}

	protected AccessPath createAccessorMethodPath( MethodDescriptor inGetter,
			ObjectDescriptor result )
	{
		AccessorMethodPath accessor = new AccessorMethodPath();
		accessor.setSetter( getCurrentMethod() );
		accessor.setGetter( inGetter );
		InstanceTree tree = createInstanceTree( result );
		accessor.setTree( tree );
		debug( "created accessor " + accessor + " for result " + result );
		return accessor;
	}

	protected boolean isSetter()
	{
		MethodDescriptor method = getCurrentMethod();
		return method.getModifiers().contains( StateModifier.PUBLIC )
				&& method.getName().startsWith( "set" ) && method.getParameterTypes().size() == 1;
	}

	protected boolean isGetter( MethodDescriptor method )
	{
		return method.getName().equals( getterName() ) && method.getParameterTypes().size() == 0
				&& !method.getModifiers().contains( StateModifier.STATIC );
	}

	protected boolean hasGetterMethod()
	{
		return getterMethod() != null;
	}

	protected ObjectDescriptor invoke( MethodDescriptor getter )
	{
		try
		{
			return getObject().invokeMethod( getter );
		}
		catch ( Exception e )
		{
			throw new RecorderException( e );
		}

	}
}
