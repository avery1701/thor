package com.advancedpwr.generate;

public class TestGenerator
{
	public void createTest( Object object, String destination )
	{
		TestWriter writer = new TestWriter();
		writer.setDestination( destination );
		writer.record( object );
	}
}
