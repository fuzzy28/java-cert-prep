package assertions;

// In real world production ready application, assertion shouldn't be used 
// It should not be catch as well!
// this program is expected to run with below VM args:
// -ea:assertions... -da:assertions.Assertion2
public class Assertion {

	static int i = 0;

	static void basicUsage() {
		try {
			assert i > 0;
			System.out.println("This line won't be printed if assertion is enabled");
		} catch (AssertionError ae) {
			ae.printStackTrace();
		}
	}

	static void withMessage() {
		try {
			assert i++ > 0 : "i is not greater than to 0";
		} catch (AssertionError ae) {
			ae.printStackTrace();
			System.out.println("value of i is " + i);
		}
	}

	static void callAssertion2() {
		System.out.println("Assertion2 assertion is disabled, should not throw assertion error: " + new Assertion2());
	}

	public static void main(String[] args) {
		basicUsage();
		withMessage();
		callAssertion2();
	}

}
