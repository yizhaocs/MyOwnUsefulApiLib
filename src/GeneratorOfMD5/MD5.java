package GeneratorOfMD5;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
	public static void main(String[] args) {
		System.out.println(execute("20a0db86-b3b4-47e4-98dd-8a3c44fd55500B:9B:F6:9F:CB:43:7C:51:C2:EC:A6:19:DB:50:1D:A9:E1:B4:29:39com.fuhu.nabi.wings.workbook")); // 202cb962ac59075b964b07152d234b70
		System.out.println(execute("d7b7ce02-529b-4295-910e-f159559f736d0B:9B:F6:9F:CB:43:7C:51:C2:EC:A6:19:DB:50:1D:A9:E1:B4:29:39com.fuhu.nabi.wings.workbook")); // caf1a3dfb505ffed0d024130f58c5cfa
	}

	/*
	 * Reference: http://javarevisited.blogspot.com/2013/03/generate-md5-hash-in-java-string-byte-array-example-tutorial.html
	 */
	private static String execute(String s) {
		String digest = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] hash = md.digest(s.getBytes("UTF-8"));
			StringBuilder sb = new StringBuilder(2 * hash.length);
			for (byte b : hash) {
				sb.append(String.format("%02x", b & 0xff));
			}
			digest = sb.toString();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return digest;
	}
}
