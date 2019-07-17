package exceptions;

public class CustomException {

	public static void main(String[] args) {
		try {
			throw new MyException("This is a custom exception");
		} catch (MyException e) {
			System.out.println("Error message: " + e.getMessage());
		}
	}

}

class MyException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 358806258684732209L;

	public MyException() {
		super();
	}

	public MyException(String message) {
		super(message);
	}

	public MyException(String message, Throwable e) {
		super(message, e);
	}

}