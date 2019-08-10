package datetimes;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class USEasternDaylight {

	static void try2_30_am_time_in_march() {
		System.out.println("-------try2_30_am_time_in_march-------");
		LocalDateTime ldt = LocalDateTime.of(2016, Month.MARCH, 13, 2, 30);
		System.out.println(ldt);
		ZonedDateTime zdt = ZonedDateTime.of(ldt, ZoneId.of("US/Eastern"));
		System.out.println(zdt);
	}

	static void try2_30_am_time_in_nov() {
		System.out.println("-------try2_30_am_time_in_nov-------");
		LocalDateTime ldt = LocalDateTime.of(2016, Month.NOVEMBER, 6, 2, 10);
		System.out.println(ldt);
		ZonedDateTime zdt = ZonedDateTime.of(ldt, ZoneId.of("US/Eastern"));
		System.out.println(zdt);
		System.out.println(Duration.between(ldt, zdt));
	}

	public static void main(String[] args) {
		try2_30_am_time_in_march();
		try2_30_am_time_in_nov();
	}
}
