package setup;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InitializeDatabase {

	public static String url = "jdbc:h2:mem:test";

	static void tryConnect() throws SQLException, ClassNotFoundException {
		System.out.println("-----------tryConnect-----------");

		try (Connection con = DriverManager.getConnection(url);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("Select 'Hello World!'")) {
			if (rs.next()) {
//				System.out.println(rs.getString(0)); // runtime exception!
				System.out.println("Connected to h2 database!");
				System.out.println(rs.getString(1));
			}
		}
	}

	public static Connection createTable() throws SQLException {
		System.out.println("-----------createTable-----------");

		try (Connection con = DriverManager.getConnection(url); Statement stmt = con.createStatement()) {
			stmt.execute(loadResource("Employee.sql"));
			System.out.println("Table has been created");
			return con;
		}
	}

	static void insertRecords() {
		System.out.println("-----------createTable-----------");
	}

	public static String loadResource(String resourceName) {
		StringBuilder sb = new StringBuilder();
		try (BufferedInputStream read = new BufferedInputStream(ClassLoader.getSystemResourceAsStream(resourceName))) {
			byte[] b = new byte[1028];
			while (read.read(b) != -1) {
				sb.append(new String(b));
			}
		} catch (IOException ioe) {
			throw new RuntimeException(ioe);
		}
		return sb.toString();
	}

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		tryConnect();
		createTable();
	}

}
