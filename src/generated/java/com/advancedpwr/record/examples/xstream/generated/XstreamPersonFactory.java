package com.advancedpwr.record.examples.xstream.generated;

import java.io.InputStream;
import com.thoughtworks.xstream.XStream;
import com.advancedpwr.samples.Person;

public class XstreamPersonFactory
{

	public Person buildPerson()
	{
		XStream xstream = new XStream();
		InputStream in = getClass().getResourceAsStream( "/com/advancedpwr/record/examples/xstream/generated/XstreamPersonFactory.xml" );
		return (Person)xstream.fromXML( in );
	}

}
