package com.example.list;

import com.advancedpwr.record.factory.BaseFactory;
import com.advancedpwr.samples.ListExample;
import java.util.List;
import java.util.Vector;

public class ListExampleVectorFactory extends BaseFactory
{

	protected ListExample listexample;

	public ListExample buildListExample()
	{
		if ( listexample != null ) 
		{
			return listexample;
		}
		listexample = new ListExample();
		listexample.setList( buildVector_1_1() );
		return listexample;
	}

	protected Vector vector_1_1;

	protected List buildVector_1_1()
	{
		if ( vector_1_1 != null ) 
		{
			return vector_1_1;
		}
		vector_1_1 = new Vector();
		vector_1_1.add( "entry 1" );
		vector_1_1.add( "entry 2" );
		return vector_1_1;
	}

}
