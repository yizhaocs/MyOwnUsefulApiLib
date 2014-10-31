import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		String time = GetCurServerTime.getCurServerTime(); // 1414785544
		byte[] stringToByteArray = ConvertToByteArray.stringToByteArray("abc"); // [97, 98, 99]
		System.out.println(time);
		System.out.println(Arrays.toString(stringToByteArray));
	}
}
