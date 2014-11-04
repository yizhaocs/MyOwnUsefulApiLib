package ConversionOfByteArray;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.IOUtils;

public class ConvertFileToByteArray {
	public static byte[] stringToByteArray(String s) {
		return s.getBytes();
	}

	/* Reference: http://stackoverflow.com/questions/1264709/convert-inputstream-to-byte-array-in-java */
	public static byte[] imageToByteArray() throws IOException {
		byte[] res = null;
		FileInputStream in = null;
		try {
			in = new FileInputStream("image.png");
			res = IOUtils.toByteArray(in);
		} catch (FileNotFoundException e) {
			System.out.println("Caught FileNotFoundException: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Caught IOException: " + e.getMessage());
		} finally {
			if (in != null) {
				in.close();
			}
		}
		return res;
	}
}
