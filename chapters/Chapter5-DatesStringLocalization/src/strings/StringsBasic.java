package strings;

public class StringsBasic {

	static void strings() {
		System.out.println("------------Strings------------");
		String name = "Joel";
		System.out.println("Index of j: " + name.indexOf("j"));
		System.out.println("Char at 2: " + name.charAt(2));
		System.out.println("Index of oe : " + name.indexOf("oe"));
		System.out.println("Replace l -> L: " + name.replace("l", "L"));
		System.out.println("Substring: 2-3: " + name.substring(2, 3));
	}

	static void stringBuilder() {
		System.out.println("------------String builder------------");
		StringBuilder sb = new StringBuilder();
		sb.append(123).append(456);
		System.out.println(sb);
		StringBuilder sb2 = sb.reverse();
		System.out.println("Reverse sb: " + sb);
		System.out.println("Reverse sb2: " + sb2);
		System.out.println("sb equals sb2 reversed string: " + sb.equals(sb2));
		System.out.println("Delete last 3 chars: " + sb.delete(3, 100)); // upper bound doesn't throw runtime exception
		System.out.println("Insert at position 2: " + sb2.insert(2, 'X'));
	}

	static void stringBuffer() {
		System.out.println("------------String buffer------------");
		StringBuffer sb = new StringBuffer();
		sb.append("123").append("456");
		System.out.println("String buffer: " + sb);
		System.out.println("Reverse buffer: " + sb.reverse());
		System.out.println("Delete last character: " + sb.delete(5, 2000)); // upper bound doesn't throw runtime
																			// exception
	}

	public static void main(String[] args) {
		strings();
		stringBuilder();
		stringBuffer();
	}
}
