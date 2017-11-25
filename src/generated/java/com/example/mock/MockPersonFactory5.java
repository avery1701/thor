package com.example.mock;

import  static org.easymock.EasyMock.*;
import com.advancedpwr.record.factory.BaseFactory;
import com.advancedpwr.samples.Family;

public class MockPersonFactory5 extends BaseFactory
{

	protected Family family;

	public Family buildFamily() throws Exception
	{
		if ( family != null ) 
		{
			return family;
		}
		family = createStrictMock( Family.class );
		family.fued();
		expectLastCall().andThrow( buildException_1_1() );
		replay( family );
		return family;
	}

	protected Exception exception_1_1;

	protected Exception buildException_1_1()
	{
		if ( exception_1_1 != null ) 
		{
			return exception_1_1;
		}
		exception_1_1 = createStrictMock( Exception.class );
		replay( exception_1_1 );
		return exception_1_1;
	}
}
