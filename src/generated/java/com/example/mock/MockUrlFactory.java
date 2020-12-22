package com.example.mock;

import  static org.easymock.EasyMock.*;
import com.advancedpwr.record.factory.BaseFactory;
import com.advancedpwr.samples.FinalStuff;
import java.net.URL;

public class MockUrlFactory extends BaseFactory
{

	protected FinalStuff finalstuff;

	public FinalStuff buildFinalStuff()
	{
		if ( finalstuff != null ) 
		{
			return finalstuff;
		}
		finalstuff = createStrictMock( FinalStuff.class );
		finalstuff.setURL( buildURL_2_1() );
		expect( finalstuff.getURL() ).andReturn( buildURL_2_1() );
		replay( finalstuff );
		return finalstuff;
	}

	protected URL url_2_1;

	protected URL buildURL_2_1()
	{
		if ( url_2_1 != null ) 
		{
			return url_2_1;
		}
		try
		{
			url_2_1 = new URL( "http://localhost" );
		}
		catch( Exception e )
		{
			throw new RuntimeException( e );
		}
		return url_2_1;
	}
}
