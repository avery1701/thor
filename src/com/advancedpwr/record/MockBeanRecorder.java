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

import com.advancedpwr.record.factory.MockBeanFactory;
import com.advancedpwr.record.methods.MockMethodWriterFactory;

/**
 * An extension of {@link BeanRecorder} that enables the recording of beans as EasyMock objects.
 * Factories created by this recorder will extend {@link MockBeanFactory} by default.
 * 
 * @author Matthew Avery, mavery@advancedpwr.com on Feb 20, 2012
 *
 */
public class MockBeanRecorder extends BeanRecorder
{
	public MockBeanRecorder()
	{
		setSuperClass( MockBeanFactory.class );
	}
	
	/**
	 * Create a bean as a mock object when objects of the supplied class are encountered
	 * 
	 * @param inClass - Objects of this type will be re-created in the factory as mock objects.
	 */
	public void mock( Class inClass )
	{
		MockMethodWriterFactory factory = new MockMethodWriterFactory();
		factory.setMatchingClass( inClass );
		addBuilderFactory( factory );
	}
}
