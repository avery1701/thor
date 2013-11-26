/**
 * 
 */
package com.advancedpwr.record;

import com.advancedpwr.record.inspect.AccessorMethodPath;
import com.advancedpwr.record.mock.NiceMockMethodBuilder;

/**
 * @author Matthew Avery, mavery@advancedpwr.com
 * Created: Feb 14, 2012
 *
 */
public class MockBeanMethodBuilder extends NiceMockMethodBuilder
{

	protected String methodName( AccessPath result )
	{
		if ( result instanceof AccessorMethodPath )
		{
			AccessorMethodPath path = (AccessorMethodPath) result;
			return path.getGetter().getName();
		}
		return result.pathName();
	}
}
