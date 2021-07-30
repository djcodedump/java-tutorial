package com.deb.ex.date_time_examples;

import java.time.*;

public class Main {
    public static void main(String[] args) {

        LocalDate d1 = LocalDate.now();
        System.out.println(d1);

        LocalDate d2 = LocalDate.of(2021, Month.JANUARY,1);
        System.out.println(d2);

        LocalTime t1= LocalTime.now();
        System.out.println(t1);

        LocalTime t2 = LocalTime.of(10, 10, 15, 300);
        System.out.println(t2);

        ZoneId.getAvailableZoneIds().stream().sorted().forEach(System.out::println);

        LocalTime t3 = LocalTime.now(ZoneId.of("Europe/Paris"));
        System.out.println(t3);

        Instant i = Instant.now();
        System.out.println(i);

        LocalDateTime dt = LocalDateTime.now();
        System.out.println(dt);
    }
}
