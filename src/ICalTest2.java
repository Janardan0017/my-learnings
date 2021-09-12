
import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.model.Date;
import net.fortuna.ical4j.model.component.VEvent;
import net.fortuna.ical4j.model.property.CalScale;
import net.fortuna.ical4j.model.property.ProdId;
import net.fortuna.ical4j.model.property.Uid;
import net.fortuna.ical4j.model.property.Version;
import net.fortuna.ical4j.util.RandomUidGenerator;
import net.fortuna.ical4j.util.UidGenerator;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class ICalTest2 {

    public static void main(String[] args) {
        /* Event start and end time in milliseconds */
        Long startDateTimeInMillis = 1615956275000L;
        Long endDateTimeInMillis = 1615959875000L;

//        java.util.Calendar calendarStartTime = new GregorianCalendar();
//        calendarStartTime.setTimeInMillis(startDateTimeInMillis);

        // Time zone info
//        TimeZone tz = calendarStartTime.getTimeZone();
//        ZoneId zid = tz.toZoneId();
        ZoneId zoneId = TimeZone.getTimeZone("Asia/Kolkata").toZoneId();

        /* Generate unique identifier */
        UidGenerator ug = new RandomUidGenerator();
        Uid uid = ug.generateUid();

        /* Create the event */
        String eventSummary = "Happy New Year";
//        LocalDateTime start = LocalDateTime.ofInstant(calendarStartTime.toInstant(), zid);
//        LocalDateTime end = LocalDateTime.ofInstant(Instant.ofEpochMilli(endDateTimeInMillis), zid);
//        Instant startTimeInstance = Instant.ofEpochMilli(startDateTimeInMillis);
//        ZonedDateTime start = ZonedDateTime.ofInstant(startTimeInstance, zoneId);
//        Instant endTimeInstant = Instant.ofEpochMilli(endDateTimeInMillis);
//        ZonedDateTime end = ZonedDateTime.ofInstant(endTimeInstant, zoneId);
        VEvent event = new VEvent(new Date(startDateTimeInMillis), new Date(endDateTimeInMillis), eventSummary);
        event.getProperties().add(uid);

        /* Create calendar */
        Calendar calendar = new Calendar();
        calendar.getProperties().add(new ProdId("-//Ben Fortuna//iCal4j 1.0//EN"));
        calendar.getProperties().add(Version.VERSION_2_0);
        calendar.getProperties().add(CalScale.GREGORIAN);

        /* Add event to calendar */
        calendar.getComponents().add(event);

//        byte[] calendarByte = calendar.toString().getBytes();
        System.out.println(calendar);
    }
}
