package com.advancedpwr.generate;

import java.lang.reflect.Parameter;
import java.util.ArrayList;

import com.advancedpwr.record.ClassWriter;

public class InstanceWriterFactory extends ArrayList<InstanceWriter>
{
	public void writeInstance( ClassWriter classWriter, Parameter param )
	{
		if( new PrimitiveInstanceWriter( classWriter ).writeInstance( param ) )
		{
			return;
		}
		if ( new ArrayInstanceWriter( classWriter ).writeInstance( param ) )
		{
			return;
		}
		if ( new ListInstanceWriter( classWriter).writeInstance(param) )
		{
			return;
		}
		new DefaultInstanceWriter( classWriter ).writeInstance( param );
	}
}
