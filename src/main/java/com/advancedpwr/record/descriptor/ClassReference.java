/*
 * Copyright 2021 Matthew Avery, mavery@advancedpwr.com
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
package com.advancedpwr.record.descriptor;

/**
 * @author Matthew Avery, mavery@advancedpwr.com on Apr 9, 2021
 *
 */
public interface ClassReference
{
	public static final String GENERATED = ".generated";

	public static final String FACTORY = "Factory";
	
	String getClassName();

	String getPackageName();
	
	boolean isAnonymousClass();

	boolean isArray();
	
	boolean isPrimitive();

	boolean isEnum();
}
