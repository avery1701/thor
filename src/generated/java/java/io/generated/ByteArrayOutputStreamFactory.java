package java.io.generated;

import  static org.easymock.EasyMock.*;
import com.advancedpwr.record.factory.BaseFactory;
import java.io.OutputStream;
import java.io.IOException;

public class ByteArrayOutputStreamFactory extends BaseFactory
{

	protected OutputStream outputstream;

	public OutputStream buildOutputStream() throws IOException
	{
		if ( outputstream != null ) 
		{
			return outputstream;
		}
		outputstream = createStrictMock( OutputStream.class );
		outputstream.write( buildbyteArray_2_1() );
		outputstream.flush();
		outputstream.close();
		replay( outputstream );
		return outputstream;
	}

	protected byte[] byteArray_2_1;

	protected byte[] buildbyteArray_2_1()
	{
		if ( byteArray_2_1 != null ) 
		{
			return byteArray_2_1;
		}
		byteArray_2_1 = new byte[11];
		byteArray_2_1[0] = new Byte( (byte)72);
		byteArray_2_1[1] = new Byte( (byte)101);
		byteArray_2_1[2] = new Byte( (byte)108);
		byteArray_2_1[3] = new Byte( (byte)108);
		byteArray_2_1[4] = new Byte( (byte)111);
		byteArray_2_1[5] = new Byte( (byte)32);
		byteArray_2_1[6] = new Byte( (byte)119);
		byteArray_2_1[7] = new Byte( (byte)111);
		byteArray_2_1[8] = new Byte( (byte)114);
		byteArray_2_1[9] = new Byte( (byte)108);
		byteArray_2_1[10] = new Byte( (byte)100);
		return byteArray_2_1;
	}
}
