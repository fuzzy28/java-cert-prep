package enumsswitch;

import java.util.Arrays;

public enum EnumsTest {

	A, B, C {
		@Override
		void SayHello() {
			System.out.println("Hello from C");
		}
	};

	// compile error! an enum cannot have public constructor!
//	public EnumsTest() {
//
//	}

	private EnumsTest() {
		// TODO Auto-generated constructor stub
	}

	void SayHello() {
		System.out.println("Generic Say hello");
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Value is " + super.toString();
	}

	public static void main(String[] args) {
		EnumsTest.A.SayHello();
		EnumsTest.C.SayHello();
		System.out.println("Order of B: " + EnumsTest.B.ordinal());

		System.out.println(EnumsTest.valueOf("A"));
		Arrays.stream(EnumsTest.values()).forEach(x -> {
			System.out.println("Name " + x.name());
			System.out.println("Ordinal " + x.ordinal());
			System.out.println("Value " + x.valueOf(x.name()));
		});
	}
}
