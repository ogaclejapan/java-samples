package com.ogaclejapan;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;


public class LocalDateTest {

    @Test
    public void testConversion() throws Exception {

        LocalDate d1 = LocalDate.parse("2014-03-30");
        System.out.println(d1);

        LocalDate d2 = LocalDate.of(2014, 3, 30);
        System.out.println(d2);

        Instant instant = new Date().toInstant();
        LocalDate d3 = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();
        System.out.println(d3);

        Instant instant2 = Calendar.getInstance().toInstant();
        LocalDate d4 = LocalDateTime.ofInstant(instant2, ZoneId.systemDefault()).toLocalDate();
        System.out.println(d4);

    }

    @Test
    public void testAddDate() throws Exception {

        LocalDate today = LocalDate.now();
        System.out.println(today.plusMonths(1));

        System.out.println(today.plus(4, ChronoUnit.DAYS));

    }

    @Test
    public void testSubtractDate() throws Exception {

        LocalDate today = LocalDate.now();
        System.out.println(today.minusDays(3));

        System.out.println(today.minus(3, ChronoUnit.YEARS));

    }

    @Test
    public void testBetweenDate() throws Exception {

        LocalDate today = LocalDate.now();
        LocalDate start = LocalDate.parse("2014-03-01");
        Period period = today.until(start);

        System.out.println(period.getDays());

    }

    @Test
    public void testAdjustDate() throws Exception {

        LocalDate today = LocalDate.now();

        LocalDate firstDayOfMonth = today.with(TemporalAdjusters.firstDayOfMonth());
        System.out.println(firstDayOfMonth);

        LocalDate lastDayOfMonth = today.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(lastDayOfMonth);

        LocalDate firstDayOfNextMonth = today.with(TemporalAdjusters.firstDayOfNextMonth());
        System.out.println(firstDayOfNextMonth);

        LocalDate firstDayOfYear = today.with(TemporalAdjusters.firstDayOfYear());
        System.out.println(firstDayOfYear);

        LocalDate nextSunday = today.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
        System.out.println(nextSunday);

    }

    @Test
    public void testFormat() throws Exception {

        LocalDate today = LocalDate.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        System.out.println(today.format(formatter));

        System.out.println(today.format(DateTimeFormatter.ISO_DATE));

    }
}
