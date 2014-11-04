import java.io.IOException;
import java.util.Arrays;

import ConversionOfByteArray.ConvertByteArrayToFile;
import ConversionOfByteArray.ConvertByteArrayToHexString;
import ConversionOfByteArray.ConvertByteArrayToString;
import ConversionOfByteArray.ConvertFileToByteArray;

public class Main {
	public static void main(String[] args) throws IOException {
		String time = GetCurServerTime.getCurServerTime(); // 1414785544
		byte[] stringToByteArray = ConvertFileToByteArray.stringToByteArray("abc"); // [97, 98, 99]
//		String byteArrayToString = ConvertByteArrayToString.byteArrayToString(stringToByteArray); // abc
		System.out.println(ConvertByteArrayToHexString.byteArrayToHexString(stringToByteArray)); // 616263
//		byte[] imageToByteArray = ConvertFileToByteArray.imageToByteArray(); // [-119, 80, 78, 71, 13, 10, 26, blablablabla
		
//		ConvertByteArrayToFile.byteArrayToFile(imageToByteArray);
//		String uuidGenerator = UuidGenerator.generateUuid(); // 36962753-7a15-4996-b100-fd132166cac5
//
//		System.out.println(time);
//		System.out.println(Arrays.toString(stringToByteArray));
//		System.out.println(byteArrayToString);
//		System.out.println(Arrays.toString(imageToByteArray));
//		System.out.println(uuidGenerator);
	}
}
