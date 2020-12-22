package java.lang.generated;

import com.advancedpwr.record.factory.BaseFactory;

public class ObjectFactory extends BaseFactory
{

	protected Object object;

	public Object buildObject()
	{
		if ( object != null ) 
		{
			return object;
		}
		object = new Object();
		return object;
	}

}
