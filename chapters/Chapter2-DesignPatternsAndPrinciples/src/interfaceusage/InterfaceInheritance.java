package interfaceusage;

public interface InterfaceInheritance {

	default String defaultMethod1() {
		return "";
	}

	static String staticMethod() {
		return "";
	}

}

interface MyInterface extends InterfaceInheritance {

	// COMPILER ERROR!, can't hide (override) default method from parent interface
//	static String defaultMethod1() {
//		return "";
//	}

	String defaultMethod1();

	// ALLOWED!
	default String staticMethod() {
		return "";
	}

}

class MyClass implements MyInterface {

	void test() {

	}

	@Override
	public String defaultMethod1() {
		return "";
	}

}