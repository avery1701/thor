package com.advancedpwr.record.mock;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

import org.junit.jupiter.api.Test;

public class OutputStreamTest extends AbstractMockRecorderTest {
	@Test
	public void testOutputStream() throws Exception {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		recorder.addPreferredInterface(OutputStream.class);
		out = recorder.record(out);

		out.write("Hello world".getBytes());
		out.flush();
		out.close();
		recorder.endRecording();
		assertResult();
	}
}
