package inheritance;

public class InheritClassSamePackage extends ClassInSamePackage {

	public void testAccessModifiers() {
//		System.out.println(this.privateVar); // NOT VISIBLE
		System.out.println(this.protectedVar);
		System.out.println(this.publicVar);
		System.out.println(this.defaultVar);
	}

}
