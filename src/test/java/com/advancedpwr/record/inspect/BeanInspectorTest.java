package com.advancedpwr.record.inspect;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

import org.junit.jupiter.api.Test;

public class BeanInspectorTest {

	@Test
	public void testBeanInfo() throws IntrospectionException {
		BeanInfo info = Introspector.getBeanInfo(Ship.class);
		PropertyDescriptor[] descs = info.getPropertyDescriptors();
		for (PropertyDescriptor propertyDescriptor : descs) {
			System.out.println(propertyDescriptor.getReadMethod().getName());
		}
	}

}
