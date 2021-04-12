package com.advancedpwr.samples;

import java.util.List;

public class BadPerson extends Person
{
	public List<?> getChildren()
	{
		throw new RuntimeException( "bad stuff" );
	}
}
