package com.example.methods;

import com.advancedpwr.record.factory.BaseFactory;
import com.advancedpwr.record.methods.DateHolder;
import java.util.Date;

public class DateHolderFactory extends BaseFactory
{

	protected DateHolder dateholder;

	public DateHolder buildDateHolder()
	{
		if ( dateholder != null ) 
		{
			return dateholder;
		}
		dateholder = new DateHolder();
		dateholder.setDate( buildDate_1_1() );
		dateholder.setOtherDate( buildDate_1_1() );
		return dateholder;
	}

	protected Date date_1_1;

	protected Date buildDate_1_1()
	{
		date_1_1 = new Date( 1234567689l );
		return date_1_1;
	}

}
