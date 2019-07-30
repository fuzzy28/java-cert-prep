package props;

import java.util.Properties;

public class PropertyUsage {

	static void properties() {
		Properties props = new Properties();
		props.put("a", "a");
		props.put("b", "b");
		props.put("c", "c");
		System.out.println("Get value of a: " + props.get("a"));
//		System.out.println("Get value of d or default 'xxx': " + props.get("a", "a123")); //COMPILE ERROR, wrong method name!
		System.out.println("Get value of d or default 'xxx': " + props.getProperty("d", "xxx"));
		System.out.println("Get value of d or default 'xxx': " + props.getOrDefault("d", "xxx"));
	}

	public static void main(String[] args) {
		properties();
	}
}
