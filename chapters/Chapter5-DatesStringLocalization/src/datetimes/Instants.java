package datetimes;

import java.time.Duration;
import java.time.Instant;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class Instants {

	static void create() {
		System.out.println("--------Instant creation--------");
		Instant i = Instant.now();
		System.out.println("Instant now: " + i);
		i = ZonedDateTime.now(ZoneId.systemDefault()).toInstant();
		System.out.println("Zoned date time to instant: " + i);
		i = Instant.ofEpochMilli(System.currentTimeMillis());
		System.out.println("Instant of epoch milli: " + i);
	}

	static void manipulate() {
		System.out.println("--------Manipulation--------");
		Instant i = Instant.now();
		i = i.plus(Period.ofDays(5)).plus(Duration.ofHours(1));
		System.out.println("Plus period of 5 days and 1 hour: " + i);
		i = i.plus(20, ChronoUnit.DAYS);
		System.out.println("Plus 20 chrono unit day: " + i);
	}

	static void zoneOffset() {
		System.out.println("--------zoneOffset--------");
		Instant i = Instant.now();
		ZoneOffset zo = ZoneOffset.ofHoursMinutes(8, 0);
		System.out.println("Instant now:" + i);
		System.out.println("Instant with +8 offset: " + i.atOffset(zo));
	}

	public static void main(String[] args) {
		create();
		manipulate();
		zoneOffset();
	}

}
