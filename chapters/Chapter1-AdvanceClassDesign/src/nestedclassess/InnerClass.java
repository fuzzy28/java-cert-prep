package nestedclassess;

import inheritance.ClassInSamePackage;
import polymorphism.Polymorphism;

public class InnerClass {

	public InnerClass() {
		System.out.println("Outer class constructor");
	}

	private String outerVariable;

	private String name = "OuterClass name";

	private void outerMethod() {
		System.out.println("Outer method");
	}

	class InnerClass1 {

		static final String x = "";

		private String name = "InnerClass name";

		// static int i;// DOES NOT COMPILE, cannot declare static varible

		// DOES NOT COMPILE, cannot declare static initializer
//		static {
//			
//		}
//		
		{
			System.out.println("inner can declare initialization block");
		}

		public InnerClass1() {

			System.out.println("Inner class constructor ");
		}

		void instanceMethodAllowed() {
			System.out.println("This is a valid method inside inner class");
		}

		void callOuterInstanceMembers() {

			// access outer fields
			System.out.println("Outer private variable" + outerVariable);

			// access outer method
			outerMethod();
		}

		// DOES NOT COMPILE because it cannot declare static methods
//		static final void invalidMethod() {
//			
//		}

		// THEREFORE, main method won't work here in inner class
//		public static void main(String[] args) {
//			
//		}

		void displayMyName() {
			System.out.println(name);
		}

		void displayOuterClassName() {
			System.out.println(InnerClass.this.name);
		}

		void displayOtherClassName() {
//			System.out.println(ClassInSamePackage.this.hashCode()); //DOES NOT COMPILE, no available instance of class is accessible in scope of inner class
		}
	}

	public class InnerClass2 {

	}

	protected final class InnerClass3 {

	}

	private abstract class InnerClass4 extends InnerClass1 implements i1 {

	}

	public static void main(String[] args) {
		InnerClass.InnerClass1 ic = new InnerClass().new InnerClass1();
		ic.callOuterInstanceMembers();
		ic.displayMyName();
		ic.displayOuterClassName();
//		System.out.println(new InnerClass1()); // compiler error! any inner class should have an instance of the outer class
	}
}

interface i1 {

}
