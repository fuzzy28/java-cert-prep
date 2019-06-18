package interfaceusage;

import java.util.function.Consumer;
import java.util.function.Supplier;

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

@FunctionalInterface
interface InterfaceUsage3 {
	String test();
}

@FunctionalInterface
interface InterfaceUsage4<T> {
	
	boolean test(T t);
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
	
	void implementFunctionalInterface() {
		InterfaceUsage iu = () -> { System.out.println("Anonymous implementation");};
		iu.test();
	}
	
	void implementSupplierInterface() {
		InterfaceUsage3 iu = () -> "This is a test";
//		Supplier<String> s = iu; // DOES NOT COMPILE, still not compatible
		System.out.println(iu.test());
	}
	
	void implementPredicateInteface() {
		InterfaceUsage4<String> s = (i) -> i.contains("a");
		System.out.println(s.test("abc"));
	}
	
	public static void main(String[] args) {
		Class1 c1 = new Class1();
		c1.implementFunctionalInterface();
		c1.implementSupplierInterface();
		c1.implementPredicateInteface();
	}

}
