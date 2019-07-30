package generics;

import java.util.ArrayList;
import java.util.List;

public class WorkingWithNonGenerics {

	public static void main(String[] args) {
		List items = new ArrayList();
		items.add("name");
		items.add(123.0);
		items.add(123);

//		COMPILER ERROR! items is raw, meaning it's item is List<Object>
//		for(String item: items) {
//			System.out.println(item);
//		}

		// correct way

		for (Object o : items) {
			System.out.println(o);
		}
	}
}
