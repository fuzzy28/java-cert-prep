package exceptions;

import java.io.File;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class Exceptions {

	// Checked Exceptions

	static void parseExcception() throws ParseException {
		NumberFormat.getInstance().parse("xyz");
	}

	static void fileNotFound() throws IOException {
		new File("xyz").createNewFile();
	}

	static void sqlException() throws SQLException {
		DriverManager.getConnection("xyz");
	}

	// Unchecked Exceptions

	static void arrayStoreException() {
		Object[] o = new Exception[5];
		o[0] = 42;
	}

	static void dateTimeException() {
		LocalDate.parse("xyz");
	}

	static void missingResourceException() {
		ResourceBundle rb = ResourceBundle.getBundle("");
		rb.getString("invalid key");
	}

}
