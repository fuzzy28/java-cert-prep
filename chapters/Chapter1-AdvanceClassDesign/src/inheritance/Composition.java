package inheritance;

import inheritance.differentpackage.AbstractClassInOtherPackage;

public class Composition {

	public void testCompositionOtherPackageAccessModifier() {
		AbstractClassInOtherPackage compoOther = new AbstractClassInOtherPackage() {
		};
		
//		System.out.println(compoOther.privateVar); // NOT VISIBLE
		System.out.println(compoOther.publicVar);
//		System.out.println(compoOther.protectedVar); // NOT VISIBLE WHEN USING COMPOSITION
//		System.out.println(compoOther.defaultVar); // NOT VISIBLE
	}

	public void testCompositionSamePackageAccessModifier() {
		ClassInSamePackage compSame = new ClassInSamePackage();
//		System.out.println(compSame.privateVar); // NOT VISIBLE
		System.out.println(compSame.publicVar);
		System.out.println(compSame.defaultVar);
		System.out.println(compSame.protectedVar);
	}

}
