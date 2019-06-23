package strings;

public class StringsBasic {
	public static void main(String[] args) {
		String str1 = "STRING1";
		String str2 = "STRING1";
		String str3 = new String("STRING1");
		System.out.println(str1 == str2); // true because created on the same pool
		System.out.println(str1 == str3); // false because of new operator
		System.out.println(str1.equals(str3)); // true because it checks the string values not the reference.
	}
}
