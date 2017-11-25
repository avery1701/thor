package com.example.array.mock;

import  static org.easymock.EasyMock.*;
import com.advancedpwr.record.factory.BaseFactory;
import com.advancedpwr.samples.Family;

public class ArrayExceptionFactory extends BaseFactory
{

	protected Family[] familyArray;

	public Family[] buildFamilyArray() throws Exception
	{
		if ( familyArray != null ) 
		{
			return familyArray;
		}
		familyArray = new Family[2];
		familyArray[0] = buildFamily_1_1();
		familyArray[1] = buildFamily_2_1();
		return familyArray;
	}

	protected Family family_1_1;

	protected Family buildFamily_1_1() throws Exception
	{
		if ( family_1_1 != null ) 
		{
			return family_1_1;
		}
		family_1_1 = createStrictMock( Family.class );
		family_1_1.fued();
		expectLastCall().andThrow( buildException_3_2() );
		replay( family_1_1 );
		return family_1_1;
	}

	protected Exception exception_3_2;

	protected Exception buildException_3_2()
	{
		if ( exception_3_2 != null ) 
		{
			return exception_3_2;
		}
		exception_3_2 = createStrictMock( Exception.class );
		replay( exception_3_2 );
		return exception_3_2;
	}

	protected Family family_2_1;

	protected Family buildFamily_2_1()
	{
		if ( family_2_1 != null ) 
		{
			return family_2_1;
		}
		family_2_1 = createStrictMock( Family.class );
		replay( family_2_1 );
		return family_2_1;
	}
}
