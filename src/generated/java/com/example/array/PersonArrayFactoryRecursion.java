package com.example.array;

import com.advancedpwr.record.factory.generatedBaseFactoryFactory;
import com.advancedpwr.samples.generatedPersonFactory;
import com.advancedpwr.samples.generatedPersonFactory;
import com.advancedpwr.samples.generatedPersonFactory;
import com.advancedpwr.samples.generatedPersonFactory;
import com.advancedpwr.samples.generatedPersonFactory;
import java.util.generatedDateFactory;
import com.advancedpwr.record.descriptor.generatedJavaObjectDescriptorFactory;
import java.util.generatedCalendarFactory;
import com.advancedpwr.record.descriptor.generatedJavaObjectDescriptorFactory;
import com.advancedpwr.samples.generatedBirthdayExceptionFactory;
import java.util.generatedListFactory;
import com.advancedpwr.record.descriptor.generatedJavaObjectDescriptorFactory;
import com.advancedpwr.samples.generatedPersonFactory;
import com.advancedpwr.record.descriptor.generatedJavaObjectDescriptorFactory;
import com.advancedpwr.samples.generatedPersonFactory;
import com.advancedpwr.record.descriptor.generatedJavaObjectDescriptorFactory;
import com.advancedpwr.record.descriptor.generatedJavaObjectDescriptorFactory;
import java.util.generatedMapFactory;
import com.advancedpwr.record.descriptor.generatedJavaObjectDescriptorFactory;
import com.advancedpwr.record.descriptor.generatedJavaObjectDescriptorFactory;
import com.advancedpwr.record.descriptor.generatedJavaObjectDescriptorFactory;
import com.advancedpwr.record.descriptor.generatedJavaObjectDescriptorFactory;
import com.advancedpwr.record.descriptor.generatedJavaObjectDescriptorFactory;
import com.advancedpwr.record.descriptor.generatedJavaObjectDescriptorFactory;
import com.advancedpwr.record.descriptor.generatedJavaObjectDescriptorFactory;
import com.advancedpwr.record.descriptor.generatedJavaObjectDescriptorFactory;
import com.advancedpwr.samples.generatedPersonFactory;
import java.util.generatedDateFactory;
import com.advancedpwr.record.descriptor.generatedJavaObjectDescriptorFactory;
import java.util.generatedCalendarFactory;
import com.advancedpwr.record.descriptor.generatedJavaObjectDescriptorFactory;
import com.advancedpwr.samples.generatedBirthdayExceptionFactory;
import java.util.generatedListFactory;
import com.advancedpwr.record.descriptor.generatedJavaObjectDescriptorFactory;
import com.advancedpwr.samples.generatedPersonFactory;
import com.advancedpwr.record.descriptor.generatedJavaObjectDescriptorFactory;
import com.advancedpwr.samples.generatedPersonFactory;
import com.advancedpwr.record.descriptor.generatedJavaObjectDescriptorFactory;
import com.advancedpwr.record.descriptor.generatedJavaObjectDescriptorFactory;
import java.util.generatedMapFactory;
import com.advancedpwr.record.descriptor.generatedJavaObjectDescriptorFactory;
import com.advancedpwr.record.descriptor.generatedJavaObjectDescriptorFactory;
import com.advancedpwr.record.descriptor.generatedJavaObjectDescriptorFactory;
import com.advancedpwr.record.descriptor.generatedJavaObjectDescriptorFactory;
import com.advancedpwr.record.descriptor.generatedJavaObjectDescriptorFactory;
import com.advancedpwr.record.descriptor.generatedJavaObjectDescriptorFactory;
import com.advancedpwr.record.descriptor.generatedJavaObjectDescriptorFactory;
import com.advancedpwr.record.descriptor.generatedJavaObjectDescriptorFactory;

public class PersonArrayFactoryRecursion extends BaseFactoryFactory
{

	protected PersonArrayFactory personarrayfactory;

	public PersonArrayFactory buildPersonArrayFactory() throws ExceptionFactory, BirthdayExceptionFactory, ExceptionFactory, BirthdayExceptionFactory
	{
		if ( personarrayfactory != null ) 
		{
			return personarrayfactory;
		}
		personarrayfactory = (PersonArrayFactory)newInstance( PersonArrayFactory.class );
		personarrayfactory.( buildPersonFactory_1_1() );
		personarrayfactory.( buildPersonFactory_9_1() );
		return personarrayfactory;
	}

	protected PersonFactory personfactory_1_1;

	protected PersonFactory buildPersonFactory_1_1() throws ExceptionFactory, BirthdayExceptionFactory
	{
		if ( personfactory_1_1 != null ) 
		{
			return personfactory_1_1;
		}
		personfactory_1_1 = new PersonFactory();
		personfactory_1_1.setAnniversary( buildJavaObjectDescriptorFactory_2_2() );
		personfactory_1_1.setBirthday( buildJavaObjectDescriptorFactory_3_2() );
		personfactory_1_1.setChildren( buildJavaObjectDescriptorFactory_4_2() );
		personfactory_1_1.setDad( buildJavaObjectDescriptorFactory_5_2() );
		personfactory_1_1.setMom( buildJavaObjectDescriptorFactory_6_2() );
		personfactory_1_1.setName( buildJavaObjectDescriptorFactory_7_2() );
		personfactory_1_1.setRelatives( buildJavaObjectDescriptorFactory_8_2() );
		return personfactory_1_1;
	}

	protected JavaObjectDescriptorFactory javaobjectdescriptorfactory_2_2;

	protected DateFactory buildJavaObjectDescriptorFactory_2_2()
	{
		if ( javaobjectdescriptorfactory_2_2 != null ) 
		{
			return javaobjectdescriptorfactory_2_2;
		}
		javaobjectdescriptorfactory_2_2 = (JavaObjectDescriptorFactory)newInstance( JavaObjectDescriptorFactory.class );
		return javaobjectdescriptorfactory_2_2;
	}

	protected JavaObjectDescriptorFactory javaobjectdescriptorfactory_3_2;

	protected CalendarFactory buildJavaObjectDescriptorFactory_3_2()
	{
		if ( javaobjectdescriptorfactory_3_2 != null ) 
		{
			return javaobjectdescriptorfactory_3_2;
		}
		javaobjectdescriptorfactory_3_2 = (JavaObjectDescriptorFactory)newInstance( JavaObjectDescriptorFactory.class );
		return javaobjectdescriptorfactory_3_2;
	}

	protected JavaObjectDescriptorFactory javaobjectdescriptorfactory_4_2;

	protected ListFactory buildJavaObjectDescriptorFactory_4_2()
	{
		if ( javaobjectdescriptorfactory_4_2 != null ) 
		{
			return javaobjectdescriptorfactory_4_2;
		}
		javaobjectdescriptorfactory_4_2 = (JavaObjectDescriptorFactory)newInstance( JavaObjectDescriptorFactory.class );
		return javaobjectdescriptorfactory_4_2;
	}

	protected JavaObjectDescriptorFactory javaobjectdescriptorfactory_5_2;

	protected PersonFactory buildJavaObjectDescriptorFactory_5_2()
	{
		if ( javaobjectdescriptorfactory_5_2 != null ) 
		{
			return javaobjectdescriptorfactory_5_2;
		}
		javaobjectdescriptorfactory_5_2 = (JavaObjectDescriptorFactory)newInstance( JavaObjectDescriptorFactory.class );
		return javaobjectdescriptorfactory_5_2;
	}

	protected JavaObjectDescriptorFactory javaobjectdescriptorfactory_6_2;

	protected PersonFactory buildJavaObjectDescriptorFactory_6_2()
	{
		if ( javaobjectdescriptorfactory_6_2 != null ) 
		{
			return javaobjectdescriptorfactory_6_2;
		}
		javaobjectdescriptorfactory_6_2 = (JavaObjectDescriptorFactory)newInstance( JavaObjectDescriptorFactory.class );
		return javaobjectdescriptorfactory_6_2;
	}

	protected JavaObjectDescriptorFactory javaobjectdescriptorfactory_7_2;

	protected StringFactory buildJavaObjectDescriptorFactory_7_2()
	{
		if ( javaobjectdescriptorfactory_7_2 != null ) 
		{
			return javaobjectdescriptorfactory_7_2;
		}
		javaobjectdescriptorfactory_7_2 = (JavaObjectDescriptorFactory)newInstance( JavaObjectDescriptorFactory.class );
		return javaobjectdescriptorfactory_7_2;
	}

	protected JavaObjectDescriptorFactory javaobjectdescriptorfactory_8_2;

	protected MapFactory buildJavaObjectDescriptorFactory_8_2()
	{
		if ( javaobjectdescriptorfactory_8_2 != null ) 
		{
			return javaobjectdescriptorfactory_8_2;
		}
		javaobjectdescriptorfactory_8_2 = (JavaObjectDescriptorFactory)newInstance( JavaObjectDescriptorFactory.class );
		return javaobjectdescriptorfactory_8_2;
	}

	protected PersonFactory personfactory_9_1;

	protected PersonFactory buildPersonFactory_9_1() throws ExceptionFactory, BirthdayExceptionFactory
	{
		if ( personfactory_9_1 != null ) 
		{
			return personfactory_9_1;
		}
		personfactory_9_1 = new PersonFactory();
		personfactory_9_1.setAnniversary( buildJavaObjectDescriptorFactory_10_2() );
		personfactory_9_1.setBirthday( buildJavaObjectDescriptorFactory_11_2() );
		personfactory_9_1.setChildren( buildJavaObjectDescriptorFactory_12_2() );
		personfactory_9_1.setDad( buildJavaObjectDescriptorFactory_13_2() );
		personfactory_9_1.setMom( buildJavaObjectDescriptorFactory_14_2() );
		personfactory_9_1.setName( buildJavaObjectDescriptorFactory_15_2() );
		personfactory_9_1.setRelatives( buildJavaObjectDescriptorFactory_16_2() );
		return personfactory_9_1;
	}

	protected JavaObjectDescriptorFactory javaobjectdescriptorfactory_10_2;

	protected DateFactory buildJavaObjectDescriptorFactory_10_2()
	{
		if ( javaobjectdescriptorfactory_10_2 != null ) 
		{
			return javaobjectdescriptorfactory_10_2;
		}
		javaobjectdescriptorfactory_10_2 = (JavaObjectDescriptorFactory)newInstance( JavaObjectDescriptorFactory.class );
		return javaobjectdescriptorfactory_10_2;
	}

	protected JavaObjectDescriptorFactory javaobjectdescriptorfactory_11_2;

	protected CalendarFactory buildJavaObjectDescriptorFactory_11_2()
	{
		if ( javaobjectdescriptorfactory_11_2 != null ) 
		{
			return javaobjectdescriptorfactory_11_2;
		}
		javaobjectdescriptorfactory_11_2 = (JavaObjectDescriptorFactory)newInstance( JavaObjectDescriptorFactory.class );
		return javaobjectdescriptorfactory_11_2;
	}

	protected JavaObjectDescriptorFactory javaobjectdescriptorfactory_12_2;

	protected ListFactory buildJavaObjectDescriptorFactory_12_2()
	{
		if ( javaobjectdescriptorfactory_12_2 != null ) 
		{
			return javaobjectdescriptorfactory_12_2;
		}
		javaobjectdescriptorfactory_12_2 = (JavaObjectDescriptorFactory)newInstance( JavaObjectDescriptorFactory.class );
		return javaobjectdescriptorfactory_12_2;
	}

	protected JavaObjectDescriptorFactory javaobjectdescriptorfactory_13_2;

	protected PersonFactory buildJavaObjectDescriptorFactory_13_2()
	{
		if ( javaobjectdescriptorfactory_13_2 != null ) 
		{
			return javaobjectdescriptorfactory_13_2;
		}
		javaobjectdescriptorfactory_13_2 = (JavaObjectDescriptorFactory)newInstance( JavaObjectDescriptorFactory.class );
		return javaobjectdescriptorfactory_13_2;
	}

	protected JavaObjectDescriptorFactory javaobjectdescriptorfactory_14_2;

	protected PersonFactory buildJavaObjectDescriptorFactory_14_2()
	{
		if ( javaobjectdescriptorfactory_14_2 != null ) 
		{
			return javaobjectdescriptorfactory_14_2;
		}
		javaobjectdescriptorfactory_14_2 = (JavaObjectDescriptorFactory)newInstance( JavaObjectDescriptorFactory.class );
		return javaobjectdescriptorfactory_14_2;
	}

	protected JavaObjectDescriptorFactory javaobjectdescriptorfactory_15_2;

	protected StringFactory buildJavaObjectDescriptorFactory_15_2()
	{
		if ( javaobjectdescriptorfactory_15_2 != null ) 
		{
			return javaobjectdescriptorfactory_15_2;
		}
		javaobjectdescriptorfactory_15_2 = (JavaObjectDescriptorFactory)newInstance( JavaObjectDescriptorFactory.class );
		return javaobjectdescriptorfactory_15_2;
	}

	protected JavaObjectDescriptorFactory javaobjectdescriptorfactory_16_2;

	protected MapFactory buildJavaObjectDescriptorFactory_16_2()
	{
		if ( javaobjectdescriptorfactory_16_2 != null ) 
		{
			return javaobjectdescriptorfactory_16_2;
		}
		javaobjectdescriptorfactory_16_2 = (JavaObjectDescriptorFactory)newInstance( JavaObjectDescriptorFactory.class );
		return javaobjectdescriptorfactory_16_2;
	}

}
