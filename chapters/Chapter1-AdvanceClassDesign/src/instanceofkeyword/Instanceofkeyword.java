package instanceofkeyword;

public class Instanceofkeyword {

	public static void main(String[] args) {

		A a = new A();
		A b = new B();
		A c = new C();
		A d = new D();

		System.out.println("a instanceof A: " + (a instanceof A)); // true
		System.out.println("b instanceof A:" + (b instanceof A)); // true
		System.out.println("b instanceof B:" + (b instanceof B)); // true
		System.out.println("c instanceof A: " + (c instanceof A)); // true
		System.out.println("c instanceof C:" + (c instanceof C)); // true
		System.out.println("c instanceof B: " + (c instanceof B)); // false
		System.out.println("d instanceof C: " + (d instanceof C)); // true
		System.out.println("d instanceof B: " + (d instanceof B)); // false
//		System.out.println(d instanceof X); //does not compile, not in hierarchy.

		System.out.println("null instanceof A: " + (null instanceof A));
		System.out.println("A instanceof Runnable: " + (a instanceof Runnable)); //allowed since runnable is an interface!
		
		Runnable r = null;
		System.out.println("r instanceof A: " + (r instanceof A)); //allowed since runnable is an interface!

	}
}

class A {

}

class B extends A {

}

class C extends A {

}

class D extends C {

}

class X {

}