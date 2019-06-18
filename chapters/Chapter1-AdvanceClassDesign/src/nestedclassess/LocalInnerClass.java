package nestedclassess;

public class LocalInnerClass {

	private String name;

	public LocalInnerClass() {
		name = "Instance variable";
	}

	void createLocalInnerClass() {
//		localClass lc = new localClass(); // DOES NOT COMPILE, class not declared yet

		String name = "local variable name";
		name = "x";
		class localClass {
			static final double PI = 3.1416;
//			static final LocalInnerClass localInnerClass = new LocalInnerClass(); // DOES NOT COMPILE, final variable doesn't work for instance variables.

			void displayOuterClassName() {
				System.out.println("Outer name : " + LocalInnerClass.this.name);
			}

			void displayLocalVariableName() {
//				System.out.println("Local variable Name : " + name); //DOES NOT COMPILE, local variable name is not effectively final as there's a reassignment to it.
			}
//			static String name; //DOES NOT COMPILE, static modifier not allowed
//			static void test() {}  //DOES NOT COMPILE, static modifier not allowed
		}

//		public class localClass2 {} // DOES NOT COMPILE, modifier not allowed
//		private class localClass3 {} // DOES NOT COMPILE, modifier not allowed
//		protected class localClass4 {} // DOES NOT COMPILE, modifier not allowed

	}

	public static void main(String[] args) {
	}
}
