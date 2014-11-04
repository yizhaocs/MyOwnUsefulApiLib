package ByteArrayConversion;

import java.io.ByteArrayInputStream;

public class ConvertByteArrayToInputStream {
	public static ByteArrayInputStream execute(byte[] byteArray) {
		return new ByteArrayInputStream(byteArray);
	}
}
