import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

import org.apache.commons.io.IOUtils;



public class ConvertToByteArray {
	public static byte[] stringToByteArray(String s) {
		return s.getBytes();
	}

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
