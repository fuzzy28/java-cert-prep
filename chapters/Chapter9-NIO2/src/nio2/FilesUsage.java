package nio2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.UserPrincipal;
import java.time.Instant;

public class FilesUsage {

	static Path directory = Paths.get("dir/dir2");
	static Path file = directory.getName(0).resolve(Paths.get("fileUsage.txt"));
	static Path file_copy = directory.resolve(Paths.get("fileUsage_copy.txt"));
	static Path p = Paths.get("bufferedWriter.txt");

	static void cleanup() throws IOException {
		System.out.println("---------cleanup---------");

		System.out.println("Deleting all files under the directory: " + directory.toAbsolutePath());
		if (Files.exists(directory.getName(0))) {
			Files.walk(directory.getName(0)).peek(p -> System.out.println("Deleting file : " + p.getFileName()))
					.map(Path::toFile).forEach(File::delete);
			System.out.println("Directory exists, deleting existing directory..." + Files.deleteIfExists(directory));
		}
	}

	static void create() throws IOException {
		System.out.println("---------create---------");
		System.out.println("Creating directories");
//		Files.createDirectory(directory); //runtime exception, directory creating is more than 1
		Files.createDirectories(directory);

		System.out.println("Creating file : " + file.getFileName());
		Files.createFile(file);
	}

	static void writeToFile() {
		System.out.println("---------writeToFile---------");
		try {
			Files.write(file, "This is a test".getBytes());
			System.out.println("Successfully written to file");
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}

	static void duplicateFile() {
		System.out.println("---------duplicateFile---------");
		try {
			Files.copy(file, file_copy, StandardCopyOption.REPLACE_EXISTING);
			System.out.println("File has been copied with name: " + file_copy.getFileName());
		} catch (IOException ioe) {
			System.err.println(ioe.getMessage());
		}
	}

	static void moveDuplicatedFile() {
		System.out.println("---------moveDuplicatedFile---------");
		try {
			Files.move(file_copy, directory.getName(0).resolve(file_copy.getFileName()),
					StandardCopyOption.ATOMIC_MOVE);
			System.out.println("Copy file has been moved.");
		} catch (IOException e) {
			System.err.println("Can't move file!: " + e.getMessage());
		}
	}

	static void printContentUsingWriter() {
		System.out.println("---------printContentUsingWriter---------");
		try (BufferedReader br = Files.newBufferedReader(file)) {
			String read;
			while ((read = br.readLine()) != null) {
				System.out.println(read);
			}
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}

	}

	static void writeUsingBufferedWriter() {
		System.out.println("---------writeUsingBufferedWriter---------");
		p.toFile().delete();
		try (BufferedWriter br = Files.newBufferedWriter(p)) {
			br.append("Hello world!...\n");
			br.append("Hello again...\n");
			br.append("Hello hello...\n");
			System.out.println("Successfully written text using bufferedwritter");
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}

	static void readAllLines() throws IOException {
		System.out.println("---------readAllLines---------");
		Files.readAllLines(p).forEach(System.out::println);
	}

	static void streamLines() throws IOException {
		System.out.println("---------readAllLines---------");
		Files.lines(p).forEach(System.out::println);
	}

	static void isSameFile() {
		System.out.println("---------isSameFile---------");
		try {
			System.out.println(Files.isSameFile(file,
					directory.getName(0).resolve(FileSystems.getDefault().getPath("fileUsage.txt"))));
		} catch (IOException ioe) {
			System.err.println(ioe.getMessage());
		}
	}

	static void printProperties() {
		System.out.println("---------printProperties---------");
		System.out.println("isDirectory: " + Files.isDirectory(directory));
		System.out.println("isRegularFIle: " + Files.isRegularFile(file));
		System.out.println("isSymbolicLink: " + Files.isSymbolicLink(file_copy));
		try {
			System.out.println("isHidden: " + Files.isHidden(file));
		} catch (IOException e) {
			System.err.println("Error while checking if file is hidden.");
		}
		System.out.println("isReadable:" + Files.isReadable(file));
		System.out.println("isExecutable: " + Files.isExecutable(file));
		try {
			System.out.println("size: " + Files.size(file));
		} catch (Exception e) {
			System.err.println("Error while checking the file size.");
		}
		try {
			System.out.println("getLastModifiedTime: " + Files.getLastModifiedTime(file));
			System.out.println("Changing modified time to now");
			Files.setLastModifiedTime(file, FileTime.from(Instant.now()));
			System.out.println("getLastModifiedTime: " + Files.getLastModifiedTime(file));

			System.out.println("getOwner: " + Files.getOwner(file).getName());
			System.out.println("Try to change owner");

			UserPrincipal up = FileSystems.getDefault().getUserPrincipalLookupService().lookupPrincipalByName("joel");
			Files.setOwner(file, up);
		} catch (IOException e) {
			System.err.println(e.getClass());
		}

	}

	public static void main(String[] args) throws IOException {
		cleanup();
		create();
		writeToFile();
		duplicateFile();
		moveDuplicatedFile();
		printContentUsingWriter();
		writeUsingBufferedWriter();
		readAllLines();
		streamLines();
		isSameFile();
		printProperties();
	}
}
