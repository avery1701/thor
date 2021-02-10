package com.advancedpwr.samples;

public class PersonFactory
{

	public Person createExamplePerson()
	{
		Person grandpa = createGrandPa();
		
		Person dad = new Person();
		dad.setName( "dad" );
		dad.setDad( grandpa );
		
		Person mom = new Person();
		mom.setName( "mom" );
		
		Person son = new Person();
		son.setName( "son" );
		son.setDad( dad );
		son.setMom( mom );
		
		return son;
	}

	protected Person createGrandPa()
	{
		Person grandpa = new Person();
		grandpa.setName( "grandpa" );
		return grandpa;
	}

}
