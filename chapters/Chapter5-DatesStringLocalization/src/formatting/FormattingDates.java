package formatting;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class FormattingDates {

	static void formatDateTimeToString() {
		System.out.println("--------Predefined formats--------");
		LocalDate ld = LocalDate.now();
//		System.out.println(ld.format(DateTimeFormatter.ISO_LOCAL_TIME)); // throws Runtime exception
		System.out.println("ISO LOCAL DATE: " + ld.format(DateTimeFormatter.ISO_LOCAL_DATE));
		System.out.println("Short: " + ld.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)));
		System.out.println("Medium: " + ld.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)));
		System.out.println("Long: " + ld.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)));
		System.out.println("Full: " + ld.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
//		System.out.println("Of localized date time : " + ld.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL))); //runtime exception

		LocalDateTime ldt = LocalDateTime.now();
//		System.out.println("Full: " + ldt.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL))); JDK bug, Fixed in JDK9
		System.out.println("Full: " + ldt.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)));
	}

	static void parseStringToDateFormat() {
		System.out.println("--------Parse dates--------");
		System.out.println("Parse date: " + LocalDate.parse("20190101", DateTimeFormatter.ofPattern("yyyyMMdd")));
		// throws exception, military time should be upper case 'H'
//		System.out.println("Parse time: " + LocalDate.parse("17:50", DateTimeFormatter.ofPattern("hh:mm"))); 

		// throws exception, cannot be parsed as local date
//		System.out.println("Parse time: " + LocalDate.parse("17:50", DateTimeFormatter.ofPattern("HH:mm"))); 

		System.out.println("Parse time: " + LocalTime.parse("17:50", DateTimeFormatter.ofPattern("HH:mm")));

	}

	static void customFormat() {
		System.out.println("--------Custom formats--------");
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println("Format local date time now: " + ldt.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));

		System.out.println("Custom format: " + ldt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")));
	}

	public static void main(String[] args) {
		formatDateTimeToString();
		parseStringToDateFormat();
		customFormat();
	}
}
