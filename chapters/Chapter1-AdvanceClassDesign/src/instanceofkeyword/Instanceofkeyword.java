package instanceofkeyword;

public class Instanceofkeyword {

	
	public static void main(String[] args) {
		
		A a = new A();
		A b = new B();
		A c = new C();
		A d = new D();
		
		System.out.println(a instanceof A); //true
		System.out.println(b instanceof A); //true
		System.out.println(b instanceof B); //true
		System.out.println(c instanceof A); //true
		System.out.println(c instanceof C); //true
		System.out.println(c instanceof B); //false
		System.out.println(d instanceof C); //true
		System.out.println(d instanceof B); //false
//		System.out.println(d instanceof X); //does not compile, not in hierarchy.
		
	}
}


class A {
	
}

class B extends A{
	
}


class C extends A {
	
}


class D extends C {
	
}

class X {
	
}