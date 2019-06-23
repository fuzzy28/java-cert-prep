package collections;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapUsage {

	public static void main(String[] args) {
		System.out.println("_____________ HashMap ______________");
		new HashMapImplementation();
		System.out.println("_____________ TreeMap ______________");
		new TreeMapImplementation();
	}

	static class HashMapImplementation {
		public HashMapImplementation() {
			Map<String, String> map = new HashMap<>();
			System.out.println("Put null=null : " + map.put(null, null));
			System.out.println("Put null=null value : " + map.put(null, "null value"));
			System.out.println("Put Name=Joel : " + map.put("Name", "Joel")); //returns previous value, null if new entry
			System.out.println("Put Name=Joel Jr. : " + map.put("Name", "Joel Jr.")); 
			System.out.println("Put LastName=Ruelos : " + map.put("LastName", "Ruelos"));
			System.out.println("Map is empty: " + map.isEmpty());
			System.out.println("Map size: " + map.size());
			System.out.println("Get Name : " + map.get("Name"));
			System.out.println("Get name : " + map.get("name"));
			System.out.println("Get null : " + map.get(null));
			System.out.println("Put null=null : " + map.put(null, null));
			System.out.println("Map containskey=null : " + map.containsKey(null));
			System.out.println("Map containsvalue=null : " + map.containsValue(null));
		
			HashMapImplementation nullObject = null;
			System.out.println("Get null using null object: " + map.get(null));
			System.out.println("Remove null using null object: " + map.remove(nullObject));
			System.out.println("Get all keys: " + map.keySet());
			System.out.println("Get all values: " + map.values());
		}
	}
	
	static class TreeMapImplementation {
		public TreeMapImplementation() {
			TreeMap<String, String> treeMap = new TreeMap<>();
			treeMap.put("a", "a");
			treeMap.put("b", "b");
			treeMap.put("c", "c");
			treeMap.put("d", "d");
			treeMap.put("e", "e");
			System.out.println("Keys : " + treeMap.keySet());
			System.out.println("Lower key b: " + treeMap.lowerKey("b"));
			System.out.println("Lower Entry b: " + treeMap.lowerEntry("b"));
			System.out.println("Floor key b: " + treeMap.floorKey("b"));
			System.out.println("Lower key a: " + treeMap.lowerKey("a"));
			System.out.println("Higher key e: " + treeMap.ceilingKey("f"));
			System.out.println("Higher entry a: " + treeMap.higherEntry("a"));
		}
	}

}
