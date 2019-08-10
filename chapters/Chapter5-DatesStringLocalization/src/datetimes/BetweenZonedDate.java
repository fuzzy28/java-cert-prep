package datetimes;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class BetweenZonedDate {

	static void betweenZonedDates() {
		System.out.println("---------betweenZonedDates---------");
		LocalDateTime ld1 = LocalDateTime.of(2015, Month.NOVEMBER, 1, 2, 0);
		System.out.println("Local date time of 2015-11-01 2:00 " + ld1);
		ZonedDateTime zdt1 = ZonedDateTime.of(ld1, ZoneId.of("US/Eastern"));
		System.out.println("Zoned date time of 2015-11-01 2:00 in US/Eastern " + zdt1); //2:00 -5 hours is 10:00 am
		LocalDateTime ld2 = LocalDateTime.of(2015, Month.NOVEMBER, 1, 1, 0);
		System.out.println("Local date time of 2015-11-01 2:00 " + ld1);
		ZonedDateTime zdt2 = ZonedDateTime.of(ld2, ZoneId.of("US/Eastern"));
		System.out.println("Zoned date time of 2015-11-01 1:00 in US/Eastern " + zdt2); //1:00 -4 hours is 9:00 am
		System.out.println(Duration.between(zdt1, zdt2));
		System.out.println(ChronoUnit.HOURS.between(zdt1, zdt2));
	}
	
	public static void main(String[] args) {
		betweenZonedDates();
	}

}
