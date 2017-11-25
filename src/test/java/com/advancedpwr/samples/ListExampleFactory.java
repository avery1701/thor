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
package com.advancedpwr.samples;

import java.util.List;
import java.util.Vector;

public class ListExampleFactory
{
	public ListExample buildListExample()
	{
		ListExample ex = new ListExample();
		ex.setList( buildVector() );
		return ex;
	}

	protected List buildVector()
	{
		Vector vector = new Vector();
		vector.add( "entry 1" );
		vector.add( "entry 2" );
		return vector;
	}
	
}