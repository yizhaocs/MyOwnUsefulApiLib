import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		String time = GetCurServerTime.getCurServerTime(); // 1414785544
		byte[] stringToByteArray = ConvertToByteArray.stringToByteArray("abc"); // [97, 98, 99]
		String byteArrayToString = ConvertToString.byteArrayToString(stringToByteArray); // abc
		System.out.println(time);
		System.out.println(Arrays.toString(stringToByteArray));
		System.out.println(byteArrayToString);
	}
}
