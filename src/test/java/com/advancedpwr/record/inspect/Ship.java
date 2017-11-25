package com.advancedpwr.record.inspect;

import com.advancedpwr.samples.Person;

public class Ship
{
	protected Person fieldCaptain;

	public Person getCaptain()
	{
		return fieldCaptain;
	}

	public void setCaptain( Person captain )
	{
		fieldCaptain = captain;
	}
	
	public String getCaptainsName()
	{
		return getCaptain().getName();
	}
	
}
