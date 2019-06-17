package nestedclassess;

public class StaticNestedClass {

	public static class StaticNestedClass1 {
		static String name;

		static void test() {
			System.out.println("static method from static nested class");
		}

	}

	public static void main(String[] args) {
		System.out.println(StaticNestedClass1.name);
		StaticNestedClass1 ss = new StaticNestedClass1();
		System.out.println(ss.name);
	}

}
