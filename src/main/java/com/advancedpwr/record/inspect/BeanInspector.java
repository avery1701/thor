package com.advancedpwr.record.inspect;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import com.advancedpwr.record.AccessPath;
import com.advancedpwr.record.InstanceTree;
import com.advancedpwr.record.RecorderException;
import com.advancedpwr.record.descriptor.MethodDescriptor;

public class BeanInspector extends Inspector
{
	
	protected List<MethodDescriptor> sortedMethods()
	{
		if ( getInstanceTree().isStop() )
		{
			return Collections.EMPTY_LIST;
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
		List<Method> methods = sortedMethods();
		for ( Method method : methods )
		{
			setCurrentMethod( method );
			addMethodAccessPath();
		}
		
	}
	
	protected void addMethodAccessPath()
	{
		if ( isSetter() && hasGetterMethod() )
		{
			Method getter = getterMethod();
			Object result = invoke( getter );
			if ( result != null )
			{
				addAccessPathForResult( getter, result );
			}
		}
	}
	
	protected void addAccessPathForResult( Method inGetter, Object result )
	{
		AccessPath path = createAccessorMethodPath( inGetter, result );
		addAccessPath( path );
	}
	
	protected AccessPath createAccessorMethodPath( Method inGetter, Object result )
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
		Method method = getCurrentMethod();
		return Modifier.isPublic( method.getModifiers() )  && method.getName().startsWith( "set" ) && method.getParameterTypes().length == 1;
	}
	
	protected String getterName()
	{
		if( boolean.class.equals( getCurrentMethod().getParameterTypes()[0] ) )
		{
			return getCurrentMethod().getName().replaceFirst( "set", "is" );
		}
		return getCurrentMethod().getName().replaceFirst( "set", "get" );
	}
	
	protected Method getterMethod()
	{
		Method[] methods = objectClass().getMethods();
		for ( int i = 0; i < methods.length; i++ )
		{
			Method method = methods[i];
			if ( isGetter( method ) )
			{
				return method;
			}
		}
		return null;
	}

	protected boolean isGetter( Method method )
	{
		return method.getName().equals( getterName() ) && method.getParameterTypes().length == 0 && !Modifier.isStatic( method.getModifiers() );
	}
	
	protected boolean hasGetterMethod()
	{
		return getterMethod() != null;
	}

	protected Method getCurrentMethod()
	{
		return getInstanceTree().getCurrentMethod();
	}

	protected void setCurrentMethod( Method currentMethod )
	{
		getInstanceTree().setCurrentMethod( currentMethod );
	}
	
	protected Object invoke( Method getter )
	{
		try
		{
			getter.setAccessible( true );
			return getter.invoke( getObject() );
		}
		catch ( Exception e )
		{
			throw new RecorderException( e );
		}
		
	}
}
