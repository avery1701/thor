package com.advancedpwr.samples;

class PrivatePerson extends Person
{
	public Being createPerson()
	{
		return new PrivatePerson();
	}
}
