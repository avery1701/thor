package com.advancedpwr.record;

import java.util.List;

public interface ValueInspector
{
	public List<MethodAccessor> methods();
	
	public List<ValueInspector> interfaces();
	
	public ValueInspector value(MethodAccessor method);
	
	public String name();
	
	public String type();
	
	public String value();
}
