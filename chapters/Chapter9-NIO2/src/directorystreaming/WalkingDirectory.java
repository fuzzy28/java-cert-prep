package directorystreaming;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;

public class WalkingDirectory {

	static Path parentDirectory = Paths.get("dir1");
	static Path file1InsideParent = parentDirectory.resolve(Paths.get("file1InsideDir1.java"));
	static Path file2InsideParent = parentDirectory.resolve(Paths.get("file2InsideDir1.java"));
	static Path subDirectory = parentDirectory.resolve(Paths.get("dir2"));
	static Path file1InsideSub = subDirectory.resolve(Paths.get("file1InsideSub.txt"));
	static Path file2InsideSub = subDirectory.resolve(Paths.get("file2InsideSub.java"));

	static void createDirectoryAndFiles() throws IOException {
		System.out.println("--------createDirectoryAndFiles--------");

		if (Files.exists(parentDirectory)) {
			System.out.println("Removing files and directories...");
			Files.walk(parentDirectory).sorted(Comparator.reverseOrder()).peek(System.out::println).map(Path::toFile)
					.forEach(File::delete);
		}

		System.out.println("Creating folder structure");
		Files.createDirectories(subDirectory);
		Files.createFile(file1InsideParent);
		Files.createFile(file2InsideParent);
		Files.createFile(file1InsideSub);
		Files.createFile(file2InsideSub);

	}

	static void searchFromDirectory() throws IOException {
		System.out.println("--------searchFromDirectory--------");
		System.out.println("Search all java files starting from parent: " + parentDirectory.getFileName());
		Files.find(parentDirectory, 10, (p, a) -> a.isRegularFile() && p.toString().endsWith(".java"))
				.forEach(System.out::println);
	}
	
	static void listDirectoryContents() throws IOException {
		System.out.println("--------listDirectoryContents--------");
		System.out.println("Search all contents of parent directory: " + parentDirectory.getFileName());
//		Files.list(file1InsideParent).forEach(System.out::println); // throws NotDirectoryException for files
		
		//traverse only one level deep!
		Files.list(parentDirectory).forEach(System.out::println);
	}

	public static void main(String[] args) throws IOException {
		createDirectoryAndFiles();
		searchFromDirectory();
		listDirectoryContents();
	}
}
