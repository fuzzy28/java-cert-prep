package basics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import setup.InitializeDatabase;

public class CRUD {
    
	static void manipulateEmployee() throws Exception {
		System.out.println("-----------createRecord-----------");
		try (Connection con = DriverManager.getConnection(InitializeDatabase.url);
				Statement sttmt = con.createStatement()) {
			sttmt.execute(InitializeDatabase.loadResource("Employee.sql"));
			sttmt.execute("INSERT INTO Employee (name,age) values('Joel II', 27)");
			if (sttmt.getUpdateCount() > 0) {
				System.out.println("Entry has been inserted, row/s inserted: " + sttmt.getUpdateCount());
			}
			readRecords(sttmt);
			sttmt.execute("UPDATE Employee set Age = Age + 1 where Name like 'Joel%'");
			if (sttmt.getUpdateCount() > 0) {
				System.out.println("Entry has been updated, row/s updated: " + sttmt.getUpdateCount());
			}
			readRecords(sttmt);
			sttmt.execute("DELETE FROM Employee where Age >= 28");
			if (sttmt.getUpdateCount() > 0) {
				System.out.println("Entry has been updated, row/s deleted: " + sttmt.getUpdateCount());
			}
			readRecords(sttmt);

//			sttmt.executeQuery("DELETE FROM Employee"); //throws runtime exception, should use execute for DML
//			sttmt.executeUpdate("SELECT * FROM Employee"); // throws runtime exception, should use execute for DQL

		}
	}

	static void readRecords(Statement sttmt) throws Exception {
		ResultSet rs = null;
		if (sttmt.execute("SELECT * FROM Employee")) {
			rs = sttmt.getResultSet();
		}
		System.out.println("---------Printing all records---------");
		while (rs.next()) {
			System.out.println("ID:" + rs.getString(1) + "Name: " + rs.getString("name") + ", Age: " + rs.getString(3));
		}
		System.out.println("No more data to fetch...");
	}

	public static void main(String[] args) throws Exception {
		manipulateEmployee();
	}
}
