package main.java.ConversionOfByteArray;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class ConvertByteArrayToFile {
	public static void byteArrayToFile(byte[] byteArray) throws IOException {
		FileOutputStream out = null;
		try {
			out = new FileOutputStream("/Users/yizhao/Desktop/xyz.png");
			out.write(byteArray);
		} catch (FileNotFoundException e) {
			System.out.println("Caught FileNotFoundException: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Caught IOException: " + e.getMessage());
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}
}
