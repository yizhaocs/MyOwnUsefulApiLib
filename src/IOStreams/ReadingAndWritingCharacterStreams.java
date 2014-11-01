package IOStreams;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class ReadingAndWritingCharacterStreams {
	public static void main(String[] args) {
		try {
			readTXTFileThenCopyTXTFile();
		} catch (IOException e) {
			System.out.println("Caught IOException: " + e.getMessage());
		}
	}
	
	// 读一个input txt file,难后新建一个ouput txt file, 最近将input txt file的内容全部copy进output txt file.
	public static void readTXTFileThenCopyTXTFile() throws IOException {
		FileReader in = null;
		FileWriter out = null;
		try {
			in = new FileReader("C:\\Users\\Yi\\Desktop\\inputSource.txt");
			// When you're working with FileWriter you don't have to create the file first,
			// you can simply start writing to it.
			out = new FileWriter("C:\\Users\\Yi\\Desktop\\outputSource.txt");
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
