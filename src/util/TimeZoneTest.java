package util;

import java.time.ZoneId;
import java.util.TimeZone;

public class TimeZoneTest {

    public static void main(String[] args) {
        ZoneId zoneId = ZoneId.of("Europe/Rome");
        System.out.println(zoneId);
        System.out.println(zoneId.getId());
        TimeZone timeZone = TimeZone.getTimeZone(zoneId);
        System.out.println(timeZone.getRawOffset());
        System.out.println();
    }
}
