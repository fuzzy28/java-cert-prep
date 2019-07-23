package streams;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MarkingStream {

	File file = new File("file1.txt");

	void markStream() throws IOException {
		System.out.println("------- markStream() -------");
		if (file.exists()) {
			System.out.println("Deleting existing file1.txt: " + file.delete());
		}
		try (FileOutputStream fos = new FileOutputStream(file)) {
			fos.write("This is a test".getBytes());
			fos.flush();
		}

		try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file))) {
			System.out.println("Mark supported: " + bis.markSupported());
			if (bis.markSupported()) {
				System.out.println((char) bis.read());
				System.out.println((char) bis.read());
				System.out.println((char) bis.read());
				System.out.println((char) bis.read());
				bis.mark(1);
				System.out.println((char) bis.read());
				System.out.println((char) bis.read());
				System.out.println((char) bis.read());
				bis.reset();
				System.out.println((char) bis.read());
				System.out.println((char) bis.read());
				System.out.println((char) bis.read());
			}
		}

	}

	public static void main(String[] args) throws IOException {
		MarkingStream ms = new MarkingStream();
		ms.markStream();

	}
}
