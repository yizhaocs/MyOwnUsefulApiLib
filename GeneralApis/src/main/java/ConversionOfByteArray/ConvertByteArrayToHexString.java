package main.java.ConversionOfByteArray;

public class ConvertByteArrayToHexString {
	public static String byteArrayToHexString(byte[] byteArray) {
		char[] hexArray = "0123456789ABCDEF".toCharArray();
		char[] hexChars = new char[byteArray.length * 2];
		for (int i = 0; i < byteArray.length; i++) {
			int v = byteArray[i] & 0xFF;
			hexChars[i * 2] = hexArray[v >>> 4];
			hexChars[i * 2 + 1] = hexArray[v & 0x0F];
		}
		return new String(hexChars);
	}
}
