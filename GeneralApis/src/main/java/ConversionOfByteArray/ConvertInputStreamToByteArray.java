package main.java.ConversionOfByteArray;

import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

/*
 * References: http://stackoverflow.com/questions/1264709/convert-inputstream-to-byte-array-in-java
 * */
public class ConvertInputStreamToByteArray {
	public static void main(String[] args) {
		try {
			execute();
		} catch (IOException e) {
			System.out.println("Caught IOException: " + e.getMessage());
		}
	}

	public static void execute() throws IOException {
		FileInputStream in = null;
		try {
			in = new FileInputStream("image.png");
			// When you're working with FileOutputStream you don't have to create the file first,
			// you can simply start writing to it.
			System.out.println("Arrays.toString(IOUtils.toByteArray(imageInFile)):" + Arrays.toString(IOUtils.toByteArray(in)));
		} catch (FileNotFoundException e) {
			System.out.println("Caught FileNotFoundException: " + e.getMessage());
		} finally {
			if (in != null) {
				in.close();
			}
		}
	}
}
