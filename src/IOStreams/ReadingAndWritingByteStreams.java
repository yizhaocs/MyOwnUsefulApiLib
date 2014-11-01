package IOStreams;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ReadingAndWritingByteStreams {
	public static void main(String[] args) {
		try {
			readIMAGEFileThenCopyIMAGEFile();
		} catch (IOException e) {
			System.out.println("Caught IOException: " + e.getMessage());
		}
	}

	// 读一个input image file,难后新建一个 ouput image file, 最近将input image file的内容全部copy进output image file.
	public static void readIMAGEFileThenCopyIMAGEFile() throws IOException {
		FileInputStream in = null;
		FileOutputStream out = null;
		try {
			in = new FileInputStream("C:\\Users\\Yi\\Desktop\\inputSource.jpg");
			// When you're working with FileOutputStream you don't have to create the file first,
			// you can simply start writing to it.
			out = new FileOutputStream("C:\\Users\\Yi\\Desktop\\outputSource.jpg");
			int i;
			while ((i = in.read()) != -1) {
				out.write(i);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Caught FileNotFoundException: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Caught IOException: " + e.getMessage());
		} finally {
			if (in != null) {
				in.close();
			}
			if (out != null) {
				out.close();
			}
		}
	}
}
