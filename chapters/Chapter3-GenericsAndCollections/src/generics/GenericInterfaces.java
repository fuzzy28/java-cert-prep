package generics;

public class GenericInterfaces {

	public static void main(String[] args) {
		ImplementGenericFunction2<Integer> i = new ImplementGenericFunction2<>(2);
		System.out.println(i.apply("1", "2"));

//		ImplementGenericFunction2<String> i2 = new T(); // DOES NOT compile

		ImplementGenericFunction2<Integer> i2 = new ImplementGenericFunction2<>(2);
//		System.out.println(i instanceof ImplementGenericFunction2<Integer>); // DOES NOT compile, Cannot perform
																				// instanceof check against
																				// parameterized type
		//proper way to use instance of 
		System.out.println(i instanceof ImplementGenericFunction2);
		System.out.println(i instanceof ImplementGenericFunction2<?>);
		
	}
}

interface GenericFunction2<T, U, R> {

	R apply(T first, U second);

}

class ImplementGenericFunction2<U> implements GenericFunction2<String, String, U> {

	private U u;
	
//	static U u2; // DOES NOT compile, type is linked to the instance of the class

	public ImplementGenericFunction2(U u) {
		this.u = u;
	}

	public U apply(String first, String second) {
		return u;
	}
	
	@Override
	public String toString() {
		return u.toString();
	}

}