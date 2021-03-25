package com.advancedpwr.record;

import java.util.HashMap;
import java.util.Set;

public class InterfaceClassSubstitutor extends HashMap<ClassDescriptor, ClassDescriptor>
{
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * Substitutes an interface (descriptor) with a class (descriptor) based on the internal map.
	 * 
	 * @return A substitute class for the input interface, or the interface if no substitute was found.
	 */
	public ClassDescriptor substitute(ClassDescriptor anInterface)
	{
		Set<ClassDescriptor> interfaces = anInterface.getInterfaces();
		for ( ClassDescriptor i : interfaces )
		{
			if ( this.containsKey( i ) )
			{
				return this.get( i );
			}
		}
		return anInterface;
	}
}
