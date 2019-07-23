package streams;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileStreamsBasic {

	static void create() throws IOException {
//		BufferedReader reader = new BufferedReader(new FileInputStream("")); // does not compile can't mix reader and stream
//		BufferedInputStream bis = new BufferedInputStream(new InputStream()) // input stream is an abstract class
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(""));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(""));
		
	}
	
}
