/**
 * 
 */
package com.advancedpwr.record.methods;

import com.advancedpwr.record.AccessPath;
import com.advancedpwr.record.MockBeanMethodBuilder;
import com.advancedpwr.record.descriptor.ClassDescriptor;

/**
 * @author Matthew Avery, mavery@advancedpwr.com
 * Created: Feb 14, 2012
 */
public class MockMethodWriterFactory  implements MethodWriterFactory 
{
	protected ClassDescriptor fieldMatchingClass;
	
	/* (non-Javadoc)
	 * @see com.advancedpwr.record.methods.MethodWriterFactory#accept(java.lang.Class)
	 */
	public boolean accept( ClassDescriptor inClass )
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

	public ClassDescriptor getMatchingClass()
	{
		return fieldMatchingClass;
	}

	public void setMatchingClass( ClassDescriptor matchingClass )
	{
		fieldMatchingClass = matchingClass;
	}
	 
}
