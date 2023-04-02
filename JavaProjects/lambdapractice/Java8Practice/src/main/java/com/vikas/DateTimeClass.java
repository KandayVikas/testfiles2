package com.vikas;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

public class DateTimeClass {

    public static void main(String[] args) {
        LocalDate localDate=LocalDate.now(); //yyyy-MM-dd
        LocalDateTime localDateTime=LocalDateTime.now();//yyyy-MM-dd-HH-mm-ss.zzz (2020-02-20T12:06:03.015)
        System.out.println(LocalDate.of(1998,12,01)); //to customize

        // to print in a particular format
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd-MM HH:mm");
        System.out.println( "in formatted manner "+localDateTime.format(formatter).toString());

        // printing months days and minutes
        System.out.println("Month : "+localDateTime.getMonth()+" day : "+
                localDateTime.getDayOfMonth()+" minutes : "+localDateTime.getMinute());
        System.out.println(localDateTime);

        //To print Next Friday
        System.out.println(localDate.with(TemporalAdjusters.next(DayOfWeek.FRIDAY)));
        //last day of this month
        System.out.println(localDate.with(TemporalAdjusters.lastDayOfMonth()));

        LocalDate firstInYear = LocalDate.of(
                localDate.getYear(), localDate.getMonth()  , 1);

        //To print second saturday in this year
        LocalDate secondSaturday
                = firstInYear
                .with(TemporalAdjusters.nextOrSame(
                        DayOfWeek.SATURDAY))
                .with(TemporalAdjusters.next(
                        DayOfWeek.SATURDAY));

        // print date of second Saturday of this year
        System.out.println("Second saturday is on : "
                + secondSaturday);

        ZonedDateTime zonedDateTime=ZonedDateTime.now();
        System.out.println(zonedDateTime);

        ZoneId zoneId=ZoneId.of("Asia/Tokyo");
        // getting time zone of specific place we use withZoneSameInstant(): it is
        // used to return a copy of this date-time with a different time-zone,
        // retaining the instant.
        ZonedDateTime tokyoZone=zonedDateTime.withZoneSameInstant(zoneId);

        System.out.println(tokyoZone);

        DateTimeFormatter format =
                DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        String formatedDateTime = tokyoZone.format(format);

        System.out.println("formatted tokyo time zone "+
                formatedDateTime);
    }
}
