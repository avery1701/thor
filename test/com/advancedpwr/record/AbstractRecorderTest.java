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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import junit.framework.TestCase;

public abstract class AbstractRecorderTest extends TestCase
{
	public static final String WRITE_FILES = "write.files";
	protected BeanRecorder recorder;
	protected MultiWriter result;
	
	protected void setUp()
	{
		setWriteFiles();
		recorder = new BeanRecorder();
		configureRecorder( recorder );
	}
	
	protected BeanRecorder getRecorder()
	{
		return recorder;
	}

	public void configureRecorder( final AbstractRecorder inRecorder )
	{
		result = new MultiWriter();
		if ( writeFiles() )
		{
			inRecorder.setDestination( "generated" );
			result = new MultiWriter()
			{

				public FileWriter getFileWriter()
				{
					return inRecorder.getJavaFileWriter();
				}
				
			};
		}

		inRecorder.setWriter( result );
		
	}

	protected boolean writeFiles()
	{
		return "true".equalsIgnoreCase( System.getProperty( WRITE_FILES ));
	}
	
	public static void setWriteFiles()
	{
		System.setProperty( WRITE_FILES, "true" );
	}
	
	public void assertResult( String inString )
	{
		assertEquals( inString.replaceAll( "\r\n", "\n" ), result.toString().replaceAll( "\r\n", "\n" ) );
	}
	
	public void assertResult()
	{
		assertResult( reference() );
		System.out.println( referenceFile().getAbsolutePath() + " matches " + getRecorder().javaFile() );
	}
	
	public String reference()
	{
		try
		{
			File file = referenceFile();
			FileReader fileReader = new FileReader( file );
			BufferedReader reader = new BufferedReader( fileReader );
			StringBuffer sb = new StringBuffer();
			while( reader.ready() )
			{
				sb.append( reader.readLine() );
				sb.append("\n");
			}
			reader.close();
			return sb.toString();
		}
		catch ( FileNotFoundException e )
		{
			throw new RuntimeException(e);
		}
		catch ( IOException e )
		{
			throw new RuntimeException(e);
		}
	}

	protected File referenceFile()
	{
		String fileName = getRecorder().getClassName() + ".java";
		File dir = new File("reference", getRecorder().packagePath() );
		File file = new File( dir, fileName );
		return file;
	}
}
