package com.advancedpwr.record.descriptor;

import java.lang.reflect.Modifier;
import java.util.EnumSet;

//FIXME: This is not clean. PLEASE HELP
public class StateModifierFactory
{

	protected static boolean hasFlag( int modifiers, int flag )
	{
		return ( modifiers & flag ) == flag;
	}
	static EnumSet<StateModifier> fromReflectionInt( int modifiers )
	{
		EnumSet<StateModifier> states = EnumSet.noneOf( StateModifier.class );

		if ( hasFlag( modifiers, Modifier.PUBLIC ) )
		{
			states.add( StateModifier.PUBLIC );
		}
		if ( hasFlag( modifiers, Modifier.PRIVATE ) )
		{
			states.add( StateModifier.PRIVATE );
		}
		if ( hasFlag( modifiers, Modifier.PROTECTED ) )
		{
			states.add( StateModifier.PROTECTED );
		}
		if ( hasFlag( modifiers, Modifier.STATIC ) )
		{
			states.add( StateModifier.STATIC );
		}
		if ( hasFlag( modifiers, Modifier.FINAL ) )
		{
			states.add( StateModifier.FINAL );
		}
		if ( hasFlag( modifiers, Modifier.SYNCHRONIZED ) )
		{
			states.add( StateModifier.SYNCHRONIZED );
		}
		if ( hasFlag( modifiers, Modifier.VOLATILE ) )
		{
			states.add( StateModifier.VOLITILE );
		}
		if ( hasFlag( modifiers, Modifier.TRANSIENT ) )
		{
			states.add( StateModifier.TRANSIENT );
		}
		if ( hasFlag( modifiers, Modifier.NATIVE ) )
		{
			states.add( StateModifier.NATIVE );
		}
		if ( hasFlag( modifiers, Modifier.INTERFACE ) )
		{
			states.add( StateModifier.INTERFACE );
		}
		if ( hasFlag( modifiers, Modifier.ABSTRACT ) )
		{
			states.add( StateModifier.ABSTRACT );
		}
		if ( hasFlag( modifiers, Modifier.STRICT ) )
		{
			states.add( StateModifier.STRICT );
		}

		return states;
	}

}
