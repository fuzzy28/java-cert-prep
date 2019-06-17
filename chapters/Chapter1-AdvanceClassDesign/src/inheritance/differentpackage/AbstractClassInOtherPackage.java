package inheritance.differentpackage;

public abstract class AbstractClassInOtherPackage {

	private String privateVar;
	protected String protectedVar;
	public String publicVar;
	String defaultVar;

	// void test(); // void test(); DOES NOT COMPILE -> METHOD NOT ABSTRACT

//	abstract void test() { //abstract method should have no implementation
//		
//	}

//	final abstract void();

	static final synchronized public void thisFinalStaticMethod() {

	}

	static void staticMethod1() {

	}

}

class Implementation extends AbstractClassInOtherPackage {
	// DOES NOT COMPILE, static is mark final
//	static public void thisFinalStaticMethod() {
//
//	}

	public Implementation() {
		staticMethod1();
	}
	
	
}
