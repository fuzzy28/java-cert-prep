package basic.io;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;

public class Files {

	File f = new File("myfile.txt");
	File f2 = new File("newFile.txt");
	File dir = new File("dirs/dir1");

	public Files() throws IOException {
		if (f.exists()) {
			System.out.println("File exists, deleting.");
			if (f.delete()) {
				System.out.println("File has been deleted.");
			} else {
				System.out.println("Failed to delete file.");
			}
		} else {
			System.out.println("No file to be deleted.");
		}

		if (dir.exists()) {
			System.out.println("Directory exists, deleting files inside first: ");
			recursiveDelete(dir.listFiles());
			System.out.println("Files inside directory have been deleted.");
			if (dir.delete()) {
				System.out.println("Directory has been deleted.");
			} else {
				System.out.println("Failed to delete directory.");
			}
		} else {
			System.out.println("No directory to be deleted.");
		}

		System.out.println("Creating new file: " + f.getName());
		f.createNewFile();
		System.out.println("File created at: " + f.getAbsolutePath());
	}

	void recursiveDelete(File[] files) {
		for (File file : files) {
			if (file.listFiles() != null) {
				recursiveDelete(file.listFiles());
			}
			file.delete();
		}
	}

	void isDirectory() {
		System.out.println("File is directory? " + f.isDirectory());
	}

	void isFile() {
		System.out.println("File is a regular file? " + f.isFile());
	}

	void length() {
		System.out.println("File length is: " + f.length());
	}

	void lastModified() {
		System.out.println("File lastModified: " + new Timestamp(f.lastModified()));
	}

	void renameTo() {
		System.out.println("Renaming file " + f.getName() + " to " + f2.getName());
		f.renameTo(f2);
	}

	void getParent() {
		System.out.println("File getParent: " + f.getParent());
	}

	void mkdir() throws IOException {
//		System.out.println("Creating directory: " + dir.mkdir()); //mkdir won't work because dirs is not created.
		System.out.println("Creating directory: " + dir.mkdirs());
		System.out.println("Creating files inside: " + dir.getName());
		for (int i = 0; i < 3; i++) {
			new File(dir.getAbsolutePath() + File.separator + "File" + i + ".txt").createNewFile();
		}
		new File(dir.getAbsolutePath() + File.separator + "dir1_1").mkdir();
		new File(dir.getAbsolutePath() + File.separator + "dir1_1/nestedfile.txt").createNewFile();
	}

	public static void main(String[] args) throws IOException {
		Files f = new Files();
		f.isDirectory();
		f.isFile();
		f.length();
		f.lastModified();
		f.renameTo();
		f.getParent();
		f.mkdir();
	}
}
