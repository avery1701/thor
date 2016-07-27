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
/**
 * Copyright 2003-2009 OFFIS, Henri Tremblay
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
 * 
 * Matthew Avery, mavery@advancedpwr.com on Oct 5, 2010
 * Removed the ObjectMethodsFilter hack so that this will work with a generic InvocationHandler
 */
package com.advancedpwr.record.mock;

import java.lang.reflect.InvocationHandler;
import java.util.List;

import net.sf.cglib.core.CollectionUtils;
import net.sf.cglib.core.VisibilityPredicate;
import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

import org.objenesis.ObjenesisStd;

public class ClassProxyFactory implements ProxyFactory
{
	public <T> T createProxy( Class<T> toProxy, InvocationHandler handler )
	{

		Enhancer enhancer = createEnhancer( toProxy );

		MethodInterceptor interceptor = createMethodInterceptor( handler );
		enhancer.setCallbackType( interceptor.getClass() );

		Class enhancedProxyClass = enhancer.createClass();

		Enhancer.registerCallbacks( enhancedProxyClass, new Callback[] { interceptor } );
		return (T) createInstance( enhancedProxyClass );
	}

	protected ClassMethodInterceptor createMethodInterceptor( InvocationHandler handler )
	{
		return new ClassMethodInterceptor( handler );
	}

	protected <T> T createInstance( Class enhancedProxyClass )
	{
		try
		{
			return (T) enhancedProxyClass.newInstance();
		}
		catch ( Exception e )
		{
			//Warning: If there is not a no-arg constructor, we try this,
			//but it caused failures in the unit test when used for general use.
			return (T) new ObjenesisStd().newInstance( enhancedProxyClass );
		}

	}

	protected Enhancer createEnhancer( Class toProxy )
	{
		Enhancer enhancer = new Enhancer()
		{
			protected void filterConstructors( final Class sc, final List constructors )
			{
				CollectionUtils.filter( constructors, new VisibilityPredicate( sc, true ) );
			}
		};
		enhancer.setSuperclass( toProxy );

		return enhancer;
	}
}
