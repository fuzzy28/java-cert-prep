package datetimes;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class PeriodDuration {

	@SuppressWarnings("static-access")
	static void period() {
		System.out.println("-----------Period-----------");
		Period p = Period.ofYears(1).ofDays(100).ofMonths(10); // chaining wont work, result is just 10 months!
		System.out.println("Chained years, days, months: " + p);
		p = Period.ofDays(440);
		System.out.println("Period of 440 days: " + p);
		p = Period.ofMonths(10);
		System.out.println("Period of 10 months: " + p);
		p = Period.of(20, 1, 4);
		System.out.println("Period of 20 years, 1 month, 4 days: " + p);
	}

	@SuppressWarnings("static-access")
	static void duration() {
		System.out.println("-----------Duration-----------");
		Duration d = Duration.ofHours(10).ofSeconds(10); // chaining wont work, result is just 10 secs!
		System.out.println(d);
		d = Duration.ofMillis(100);
		System.out.println("Duration of 100 ms: " + d);
		d = Duration.ofHours(10);
		System.out.println("Duration of 10 hours: " + d);
		d = Duration.ofMinutes(10);
		System.out.println("Duration of 10 minutes: " + d);
		d = Duration.of(60, ChronoUnit.SECONDS);
		System.out.println("Duration of 60 secs: " + d);
		d = Duration.of(1, ChronoUnit.MINUTES);
		System.out.println("Duration of 1 min: " + d);
		d = Duration.of(61, ChronoUnit.SECONDS);
		System.out.println("Duration of 61 secs: " + d);
		d = Duration.of(1500, ChronoUnit.MILLIS);
		System.out.println("Duration of 1500 millis: " + d);
	}

	static void difference() {
		System.out.println("-----------Difference-----------");
		LocalDate ld1 = LocalDate.of(2019, Month.JUNE, 28);
		LocalDate ld2 = LocalDate.now();

//		System.out.println("# of Days between June 28, 2019 and now: " + ChronoUnit.HOURS.between(ld1, ld2)); // Time is unsupported
		System.out.println("# of Days between June 28, 2019 and now: " + ChronoUnit.DAYS.between(ld1, ld2));

		System.out.println("Period between now and June 28, 2019: " + Period.between(ld2, ld1)); // will show negative
																									// value if first
																									// argument is
																									// greater

		LocalTime lt1 = LocalTime.of(22, 20);
		LocalTime lt2 = LocalTime.now();
//		System.out.println("# of minutes between 22:20 and now: " + ChronoUnit.DAYS.between(lt1, lt2)); // Days is unsupported
		System.out.println("# of minutes between 22:20 and now: " + ChronoUnit.MINUTES.between(lt1, lt2));
	}

	static void equality() {
		System.out.println("-----------equality-----------");
		String d = Duration.ofDays(1).toString(); // regardless on number of days, toString() will always be in Hours!
		String p = Period.ofDays(1).toString();
		System.out.println("Duration: " + d);
		System.out.println("Period: " + p);
		System.out.println("Reference equals: " + (d == p));
		System.out.println("Method equals: " + d.equals(p));
	}

	static void dayLightDifference() {
		System.out.println("-----------dayLightDifference-----------");
		LocalDateTime ld1 = LocalDateTime.of(2015, Month.NOVEMBER, 1, 2, 0);
		ZonedDateTime zd1 = ZonedDateTime.of(ld1, ZoneId.of("US/Eastern"));
		LocalDateTime ld2 = LocalDateTime.of(2015, Month.NOVEMBER, 1, 1, 0);
		ZonedDateTime zd2 = ZonedDateTime.of(ld2, ZoneId.of("US/Eastern"));
		long x = ChronoUnit.HOURS.between(zd1, zd2);
		System.out.println(x);
	}

	public static void main(String[] args) {
		period();
		duration();
		difference();
		equality();
		dayLightDifference();
	}
}
