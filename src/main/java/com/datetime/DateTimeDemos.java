package com.datetime;

import java.time.*;

public class DateTimeDemos {

    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        LocalDate customLocalDate = LocalDate.of(1995, 11, 25);
        System.out.println(customLocalDate); //1995-11-25
        System.out.println(localDate); //2025-06-28

        LocalTime localTime = LocalTime.now();
        System.out.println(localTime); //23:38:57.598137

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime); // 2025-06-28T23:38:57.599138500

        //Local Date Time with zones
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime); //2025-06-28T23:38:57.600134+05:30[Asia/Calcutta]

        // UTC Time with Zone
        Instant instant = Instant.now();
        System.out.println(instant); //2025-06-28T18:08:57.600134Z
    }
}
