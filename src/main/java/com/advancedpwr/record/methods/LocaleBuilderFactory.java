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
package com.advancedpwr.record.methods;

import java.util.Locale;

import com.advancedpwr.record.AccessPath;
import com.advancedpwr.record.descriptor.ClassDescriptor;
import com.advancedpwr.record.descriptor.JavaClassDescriptor;

public class LocaleBuilderFactory implements MethodWriterFactory 
{
	public boolean accept( ClassDescriptor inClass )
	{
		JavaClassDescriptor descriptor = new JavaClassDescriptor( Locale.class );
		return inClass.isAssignableFrom( descriptor );
	}
	
	public BuildMethodWriter createMethodBuilder( AccessPath inPath )
	{
		return new LocaleBuilder();
	}
}
