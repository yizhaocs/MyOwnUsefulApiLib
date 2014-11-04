package ByteArrayConversion;
import java.io.UnsupportedEncodingException;

public class ConvertByteArrayToString {
	/* Reference: http://stackoverflow.com/questions/8512121/byte-to-string-java */
	public static String byteArrayToString(byte[] byteArray) {
		StringBuilder sb = new StringBuilder();
		try {
			sb.append(new String(byteArray, "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
}
