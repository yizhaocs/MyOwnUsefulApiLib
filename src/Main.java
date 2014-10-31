import java.io.IOException;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		String time = GetCurServerTime.getCurServerTime(); // 1414785544
		byte[] stringToByteArray = ConvertToByteArray.stringToByteArray("abc"); // [97, 98, 99]
		String byteArrayToString = ConvertToString.byteArrayToString(stringToByteArray); // abc
		byte[] imageToByteArray = ConvertToByteArray.imageToByteArray(); // [-119, 80, 78, 71, 13, 10, 26, blablablabla
		
		System.out.println(time);
		System.out.println(Arrays.toString(stringToByteArray));
		System.out.println(byteArrayToString);
		System.out.println(Arrays.toString(imageToByteArray));
	}
}
