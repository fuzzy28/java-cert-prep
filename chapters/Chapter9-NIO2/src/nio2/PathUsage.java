package nio2;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.IntStream;

public class PathUsage {

	static void create() throws URISyntaxException {
		System.out.println("---------create---------");
		Path path = FileSystems.getDefault().getPath("myfile.txt");
//		Paths path2 = Paths.get(""); // does not compile.
//		Path path2  = Path.get(""); // does not compile.
		path = Paths.get("myfile.txt");
//		path = Paths.get(new URI("file:////myfile.txt")); // URI throws runtime if path is invalid
		System.out.println(path.toString());
	}

	static void conversion() {
		System.out.println("---------conversion---------");
		Path path = Paths.get("myfile.txt");
		File file = path.toFile();
		System.out.println(file.getName());
	}

	static void normalize() {
		System.out.println("---------normalize---------");
		Path path = Paths.get("dir1/dir2/.././fileInDir1.txt");
		System.out.println(path.normalize());
	}

	static void printProperties() {
		System.out.println("---------printProperties---------");
		Path path = Paths.get("dir1/dir2/.././fileInDir1.txt");
		System.out.println("Path toString(): " + path.toString());
		System.out.println("getNameCount(): " + path.getNameCount());
		System.out.println("Printing names:");
		IntStream.range(0, path.getNameCount()).mapToObj(path::getName).forEach(System.out::println);
		System.out.println("getParent: " + path.getParent());
		System.out.println("getFileName: " + path.getFileName());
		System.out.println("getRoot: " + path.getRoot());
		System.out.println("isAbsolute: " + path.isAbsolute());
		System.out.println("toAbsolutePath: " + path.toAbsolutePath());
		System.out.println("subpath: " + path.subpath(0, 2));
	}

	static void relativize() {
		System.out.println("---------relativize---------");
		Path path1 = Paths.get("c:/dir1/dir2/dir3/file1.txt");
		Path path2 = Paths.get("d:/../file1.txt");
		Path path3 = Paths.get("c:/dir1/dir2/file2.txt");
		try {
			System.out.println(path1.relativize(path2)); // throws runtime exception, different root!
		} catch (IllegalArgumentException iae) {
			System.err.println(iae.getMessage());
		}
		System.out.println(path1.relativize(path3));
	}

	static void resolve() {
		System.out.println("---------resolve---------");
		Path path1 = Paths.get("c:/dir1/dir2/text1.txt");
		Path path2 = Paths.get("text2.txt");
		System.out.println(path1.resolve(path2));
		System.out.println(path2.resolve(path1)); // if second path is absolute then return it.
		System.out.println(path2.resolve(Paths.get("")));
	}

	static void toRealPath() throws IOException {
		System.out.println("---------toRealPath---------");
		Path path = Paths.get("myFile.txt");

		if (path.toFile().exists()) {
			System.out.println("Deleting existing file: " + path.toFile().delete());
		}
		try {
			path.toRealPath();
		} catch (IOException ioe) {
			System.err.println("File does not exists: " + ioe.getMessage());
			System.out.println("Creating this file...");

			path.toFile().createNewFile();

		}
		System.out.println("File created from path: " + path.toRealPath());
	}

	public static void main(String[] args) throws URISyntaxException, IOException {
		create();
		conversion();
		normalize();
		printProperties();
		relativize();
		resolve();
		toRealPath();
	}

}
