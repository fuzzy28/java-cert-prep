package inheritance;

import inheritance.differentpackage.AbstractClassInOtherPackage;

public class InheritClassOtherPackage extends AbstractClassInOtherPackage {

	public void testAccessModifiers() {
//		System.out.println(this.privateVar); // NOT VISIBLE
		System.out.println(this.protectedVar);
		System.out.println(this.publicVar);
//		System.out.println(this.defaultVar); // NOT VISIBLE

	}

	

}
