package interfaceusage;

import java.util.List;

public interface DefaultMethods extends Interface1, Interface2 {

	// REQUIRED TO OVERRIDE! else compiler error since method() exists in both
	// interfaces!
	@Override
	default void method() {
		Interface1.super.method();
	}

}

interface Interface1 {
	default void method() {
		System.out.println("Test");
	}
}

interface Interface2 {
	default void method() {
		System.out.println("Test");
	}
}
