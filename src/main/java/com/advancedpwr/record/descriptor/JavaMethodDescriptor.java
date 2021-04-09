package com.advancedpwr.record.descriptor;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.advancedpwr.record.RecorderException;

public class JavaMethodDescriptor implements MethodDescriptor
{
	protected Method fieldSubject;

	public Method subject()
	{
		return fieldSubject;
	}

	public void setSubject( Method method )
	{
		fieldSubject = method;
	}

	public JavaMethodDescriptor()
	{

	}

	public JavaMethodDescriptor( Method method )
	{
		setSubject( method );
	}

	@Override
	public String getName()
	{
		return subject().getName();
	}

	@Override
	public ClassDescriptor getReturnType()
	{
		return new JavaClassDescriptor( subject().getReturnType() );
	}

	@Override
	public List<ClassDescriptor> getParameterTypes()
	{
		return toList( subject().getParameterTypes() );
	}

	@Override
	public List<ClassDescriptor> getExceptionTypes()
	{
		return toList( subject().getExceptionTypes() );
	}

	protected ArrayList<ClassDescriptor> toList( Class<?>[] classArray )
	{
		ArrayList<ClassDescriptor> descriptors = new ArrayList<ClassDescriptor>();
		for ( Class<?> aClass : classArray )
		{
			descriptors.add( new JavaClassDescriptor( aClass ) );
		}
		return descriptors;
	}

	@Override
	public Set<StateModifier> getModifiers()
	{

		return StateModifierFactory.fromReflectionInt( subject().getModifiers() );
	}

	@Override
	public ObjectDescriptor invoke( Object object, Object... params )
	{
		try
		{
			return new JavaObjectDescriptor( subject().invoke( object, params ) );
		}
		catch ( Exception e )
		{
			throw new RecorderException( e );
		}
	}

	@Override
	public void setAccessible( boolean accessible )
	{
		subject().setAccessible( accessible );
	}

	@Override
	public int hashCode()
	{
		return subject().hashCode();
	}

	@Override
	public boolean equals( Object obj )
	{
		if ( obj instanceof JavaMethodDescriptor )
		{
			return obj.hashCode() == hashCode();
		}
		return super.equals( obj );
	}
}
