package i18n;

import java.util.ResourceBundle;

public class ResourceBundleUsage {

	static void resourceBundle() {
		System.out.println("----------Resource bundle from file----------");
		ResourceBundle rb = ResourceBundle.getBundle("RB");
		System.out.println("Get name: " + rb.getString("name"));
		System.out.println("Get first jname: " + rb.getString("first name"));
		System.out.println("Get last name: " + rb.getString("last name"));
//		System.out.println("Get invalid key: " +  rb.getString("invalid key")); // throws error if key doesn't exists
	}

	static void javaResourceBundle() {
		System.out.println("----------Resource bundle from java----------");
		ResourceBundle rb = ResourceBundle.getBundle("RB");
		System.out.println("Get name: " + rb.getString("name"));
	}

	static void printAllKeysAndValues() {
		System.out.println("----------Printing all available keys----------");
		ResourceBundle rb = ResourceBundle.getBundle("RB");
		rb.keySet().stream().forEach(k -> System.out.println("Key: " + k + ", value: " + rb.getString(k)));
	}

	public static void main(String[] args) {
		resourceBundle();
		javaResourceBundle();
		printAllKeysAndValues();
	}
}
