package com.advancedpwr.record.methods;

public class EnumBuilder extends BuildMethodWriter
{

	public void buildMethod()
	{

		newLine();
		writeMethodSignature();
		openBrace();

		writeLine( "return " + instanceType() + "." + enumInstance() );
		closeBrace();
		
	}

	protected String enumInstance()
	{
		return ((Enum)getAccessPath().getResult()).name();
	}
}
