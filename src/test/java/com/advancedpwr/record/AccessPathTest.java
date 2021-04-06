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

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.advancedpwr.record.descriptor.JavaClassDescriptor;
import com.advancedpwr.record.descriptor.JavaObjectDescriptor;

public class AccessPathTest
{

	@Test
	public void testAccessPath()
	{
		AccessPath path = new AccessPath();
		path.setTree( new InstanceTree( new JavaObjectDescriptor( "Joe" ) ) );
		assertEquals( new JavaClassDescriptor( String.class ), path.getReturnType() );
	}

}
