package main.java;

public class Main {
	public static void main(String[] args) {
		WriterAndReaderSequenceFile mWriterAndReader = new WriterAndReaderSequenceFile();
		mWriterAndReader.writeToSequenceFile("a");
		mWriterAndReader.readSequenceFile();
	}
}
