package nestedclassess;

import inheritance.differentpackage.AbstractClassInOtherPackage;

public class AnonymousClass {
	
	String name;

	public AnonymousClass() {
		AbstractClassInOtherPackage a = new AbstractClassInOtherPackage() {
			
			private String x;
			private String name;
			
			//DOES NOT COMPILE, CANNOT DEFINE static attributes and methods
//			static String y;
//			
//			static void test() {
//				
//			}
			@Override
			public String toString() {
				return AnonymousClass.this.name;
			}
		};
		
	}
}
