package com.example.array;

import com.advancedpwr.record.factory.BaseFactory;

public class ByteArrayFactory extends BaseFactory
{

	protected byte[] byteArray;

	public byte[] buildbyteArray()
	{
		if ( byteArray != null ) 
		{
			return byteArray;
		}
		byteArray = new byte[12];
		byteArray[0] = new Byte( (byte)72);
		byteArray[1] = new Byte( (byte)101);
		byteArray[2] = new Byte( (byte)108);
		byteArray[3] = new Byte( (byte)108);
		byteArray[4] = new Byte( (byte)111);
		byteArray[5] = new Byte( (byte)32);
		byteArray[6] = new Byte( (byte)87);
		byteArray[7] = new Byte( (byte)111);
		byteArray[8] = new Byte( (byte)114);
		byteArray[9] = new Byte( (byte)108);
		byteArray[10] = new Byte( (byte)100);
		byteArray[11] = new Byte( (byte)33);
		return byteArray;
	}

}
