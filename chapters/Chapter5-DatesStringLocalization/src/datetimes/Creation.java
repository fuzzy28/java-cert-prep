package datetimes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Creation {

	static void createLocalDate() {
		System.out.println("-----------Local Date-----------");
		LocalDate ld = LocalDate.now();
		System.out.println("Local date now: " + ld);
		ld = LocalDate.of(2019, 6, 28);
		System.out.println("Local date of June 28, 2019: " + ld);
		ld = LocalDate.of(2019, Month.JUNE, 28);
		System.out.println("Local date of Month.JUNE 28, 2019: " + ld);
//		ld = LocalDate.ofYearDay(2019, 366); Runtime Exception, 365 only if year is not leap year
		ld = LocalDate.ofYearDay(2019, 365);
		System.out.println("Local date ofYearDay: " + ld);
	}

	static void createLocalTime() {
		System.out.println("-----------Local Time-----------");
		LocalTime lt = LocalTime.now();
		System.out.println("Local time now: " + lt);
		lt = LocalTime.of(22, 28);
		System.out.println("Local time of: " + lt);
		lt = LocalTime.of(21, 28, 24);
		System.out.println("Local time of: " + lt);
	}

	static void createLocalDateTime() {
		System.out.println("-----------Local Date Time-----------");
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println("Local datetime now: " + ldt);
		ldt = LocalDateTime.of(LocalDate.now(), LocalTime.now());
		System.out.println("Local datetime from date and time instance: " + ldt);
		ldt = LocalDateTime.of(1992, 6, 28, 21, 28);
		System.out.println("Local date time of: " + ldt);
	}

	static void createZonedDateTime() {
		System.out.println("-----------Zoned Date Time-----------");
		ZonedDateTime zdt = ZonedDateTime.now();
		System.out.println("Zoned date time now: " + zdt);
		zdt = ZonedDateTime.now(ZoneId.systemDefault());
		System.out.println("Zoned date time now system default: " + zdt);
		zdt = ZonedDateTime.of(LocalDateTime.now(), ZoneId.systemDefault());
		System.out.println("Zoned date from date time: " + zdt);
		long zc = ZoneId.getAvailableZoneIds().stream().filter(z -> z.toLowerCase().contains("asia")).count();
		System.out.println("Available zone ids for asia: " + zc);
	}

	public static void main(String[] args) {
		createLocalDate();
		createLocalTime();
		createLocalDateTime();
		createZonedDateTime();
	}
}


interface x {
}