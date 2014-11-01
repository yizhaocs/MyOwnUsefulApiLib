package IOStreams;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ScanningTokenizedText {
	public static void main(String[] args) {
		try {
			scanTheCharacterSeparatedBySpace();
		} catch (IOException e) {
			System.out.println("Caught IOException: " + e.getMessage());
		}

		try {
			scanTheCharacterSeparatedByComma();
		} catch (IOException e) {
			System.out.println("Caught IOException: " + e.getMessage());
		}
	}

	public static void scanTheCharacterSeparatedBySpace() throws IOException {
		Scanner s = null;
		FileReader in = null;
		BufferedReader br = null;
		try {
			in = new FileReader("C:\\Users\\Yi\\Desktop\\inputSourceSpace.txt");
			br = new BufferedReader(in);
			s = new Scanner(br);
			s.useDelimiter(" "); // scan The Character Separated By space
			while (s.hasNext()) {
				System.out.println(s.next());
			}
		} catch (FileNotFoundException e) {
			System.out.println("Caught FileNotFoundException: " + e.getMessage());
		} finally {
			if (in != null) {
				in.close();
			}
			if (br != null) {
				br.close();
			}
			if (s != null) {
				s.close();
			}
		}
	}

	public static void scanTheCharacterSeparatedByComma() throws IOException {
		Scanner s = null;
		FileReader in = null;
		BufferedReader br = null;
		try {
			in = new FileReader("C:\\Users\\Yi\\Desktop\\inputSourceComma.txt");
			br = new BufferedReader(in);
			s = new Scanner(br);
			s.useDelimiter(","); // scan The Character Separated By Comma
			while (s.hasNext()) {
				System.out.println(s.next());
			}
		} catch (FileNotFoundException e) {
			System.out.println("Caught FileNotFoundException: " + e.getMessage());
		} finally {
			if (in != null) {
				in.close();
			}
			if (br != null) {
				br.close();
			}
			if (s != null) {
				s.close();
			}
		}
	}
}
