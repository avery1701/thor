package com.advancedpwr.record.mock;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class ClassMethodInterceptor implements MethodInterceptor, Serializable
{
	private static final long serialVersionUID = -7675836399519658130L;
	private final InvocationHandler handler;


	public ClassMethodInterceptor( final InvocationHandler handler )
	{
		this.handler = handler;
	}

	public Object intercept( final Object obj, final Method method, final Object[] args,
			final MethodProxy proxy ) throws Throwable
	{
		return handler.invoke( obj, method, args );
	}
}