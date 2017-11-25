/**
 * 
 */
package com.advancedpwr.record.methods;

import com.advancedpwr.record.AccessPath;
import com.advancedpwr.record.MockBeanMethodBuilder;

/**
 * @author Matthew Avery, mavery@advancedpwr.com
 * Created: Feb 14, 2012
 *
 */
public class MockMethodWriterFactory  implements MethodWriterFactory 
{
	protected Class fieldMatchingClass;
	/* (non-Javadoc)
	 * @see com.advancedpwr.record.methods.MethodWriterFactory#accept(java.lang.Class)
	 */
	public boolean accept( Class inClass )
	{
		return getMatchingClass().equals( inClass );
	}

	/* (non-Javadoc)
	 * @see com.advancedpwr.record.methods.MethodWriterFactory#createMethodBuilder(com.advancedpwr.record.AccessPath)
	 */
	public BuildMethodWriter createMethodBuilder( AccessPath inPath )
	{
		return new MockBeanMethodBuilder();
	}

	public Class getMatchingClass()
	{
		return fieldMatchingClass;
	}

	public void setMatchingClass( Class matchingClass )
	{
		fieldMatchingClass = matchingClass;
	}
	 
}
