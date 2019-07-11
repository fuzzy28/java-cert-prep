package datetimes;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
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
	}

	static void difference() {
		System.out.println("-----------Difference-----------");
		LocalDate ld1 = LocalDate.of(2019, Month.JUNE, 28);
		LocalDate ld2 = LocalDate.now();

//		System.out.println("# of Days between June 28, 2019 and now: " + ChronoUnit.HOURS.between(ld1, ld2)); // Time is unsupported
		System.out.println("# of Days between June 28, 2019 and now: " + ChronoUnit.DAYS.between(ld1, ld2));
		
		LocalTime lt1 = LocalTime.of(22, 20);
		LocalTime lt2 = LocalTime.now();
//		System.out.println("# of minutes between 22:20 and now: " + ChronoUnit.DAYS.between(lt1, lt2)); // Days is unsupported
		System.out.println("# of minutes between 22:20 and now: " + ChronoUnit.MINUTES.between(lt1, lt2)); 
	}

	public static void main(String[] args) {
		period();
		duration();
		difference();
	}
}
