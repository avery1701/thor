package com.advancedpwr.record;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import org.junit.jupiter.api.Test;

import com.advancedpwr.record.descriptor.JavaClassDescriptor;
import com.advancedpwr.samples.ListExample;

public class ListRecorderTest extends AbstractRecorderTest
{
	private static final JavaClassDescriptor ARRAYLIST_DESCRIPTOR = new JavaClassDescriptor(
			ArrayList.class );
	protected static final JavaClassDescriptor LIST_DESCRIPTOR = new JavaClassDescriptor(
			List.class );

	@Test
	public void testWriteObject_list()
	{
		Vector<String> vector = new Vector<String>();
		vector.add( "entry 1" );
		vector.add( "entry 2" );

		ListExample listHolder = new ListExample();
		listHolder.setList( vector );
		recorder.setClassName( "com.example.list.ListExampleVectorFactory" );
		recorder.record( listHolder );
		assertResult();
	}

	@Test
	public void testSubstitute()
	{
		recorder.useTypeForInterface( LIST_DESCRIPTOR, ARRAYLIST_DESCRIPTOR );

		MyList<String> vector = new MyList<String>();
		vector.add( "entry 1" );
		vector.add( "entry 2" );

		ListExample listHolder = new ListExample();
		listHolder.setList( vector );
		recorder.setClassName( "com.example.list.ListExampleSubstitutionFactory" );
		recorder.useTypeForInterface( LIST_DESCRIPTOR, ARRAYLIST_DESCRIPTOR );
		recorder.record( listHolder );

		assertResult();
	}

	public void testSubstitute_failure()
	{
		recorder.useTypeForInterface( LIST_DESCRIPTOR, ARRAYLIST_DESCRIPTOR );

		Vector<String> vector = new Vector<String>();
		vector.add( "entry 1" );
		vector.add( "entry 2" );

		ListExample listHolder = new ListExample();
		listHolder.setList( vector );

		try
		{
			recorder.useTypeForInterface( LIST_DESCRIPTOR,
					new JavaClassDescriptor( HashMap.class ) );
			fail( "Should have thrown an exception" );
		}
		catch ( Exception e )
		{
			assertEquals(
					"class java.util.HashMapFactory cannot be used for interface java.util.ListFactory",
					e.getMessage() );
		}

	}
}
