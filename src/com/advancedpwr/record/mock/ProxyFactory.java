package com.advancedpwr.record.mock;

import java.lang.reflect.InvocationHandler;

public interface ProxyFactory
{
	<T> T createProxy(Class<T> toProxy, InvocationHandler handler );
}
