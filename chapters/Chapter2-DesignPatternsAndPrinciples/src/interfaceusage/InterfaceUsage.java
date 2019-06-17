package interfaceusage;

@FunctionalInterface
public interface InterfaceUsage {

	void test();

	// void test2(); // Interface won't compile as it's annotated with
	// FunctionalInterface

	static String test = "123";

	default void defaultMethod(String name) {
		System.out.println("A default method");
	}

	static void staticMethod() {
		System.out.println("sample static method");
	}

}

@FunctionalInterface
interface InterfaceUsage2 {
	void test();
	
	default void defaultMethod(String name) {
		System.out.println("A default method");
	}

}

class Class1 implements InterfaceUsage, InterfaceUsage2 {

	@Override
	public void test() {
		System.out.println("Implemented test() method from both interfaces");
	}

	@Override
	public void defaultMethod(String name) {
		System.out.println("Override same method name from both interfaces, else compilation error");
	}

	
}
