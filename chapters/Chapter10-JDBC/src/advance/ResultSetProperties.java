package advance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import setup.InitializeDatabase;

public class ResultSetProperties {

	static void traverseResultSet() throws SQLException {
		System.out.println("----------traverseResultSet----------");
		try (Connection con = DriverManager.getConnection(InitializeDatabase.url);
				Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
			stmt.execute(InitializeDatabase.loadResource("Employee.sql"));
			ResultSet rs = stmt.executeQuery("SELECT * FROM Employee");
			System.out.println("Traverse forward:");
			while (rs.next()) {
				printInfo(rs);
			}
			System.out.println("Traverse backward:");
			while (rs.previous()) { // throws runtime exception if result set is not scrollable
				printInfo(rs);
			}

			System.out.println("Previous: " + rs.previous());
			System.out.println("Next: " + rs.next());
			printInfo(rs);
			System.out.println("Go to last: " + rs.last());
			printInfo(rs);
			System.out.println("Go to first: " + rs.first());
			printInfo(rs);
			System.out.println("Go before first:");
			rs.beforeFirst();
			printInfo(rs);
			System.out.println("Go after last:");
			rs.afterLast();
			printInfo(rs);
			System.out.println("Go to fifth record:" + rs.absolute(5));
			printInfo(rs);
			System.out.println("Go to third record: " + rs.absolute(3));
			printInfo(rs);
			System.out.println("Go to third to the last: " + rs.absolute(-3));
			printInfo(rs);
			System.out.println("Move 2 backwards:" + rs.relative(-2));
			printInfo(rs);
			System.out.println("Move 3 forward: " + rs.relative(3));
			printInfo(rs);
			System.out.println("Delete first row: ");
			rs.first();
			rs.deleteRow();
			if (rs.rowDeleted()) {
				System.out.println("First row has been removed!");
			} else {
				System.out.println("Row not deleted!");
			}
			rs.beforeFirst(); // VOID!
			rs.next();
			printInfo(rs);
			System.out.println("Go before first using absolute:" + rs.absolute(0));
			printInfo(rs);
			System.out.println("Go next after before first: " + rs.next());
			printInfo(rs);
		}
	}

	static void printInfo(ResultSet rs) throws SQLException {
		try {
			System.out.println("ID:" + rs.getInt(1) + ", Name: " + rs.getString(2));
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	static void traverseNotScrollbable() {
		System.out.println("----------traverseNotScrollbable----------");
		try (Connection con = DriverManager.getConnection(InitializeDatabase.url);
				Statement stmt = con.createStatement()) {
			stmt.execute(InitializeDatabase.loadResource("Employee.sql"));
			ResultSet rs = stmt.executeQuery("SELECT * FROM Employee");
			System.out.println("Get row 3: " + rs.absolute(3)); // no issue on type forward only
			System.out.println("Get row 1: " + rs.absolute(1)); // throws runtime error, cannot go back to previous one
			System.out.println("Get previous: " + rs.previous()); //throws runtime exception since resultset is not scrollable!
		} catch(SQLException e) {
			System.err.println(e.getMessage());
		}
	}

	public static void main(String[] args) throws SQLException {
		traverseResultSet();
		traverseNotScrollbable();
	}
}
