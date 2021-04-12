package com.example.array;

import com.advancedpwr.record.factory.generatedBaseFactoryFactory;
import com.advancedpwr.samples.generatedFamilyFactory;
import com.advancedpwr.samples.generatedFamilyFactory;
import com.advancedpwr.samples.generatedFamilyFactory;
import com.advancedpwr.samples.generatedFamilyFactory;
import com.advancedpwr.samples.generatedFamilyFactory;
import com.advancedpwr.samples.generatedPersonFactory;
import com.advancedpwr.record.descriptor.generatedJavaObjectDescriptorFactory;
import java.util.generatedLocaleFactory;
import com.advancedpwr.record.descriptor.generatedJavaObjectDescriptorFactory;
import com.advancedpwr.samples.generatedPersonFactory;
import com.advancedpwr.record.descriptor.generatedJavaObjectDescriptorFactory;
import com.advancedpwr.record.descriptor.generatedJavaObjectDescriptorFactory;
import com.advancedpwr.record.descriptor.generatedJavaObjectDescriptorFactory;
import com.advancedpwr.record.descriptor.generatedJavaObjectDescriptorFactory;
import com.advancedpwr.samples.generatedFamilyFactory;
import com.advancedpwr.samples.generatedPersonFactory;
import com.advancedpwr.record.descriptor.generatedJavaObjectDescriptorFactory;
import java.util.generatedLocaleFactory;
import com.advancedpwr.record.descriptor.generatedJavaObjectDescriptorFactory;
import com.advancedpwr.samples.generatedPersonFactory;
import com.advancedpwr.record.descriptor.generatedJavaObjectDescriptorFactory;
import com.advancedpwr.record.descriptor.generatedJavaObjectDescriptorFactory;
import com.advancedpwr.record.descriptor.generatedJavaObjectDescriptorFactory;
import com.advancedpwr.record.descriptor.generatedJavaObjectDescriptorFactory;

public class PersonArrayFactoryImports extends BaseFactoryFactory
{

	protected FamilyArrayFactory familyarrayfactory;

	public FamilyArrayFactory buildFamilyArrayFactory()
	{
		if ( familyarrayfactory != null ) 
		{
			return familyarrayfactory;
		}
		familyarrayfactory = (FamilyArrayFactory)newInstance( FamilyArrayFactory.class );
		familyarrayfactory.( buildFamilyFactory_1_1() );
		familyarrayfactory.( buildFamilyFactory_5_1() );
		return familyarrayfactory;
	}

	protected FamilyFactory familyfactory_1_1;

	protected FamilyFactory buildFamilyFactory_1_1()
	{
		if ( familyfactory_1_1 != null ) 
		{
			return familyfactory_1_1;
		}
		familyfactory_1_1 = new FamilyFactory();
		familyfactory_1_1.setDad( buildJavaObjectDescriptorFactory_2_2() );
		familyfactory_1_1.setLocale( buildJavaObjectDescriptorFactory_3_2() );
		familyfactory_1_1.setMom( buildJavaObjectDescriptorFactory_4_2() );
		return familyfactory_1_1;
	}

	protected JavaObjectDescriptorFactory javaobjectdescriptorfactory_2_2;

	protected PersonFactory buildJavaObjectDescriptorFactory_2_2()
	{
		if ( javaobjectdescriptorfactory_2_2 != null ) 
		{
			return javaobjectdescriptorfactory_2_2;
		}
		javaobjectdescriptorfactory_2_2 = (JavaObjectDescriptorFactory)newInstance( JavaObjectDescriptorFactory.class );
		return javaobjectdescriptorfactory_2_2;
	}

	protected JavaObjectDescriptorFactory javaobjectdescriptorfactory_3_2;

	protected LocaleFactory buildJavaObjectDescriptorFactory_3_2()
	{
		if ( javaobjectdescriptorfactory_3_2 != null ) 
		{
			return javaobjectdescriptorfactory_3_2;
		}
		javaobjectdescriptorfactory_3_2 = (JavaObjectDescriptorFactory)newInstance( JavaObjectDescriptorFactory.class );
		return javaobjectdescriptorfactory_3_2;
	}

	protected JavaObjectDescriptorFactory javaobjectdescriptorfactory_4_2;

	protected PersonFactory buildJavaObjectDescriptorFactory_4_2()
	{
		if ( javaobjectdescriptorfactory_4_2 != null ) 
		{
			return javaobjectdescriptorfactory_4_2;
		}
		javaobjectdescriptorfactory_4_2 = (JavaObjectDescriptorFactory)newInstance( JavaObjectDescriptorFactory.class );
		return javaobjectdescriptorfactory_4_2;
	}

	protected FamilyFactory familyfactory_5_1;

	protected FamilyFactory buildFamilyFactory_5_1()
	{
		if ( familyfactory_5_1 != null ) 
		{
			return familyfactory_5_1;
		}
		familyfactory_5_1 = new FamilyFactory();
		familyfactory_5_1.setDad( buildJavaObjectDescriptorFactory_6_2() );
		familyfactory_5_1.setLocale( buildJavaObjectDescriptorFactory_7_2() );
		familyfactory_5_1.setMom( buildJavaObjectDescriptorFactory_8_2() );
		return familyfactory_5_1;
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

	protected LocaleFactory buildJavaObjectDescriptorFactory_7_2()
	{
		if ( javaobjectdescriptorfactory_7_2 != null ) 
		{
			return javaobjectdescriptorfactory_7_2;
		}
		javaobjectdescriptorfactory_7_2 = (JavaObjectDescriptorFactory)newInstance( JavaObjectDescriptorFactory.class );
		return javaobjectdescriptorfactory_7_2;
	}

	protected JavaObjectDescriptorFactory javaobjectdescriptorfactory_8_2;

	protected PersonFactory buildJavaObjectDescriptorFactory_8_2()
	{
		if ( javaobjectdescriptorfactory_8_2 != null ) 
		{
			return javaobjectdescriptorfactory_8_2;
		}
		javaobjectdescriptorfactory_8_2 = (JavaObjectDescriptorFactory)newInstance( JavaObjectDescriptorFactory.class );
		return javaobjectdescriptorfactory_8_2;
	}

}
