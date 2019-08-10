package functionalinterfaces;

import java.util.ArrayList;
import java.util.function.Function;
import java.util.function.Supplier;

public class SupplierUsage {

	public static void main(String[] args) {

		Supplier<String> str = () -> new String("New String");
		Supplier<Integer> in = () -> 1;
		Supplier<SupplierUsage> su = () -> new SupplierUsage();
//		Supplier<SupplierUsage> su2 = () -> SupplierUsage::new; // DOES NOT COMPILE! wrong syntax! no () ->
		Supplier<SupplierUsage> su3 = SupplierUsage::new; // will use default empty arg constructor
		Supplier<ArrayList<String>> c1 = ArrayList<String>::new;

		Supplier<Supply> supply1 = Supply::new;

		Function<Integer, Supply> supply2 = Supply::new;

		System.out.println("Get string: " + str.get());
		System.out.println("Get integer: " + in.get());
		System.out.println("Get class from new operator: " + su.get());
		System.out.println("Get class from lambda ::new operator: " + su3.get());
		System.out.println("Get collection: " + c1.get());
		System.out.println("Get supply: " + supply1.get());
		System.out.println("Get supply with arg: " + supply2.apply(10));
	}

}

class Supply {
	int i;

	public Supply() {

	}

	public Supply(int i) {
		this.i = i;
	}

	@Override
	public String toString() {
		return i + "";
	}
}