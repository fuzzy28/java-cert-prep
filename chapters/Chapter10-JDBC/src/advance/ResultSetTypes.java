package advance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import setup.InitializeDatabase;

public class ResultSetTypes {

	@SuppressWarnings("serial")
	static Map<Integer, String> resultSetTypes = new HashMap<Integer, String>() {
		{
			put(1003, "TYPE_FORWARD_ONLY");
			put(1004, "TYPE_SCROLL_INSENSITIVE");
			put(1005, "TYPE_SCROLL_SENSITIVE");
			put(1007, "CONCUR_READ_ONLY");
			put(1008, "CONCUR_UPDATABLE");
		}
	};

	static void defaultType() throws SQLException {
		System.out.println("----------defaultType----------");
		System.out.println("Using ResultSet type: TYPE_FORWARD_ONLY");
		System.out.println("Using ResultSet Concurrency Type: CONCUR_READ_ONLY");
		printHelloWorld(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
	}
	
	static void scrollSensitiveUpdatable() throws SQLException {
		System.out.println("----------scrollSensitiveUpdatable----------");
		System.out.println("Using ResultSet type: TYPE_SCROLL_SENSITIVE");
		System.out.println("Using ResultSet Concurrency Type: CONCUR_UPDATABLE");
		printHelloWorld(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
	}
	
	static void scrollInsensitiveReadOnly() throws SQLException {
		System.out.println("----------scrollSensitiveUpdatable----------");
		System.out.println("Using ResultSet type: TYPE_SCROLL_INSENSITIVE");
		System.out.println("Using ResultSet Concurrency Type: CONCUR_READONLY");
		printHelloWorld(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	}

	static void printHelloWorld(int resultSetType, int resultSetConcurrencyType) throws SQLException {
		try (Connection con = DriverManager.getConnection(InitializeDatabase.url);
				Statement sttmt = con.createStatement(resultSetType, resultSetConcurrencyType);
				ResultSet rs = sttmt.executeQuery("SELECT 'Hello World!'")) {
			if (rs.next()) {
				System.out.println(rs.getString(1));
			}
			System.out.println("ResultSet Type:" + resultSetTypes.get(sttmt.getResultSetType()));
			System.out.println("ResultSet Concurrency Type: " + resultSetTypes.get(sttmt.getResultSetConcurrency()));
		}
	}

	public static void main(String[] args) throws SQLException {
		defaultType();
		scrollSensitiveUpdatable();
		scrollInsensitiveReadOnly();
	}
}
