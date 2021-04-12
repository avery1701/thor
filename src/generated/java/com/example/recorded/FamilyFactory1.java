package com.example.recorded;

import BaseFactoryFactory;
import FamilyFactory;
import PersonFactory;
import JavaObjectDescriptorFactory;
import LocaleFactory;
import JavaObjectDescriptorFactory;
import PersonFactory;
import JavaObjectDescriptorFactory;
import JavaObjectDescriptorFactory;
import JavaObjectDescriptorFactory;
import JavaObjectDescriptorFactory;

public class FamilyFactory1 extends BaseFactoryFactory
{

	protected FamilyFactory familyfactory;

	public FamilyFactory buildFamilyFactory()
	{
		if ( familyfactory != null ) 
		{
			return familyfactory;
		}
		familyfactory = new FamilyFactory();
		familyfactory.setDad( buildJavaObjectDescriptorFactory_1_1() );
		familyfactory.setLocale( buildJavaObjectDescriptorFactory_2_1() );
		familyfactory.setMom( buildJavaObjectDescriptorFactory_3_1() );
		return familyfactory;
	}

	protected JavaObjectDescriptorFactory javaobjectdescriptorfactory_1_1;

	protected PersonFactory buildJavaObjectDescriptorFactory_1_1()
	{
		if ( javaobjectdescriptorfactory_1_1 != null ) 
		{
			return javaobjectdescriptorfactory_1_1;
		}
		javaobjectdescriptorfactory_1_1 = (JavaObjectDescriptorFactory)newInstance( JavaObjectDescriptorFactory.class );
		return javaobjectdescriptorfactory_1_1;
	}

	protected JavaObjectDescriptorFactory javaobjectdescriptorfactory_2_1;

	protected LocaleFactory buildJavaObjectDescriptorFactory_2_1()
	{
		if ( javaobjectdescriptorfactory_2_1 != null ) 
		{
			return javaobjectdescriptorfactory_2_1;
		}
		javaobjectdescriptorfactory_2_1 = (JavaObjectDescriptorFactory)newInstance( JavaObjectDescriptorFactory.class );
		return javaobjectdescriptorfactory_2_1;
	}

	protected JavaObjectDescriptorFactory javaobjectdescriptorfactory_3_1;

	protected PersonFactory buildJavaObjectDescriptorFactory_3_1()
	{
		if ( javaobjectdescriptorfactory_3_1 != null ) 
		{
			return javaobjectdescriptorfactory_3_1;
		}
		javaobjectdescriptorfactory_3_1 = (JavaObjectDescriptorFactory)newInstance( JavaObjectDescriptorFactory.class );
		return javaobjectdescriptorfactory_3_1;
	}

}
