package streams;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WorkingWithStreams {

	File file = new File("workingwithstreams.txt");
	File file_copy = new File("workingwithstreams_copy.txt");

	void createFile() throws IOException {
		if (file.exists()) {
			System.out.println("Deleting existing file " + file.getName() + " : " + file.delete());
		}

		try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file))) {
			bos.write("Sample text here...\n".getBytes());
			bos.write("Another text here...\n".getBytes());
			bos.write("One more text here...".getBytes());
		}
		System.out.println("File has been created.");
	}

	void duplicateFile() throws IOException {
		if (file_copy.exists()) {
			System.out.println("Deleting existing copy file: " + file_copy.delete());
		}

		try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
				BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file_copy))) {
			byte[] b = new byte[10];
			int lengthRead;
			while ((lengthRead = bis.read(b)) != -1) {
				System.out.println("Copying byte: " + b);
				bos.write(b, 0, lengthRead);
				bos.flush();
			}
		}
		System.out.println("File has been copied");
	}

	public static void main(String[] args) throws IOException {
		WorkingWithStreams wws = new WorkingWithStreams();
		wws.createFile();
		wws.duplicateFile();
	}
}
