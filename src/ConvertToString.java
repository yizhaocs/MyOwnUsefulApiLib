import java.io.UnsupportedEncodingException;

public class ConvertToString {
	/* Reference: http://stackoverflow.com/questions/8512121/byte-to-string-java */
	public static String byteArrayToString(byte[] ba) {
		try {
			return new String(ba, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}
}
