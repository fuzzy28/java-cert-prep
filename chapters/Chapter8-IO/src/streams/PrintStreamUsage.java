package streams;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class PrintStreamUsage {

	static File file = new File("printstream.log");
	
	static void printStream() throws IOException {
		
		if(file.exists()) {
			System.out.println("Deleting existing file: " + file.delete());
		}
		
		try (PrintStream ps = new PrintStream(new BufferedOutputStream(new FileOutputStream(file)))) {
			ps.println("Creating log file...");
			ps.format("This is %s %s %n", "parameterized", "text");
			ps.printf("This %s method calls %s method internally", "printf()", "format()");
		}
	}
	
	public static void main(String[] args) throws IOException {
		printStream();
	}

}
