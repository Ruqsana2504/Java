package com.datetime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class DateTimeFormatterDemo {

    static void main() {
        //String to localDate
        String date = "1995-11-25";
        LocalDate stringToLocalDate = LocalDate.parse(date);
        System.out.println(stringToLocalDate); //1995-11-25

        date = "1995/11/25";
        LocalDate stringToLocalDate1 = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        System.out.println(stringToLocalDate1); //1995-11-25

        String dateTimeString = "2025-06-28 11:48:50+05:30";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssXXX");
        ZonedDateTime zonedDateTime = ZonedDateTime.parse(dateTimeString, formatter);
        System.out.println(zonedDateTime); //2025-06-28T11:48:50+05:30

        //LocalDate To String
        LocalDate localDate = LocalDate.of(1997, 7, 27);
        String dateToString = localDate.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        System.out.println(dateToString); //1997/07/27

        localDate = LocalDate.of(2024, 11, 2);
        String nightMare = DateTimeFormatter.ofPattern("yyyy/MM/dd").format(localDate);
        System.out.println(nightMare); //2024/11/02

        LocalDateTime localDateTime = LocalDateTime.of(2025, Month.JUNE, 28, 11, 48, 50);
        System.out.println(localDateTime); //2025-06-28T11:48:50

        String formattedDate = localDateTime.format(DateTimeFormatter.ISO_DATE);
        System.out.println(formattedDate); //2025-06-28

        String formattedDate2 = localDateTime.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        System.out.println(formattedDate2); //2025/06/28

        String formattedDate3 = localDateTime.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM));
        System.out.println(formattedDate3); //28 Jun 2025

        String formattedTime1 = localDateTime.format(DateTimeFormatter.ISO_TIME);
        System.out.println(formattedTime1); //11:48:50

        ZoneId zoneId = ZoneId.of("Asia/Calcutta");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");
        Instant instant = Instant.ofEpochMilli(1751138381L); // Note the 'L' for long literal
        ZonedDateTime dateTimeIn = ZonedDateTime.ofInstant(instant, zoneId);
        System.out.println(dateTimeIn.format(dateTimeFormatter));

    }
}
