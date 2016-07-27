package com.example.list;

import com.advancedpwr.record.factory.BaseFactory;
import com.advancedpwr.samples.ListExample;
import java.util.List;
import java.util.ArrayList;

public class ListExampleSubstitutionFactory extends BaseFactory
{

	protected ListExample listexample;

	public ListExample buildListExample()
	{
		if ( listexample != null ) 
		{
			return listexample;
		}
		listexample = new ListExample();
		listexample.setList( buildArrayList_1_1() );
		return listexample;
	}

	protected ArrayList arraylist_1_1;

	protected List buildArrayList_1_1()
	{
		if ( arraylist_1_1 != null ) 
		{
			return arraylist_1_1;
		}
		arraylist_1_1 = new ArrayList();
		arraylist_1_1.add( "entry 1" );
		arraylist_1_1.add( "entry 2" );
		return arraylist_1_1;
	}

}
