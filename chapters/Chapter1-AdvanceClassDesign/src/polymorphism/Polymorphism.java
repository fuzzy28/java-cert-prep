package polymorphism;

public class Polymorphism extends Parent {

	
	static void overLoad(String name) {
		System.out.println(name);
	}
	
	static void overLoad(String name, int age) {
		System.out.println(name + "," + age);
	}
	
	
	@Override
	public void overriding() {
		System.out.println("Doing on my own...");
	}
	
	public static void main(String[] args) {
		overLoad("Joel");
		overLoad("Joel", 27);
		new Polymorphism().overriding();
	}

}

class Parent {
	public void overriding() {
		System.out.println("Doing something...");
	}
}

