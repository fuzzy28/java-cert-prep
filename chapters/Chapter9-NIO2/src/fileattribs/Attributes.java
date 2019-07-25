package fileattribs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.DosFileAttributes;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.PosixFileAttributes;
import java.time.Instant;

public class Attributes {

	Path path = Paths.get("fileAttributes.txt");

	public Attributes() {
		if (Files.exists(path)) {
			try {
				System.out.println("Deleting existing file: " + path.getFileName());
				Files.delete(path);
			} catch (Exception e) {
				System.err.println(e.getClass());
			}
		}
		System.out.println("Creating file: " + path.getFileName());
		try {
			Files.createFile(path);
			Files.write(path, "Creating file...".getBytes());
		} catch (IOException e) {
			System.err.println(e.getClass());
		}
	}

	void basicFileAttributes() throws IOException {
		System.out.println("-------basicFileAttributes-------");
		BasicFileAttributes bfa = Files.readAttributes(path, BasicFileAttributes.class);
		System.out.println("isDirectory: " + bfa.isDirectory());
		System.out.println("isRegularFile: " + bfa.isRegularFile());
		System.out.println("isSymbolicLink: " + bfa.isSymbolicLink());
		System.out.println("isOther: " + bfa.isOther());
		System.out.println("Size in bytes: " + bfa.size());
		System.out.println("Creation date/time: " + bfa.creationTime());
		System.out.println("Last modified date/time: " + bfa.lastModifiedTime());
		System.out.println("Last accessed date/time: " + bfa.lastAccessTime());
		System.out.println("Unique file identifier (if available only): " + bfa.fileKey());
	}

	void basicFileAttributeView() throws IOException, InterruptedException {
		System.out.println("-------basicFileAttributeView-------");
		BasicFileAttributeView bfav = Files.getFileAttributeView(path, BasicFileAttributeView.class);
		BasicFileAttributes bfa = bfav.readAttributes();
		System.out.println("Can still get instance of BasicFileAttributes: " + bfa);
		System.out.println("Creation date/time: " + bfa.creationTime());
		System.out.println("Last modified date/time: " + bfa.lastModifiedTime());
		System.out.println("Last accessed date/time: " + bfa.lastAccessTime());
		System.out.println("Changing times...");
		bfav.setTimes(FileTime.from(Instant.now()), FileTime.from(Instant.now()), FileTime.from(Instant.now()));
		System.out.println("Creation date/time: " + bfa.creationTime());
		System.out.println("Last modified date/time: " + bfa.lastModifiedTime());
		System.out.println("Last accessed date/time: " + bfa.lastAccessTime());
	}

	void dosFileAttributes() throws IOException {
		System.out.println("-------dosFileAttributes-------");
		DosFileAttributes dfa = Files.readAttributes(path, DosFileAttributes.class);
		System.out.println("isHidden: " + dfa.isHidden());
		System.out.println("isArchive: " + dfa.isArchive());
		System.out.println("isReadOnly: " + dfa.isReadOnly());
		System.out.println("isSystem: " + dfa.isSystem());
	}

	void dosFileAttributeView() throws IOException {
		System.out.println("-------dosFileAttributeView-------");
		DosFileAttributeView dfav = Files.getFileAttributeView(path, DosFileAttributeView.class);
		System.out.println("Can still get instance of DosFileAttributes: " + dfav.readAttributes());
		System.out.println("Setting hidden to true");
		dfav.setHidden(true);
		System.out.println("isHidden: " + dfav.readAttributes().isHidden());
	}

	void posixFileAttribues() throws IOException {
		System.out.println("-------posixFileAttribues-------");
		try {
			PosixFileAttributes pfa = Files.readAttributes(path, PosixFileAttributes.class);
			System.out.println("Get owner: " + pfa.owner().getName());
			System.out.println("Get group: " + pfa.group().getName());
		} catch (Exception e) {
			System.out.println(e.getClass());
		}

	}

	public static void main(String[] args) throws IOException, InterruptedException {
		Attributes attrs = new Attributes();
		attrs.basicFileAttributes();
		attrs.basicFileAttributeView();
		attrs.dosFileAttributes();
		attrs.dosFileAttributeView();
		attrs.posixFileAttribues();
	}
}
