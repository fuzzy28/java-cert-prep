package reader;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class WorkingWithReader {

	File file = new File("workingwithreader.txt");
	File file_copy = new File("workingwithreader_copy.txt");

	void create() throws IOException {
		System.out.println("-------create()-------");
		if (file.exists()) {
			System.out.println("Deleting file: " + file.delete());
		}

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
			bw.append("Creating new file using buffered writer");
			bw.newLine();
			bw.append("Appending new text here...");
			bw.newLine();
			bw.append("Closing new file...");
		}
		System.out.println("File has been created...");
	}
	
	void duplicate() throws IOException {
		System.out.println("-------duplicate()-------");
		if(file_copy.exists()) {
			System.out.println("Deleting file: " + file_copy.delete());
		}
		
		try(BufferedReader br = new BufferedReader(new FileReader(file)); 
			BufferedWriter bw = new BufferedWriter(new FileWriter(file_copy))) {
			String read;
			while((read = br.readLine()) != null) {
				System.out.println("Copying text: " + read);
				bw.append(read);
				bw.newLine();
			}
		}
		System.out.println("File has been copied...");
	}

	public static void main(String[] args) throws IOException {
		WorkingWithReader wwr = new WorkingWithReader();
		wwr.create();
		wwr.duplicate();
	}
}
