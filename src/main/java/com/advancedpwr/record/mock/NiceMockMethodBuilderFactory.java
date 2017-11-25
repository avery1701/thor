package com.advancedpwr.record.mock;

public class NiceMockMethodBuilderFactory extends MockMethodBuilderFactory
{
	protected MockMethodBuilder newMethodWriter()
	{
		return new NiceMockMethodBuilder();
	}
}
