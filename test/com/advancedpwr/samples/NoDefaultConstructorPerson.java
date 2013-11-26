package com.advancedpwr.samples;

public class NoDefaultConstructorPerson extends Person
{
	public NoDefaultConstructorPerson( Person inDad )
	{
		setDad( inDad );
	}
}
