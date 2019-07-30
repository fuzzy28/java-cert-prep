package exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

public class BasicTryStatement {

	static void tryStatement() {
		System.out.println("-------Basic try statement-------");
		try {
			System.out.println("inside try...");
			throw new Exception("error");
		} catch (Exception e) {
			System.out.println("inside catch...");
		}
	}

	static void multiCatch() {
		System.out.println("-------Multi catch-------");
		try {
			System.out.println("inside try...");
			throw new FileNotFoundException("File not found!");
		}
//		catch (Throwable t) {} // below will be unreachable / compile error
		catch (RuntimeException e) {
			System.out.println("catched exception: " + e);
		} catch (FileNotFoundException e) {
			System.out.println("catched exception: " + e);
		} catch (Exception e) {
			System.out.println("catched exception: " + e);
			e = new Exception(); // mutable
		}

	}

	static void multiCatch2() {
		System.out.println("-------Multi catch 2-------");
		try {
			System.out.println("inside try...");
			throw new FileNotFoundException("File not found!");
		} catch (RuntimeException | FileNotFoundException e) {
			System.out.println("catched exception: " + e);
//			e = null; // compile error, e is effectively final
		}
//		catch(ParseException pe) {} // compilation error, this exception is never thrown from the try statement body
	}

	static void catchIt() throws SQLException {
		System.out.println("-------catchIt-------");
		try {
			readFromDatabase();
//		} catch(SQLException | IOException e) { //compiler error! IOException is not thrown in the try statement!
		} catch(SQLException e) {
			throw e;
		}
	}

	private static void readFromDatabase() throws SQLException {
	}

	public static void main(String[] args) {
		tryStatement();
		multiCatch();
		multiCatch2();
	}
}
