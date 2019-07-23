package reader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriterUsage {

	static File file = new File("printwriter.log");

	static void printWriter() throws IOException {
		if (file.exists()) {
			System.out.println("Deleting existing file: " + file.delete());
		}
		try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)))) {
			pw.println("Creating log file...");
			pw.printf("Using %s method%n", "printf()");
			pw.format("Using %s method", "format()");
		}
	}

	public static void main(String[] args) throws IOException {
		printWriter();
	}
}
