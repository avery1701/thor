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
package com.advancedpwr.record.mock;

import java.net.URL;

import com.advancedpwr.samples.FinalStuff;

public class URLTest extends AbstractMockRecorderTest
{
	public void testURL() throws Exception
	{
		URL url = new URL( "http://localhost" );
		FinalStuff obj = new FinalStuff();
		recorder.setClassName( "com.example.mock.MockUrlFactory" );

		obj = recorder.record( obj );
		obj.setURL( url );
		obj.getURL();
		recorder.endRecording();
		assertResult();
	}
}
