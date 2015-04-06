package main.java.IOStreams;

import java.io.*;

/*
 * References: http://www.lynda.com/Java-tutorials/Reading-writing-byte-streams/107061/113502-4.html
 * */
public class UsingBufferedStreams {
	public static void main(String[] args) {
		try {
			readTXTFileThenCopyTXTFile();
		} catch (IOException e) {
			System.out.println("Caught IOException: " + e.getMessage());
		}
	}

	//  读一个input txt file,难后新建一个 ouput txt file, 最近将input txt file的内容全部copy进output txt file.
	public static void readTXTFileThenCopyTXTFile() throws IOException {
		FileReader in = null;
		FileWriter out = null;
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			in = new FileReader("C:\\Users\\Yi\\Desktop\\inputSource.txt");
			br = new BufferedReader(in);
			// When you're working with FileWriter you don't have to create the file first,
			// you can simply start writing to it.
			out = new FileWriter("C:\\Users\\Yi\\Desktop\\outputSource.txt");
			bw = new BufferedWriter(out);
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
			if (br != null) {
				br.close();
			}
			if (out != null) {
				out.close();
			}
			if (bw != null) {
				bw.close();
			}
		}
	}
}
