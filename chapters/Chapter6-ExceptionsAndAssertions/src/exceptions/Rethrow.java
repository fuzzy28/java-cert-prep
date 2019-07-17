package exceptions;

import java.io.FileNotFoundException;
import java.text.ParseException;

public class Rethrow {

	static void rethrowExcpetion() throws ParseException, FileNotFoundException {

		try {
			error1();
			error2();
		} catch (Exception e) { // can catch generic exception and declare 'throws' to specific ones.
			throw e;
		}
	}

	static void error1() throws FileNotFoundException {
		throw new FileNotFoundException();
	}

	static void error2() throws ParseException {
		throw new ParseException(null, 0);
	}

}
