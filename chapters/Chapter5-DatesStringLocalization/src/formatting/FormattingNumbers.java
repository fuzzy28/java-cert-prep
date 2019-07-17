package formatting;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class FormattingNumbers {

	static void creation() {
		System.out.println("--------Creation--------");
		System.out.println("General purpose formatter: " + NumberFormat.getInstance());
		System.out.println("General purpose with locale: " + NumberFormat.getInstance(Locale.GERMAN));
		System.out.println("Get Number instance (same as above): " + NumberFormat.getNumberInstance());
		System.out.println("Get Number instance with locale: " + NumberFormat.getNumberInstance(Locale.GERMANY));
		System.out.println("Get currency instance: " + NumberFormat.getCurrencyInstance());
		System.out.println("Get currency instance with locale: " + NumberFormat.getCurrencyInstance(Locale.GERMAN));
		System.out.println("Get percent instance: " + NumberFormat.getPercentInstance());
		System.out.println("Get percent instance with locale: " + NumberFormat.getPercentInstance(Locale.GERMANY));
		System.out.println("Get integer instance: " + NumberFormat.getIntegerInstance());
		System.out.println("Get integer instance with locale: " + NumberFormat.getIntegerInstance(Locale.GERMANY));
	}

	static void formatAsString() {
		System.out.println("--------Format-------");
		System.out.println("Format 123456 using current locale: " + NumberFormat.getInstance().format(123456));
		System.out.println("Using current german locale: " + NumberFormat.getInstance(Locale.GERMAN).format(123456));
		System.out.println(
				"Format 123456.0 using current localce: " + NumberFormat.getCurrencyInstance().format(123456.0));
		System.out
				.println("Uusing current localce: " + NumberFormat.getCurrencyInstance(Locale.GERMAN).format(123456.0));
	}

	static void parseStringAsNumber() throws ParseException {
		System.out.println("--------Parse-------");
		System.out.println("Parse 123456 using current locale: " + NumberFormat.getInstance().parse("123,456"));
		System.out.println(
				"Parse 123456 using german locale: " + NumberFormat.getInstance(Locale.GERMAN).parse("123,456"));
		// Parses only the beginning of a string. After it reaches a
		// character that cannot be parsed, the parsing stops and the value is returned.
		System.out.println("Parse with special chars: " + NumberFormat.getInstance().parse("123xxx456"));
		System.out.println("Parse with special chars: " + NumberFormat.getInstance().parse("1234$$%^&*()"));
//		System.out.println("Parse with special chars: " + NumberFormat.getInstance().parse("$%^&")); // throws ParseException
	}

	public static void main(String[] args) throws ParseException {
		creation();
		formatAsString();
		parseStringAsNumber();
	}
}
