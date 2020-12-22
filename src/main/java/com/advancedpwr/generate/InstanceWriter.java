package com.advancedpwr.generate;

import java.lang.reflect.Parameter;

public interface InstanceWriter
{
	// returns true if this writer was able to write an instance
	public boolean writeInstance( Class inClass );
	
	// returns true if this writer was able to write an instance
	public boolean writeInstance( Parameter param );
}
