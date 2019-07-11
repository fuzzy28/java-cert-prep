package datetimes;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class Manipulation {

	static void localDate() {
		System.out.println("------------Date manipulation------------");
		LocalDate ld = LocalDate.now();
		ld = ld.plusDays(10);
		System.out.println("Date now plus 10 days: " + ld);
		ld = ld.plusWeeks(1);
		System.out.println("Plus 10 weeks: " + ld);
		ld = ld.plusMonths(1);
		System.out.println("Plus 1 month: " + ld);
		ld = ld.plusYears(1);
		System.out.println("Plus 1 year: " + ld);
		ld = ld.minusYears(1);
		System.out.println("Minus 1 year: " + ld);
		ld = ld.minusMonths(1);
		System.out.println("Minus 1 month: " + ld);
		ld = ld.minusWeeks(1);
		System.out.println("Minus 1 week: " + ld);
		ld = ld.minusDays(10);
		System.out.println("Minus 10 days: " + ld);
		ld = ld.minus(12, ChronoUnit.DAYS);
		System.out.println("Minus 12 days chrono unit: " + ld);
		ld = ld.plus(Period.ofDays(10));
		System.out.println("Plus 10 days period: " + ld);
	}

	static void localTime() {
		System.out.println("------------Time manipulation------------");
		LocalTime lt = LocalTime.now();
		lt = lt.plusHours(1);
		System.out.println("Plus 1 hour: " + lt);
		lt = lt.plusMinutes(1);
		System.out.println("Plus 1 minute: " + lt);
		lt = lt.plusSeconds(1);
		System.out.println("Plus 1 sec: " + lt);
		lt = lt.plusNanos(10);
		System.out.println("Plus 10 nanos: " + lt);
		lt = lt.plus(1, ChronoUnit.HOURS);
		System.out.println("Plus 1 Hour chronounit: " + lt);
		lt = lt.minus(400, ChronoUnit.SECONDS);
		System.out.println("Minus 400 seconds chronounit: " + lt);
		lt = lt.minus(Duration.ofHours(2));
		System.out.println("Minus 2 hours duration : " + lt);
	}

	static void localDateTime() {
		System.out.println("------------Date Time manipulation------------");
		LocalDateTime ldt = LocalDateTime.now();
		ldt = ldt.plusDays(10).plusHours(10);
		System.out.println("Plus 10 days and 10 hours: " + ldt);
		ldt = ldt.minus(1000, ChronoUnit.NANOS).plus(1000, ChronoUnit.SECONDS);
		System.out.println("Minus 10 nanos and plus 1000 seconds: " + ldt);
		ldt = ldt.minus(Duration.ofMillis(1000)).minus(Period.ofDays(10));
		System.out.println("Minus 1000 ms duration and minus 10 days period: " + ldt);
	}

	public static void main(String[] args) {
		localDate();
		localTime();
		localDateTime();
	}
}
