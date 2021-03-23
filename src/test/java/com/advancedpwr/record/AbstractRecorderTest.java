/*
 * Copyright 2011 Matthew Avery, mavery@advancedpwr.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.advancedpwr.record;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.channels.FileChannel;

public abstract class AbstractRecorderTest {
	public static final String WRITE_FILES = "write.files";

	protected BeanRecorder recorder;

	protected MultiWriter result;

	public AbstractRecorderTest() {
		setWriteFiles();
		recorder = new BeanRecorder();
		configureRecorder(recorder);
	}

	protected AbstractRecorder getRecorder() { return recorder; }

	public void configureRecorder(final AbstractRecorder inRecorder) {
		result = new MultiWriter();
		if (writeFiles()) {
			inRecorder.setDestination("src/generated/java");
			result = new MultiWriter() {

				public FileWriter getFileWriter() { return inRecorder.getJavaFileWriter(); }

			};
		}

		inRecorder.setWriter(result);

	}

	protected boolean writeFiles() {
		return "true".equalsIgnoreCase(System.getProperty(WRITE_FILES));
	}

	public static void setWriteFiles() {
		System.setProperty(WRITE_FILES, "true");
	}

	public void assertResult(String inString) {
		assertEquals(inString.replaceAll("\r\n", "\n"), result.toString().replaceAll("\r\n", "\n"));
	}

	public void assertResult() {
		if (isUpdate()) {
			updateReference();
		}
		assertResult(reference());
		System.out.println(referenceFile().getAbsolutePath() + " matches " + getRecorder().javaFile());
	}

	protected boolean isUpdate() { return System.getProperty("recorder.test.update") != null; }

	protected void updateReference() {
		File source = getRecorder().javaFile();
		File target = referenceFile();
		copyFile(source, target);

	}

	protected void copyFile(File source, File target) {
		try {
			copyFile_raw(source, target);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected void copyFile_raw(File source, File target) throws IOException {

		try (FileInputStream in = new FileInputStream(source);
				FileChannel inChannel = in.getChannel();
				FileOutputStream out = new FileOutputStream(target);
				FileChannel outChannel = out.getChannel()) {
			long bytesTransferred = 0;
			// defensive loop - there's usually only a single iteration :
			while (bytesTransferred < inChannel.size()) {
				bytesTransferred += inChannel.transferTo(0, inChannel.size(), outChannel);
			}
		}

	}

	public String reference() {
		try {
			File file = referenceFile();
			FileReader fileReader = new FileReader(file);
			BufferedReader reader = new BufferedReader(fileReader);
			StringBuffer sb = new StringBuffer();
			while (reader.ready()) {
				sb.append(reader.readLine());
				sb.append("\n");
			}
			reader.close();
			return sb.toString();
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	protected File referenceFile() {
		String fileName = getRecorder().getClassName() + ".java";
		File dir = new File("reference", getRecorder().packagePath());
		File file = new File(dir, fileName);
		return file;
	}
}
