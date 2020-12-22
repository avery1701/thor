package com.advancedpwr.record;

public class ClassWriterDelagate
{
	protected ClassWriter fieldClassWriter;
	
	public ClassWriter getClassWriter()
	{
		return fieldClassWriter;
	}

	public void setClassWriter( ClassWriter classWriter )
	{
		fieldClassWriter = classWriter;
	}

	public ClassWriter closeBrace()
	{
		return getClassWriter().closeBrace();
	}

	public ClassWriter openBrace()
	{
		return getClassWriter().openBrace();
	}

	public void writeLine( String inString )
	{
		getClassWriter().writeLine( inString );
	}

	public void write( String inString )
	{
		getClassWriter().write( inString );
	}
	
	protected void newLine()
	{
		getClassWriter().newLine();
	}

}
