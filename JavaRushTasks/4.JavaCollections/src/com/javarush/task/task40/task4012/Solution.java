package com.javarush.task.task40.task4012;

import java.time.*;
import java.time.temporal.ChronoUnit;

/* 
Полезные методы DateTime API
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(isLeap(LocalDate.of(2016, 1, 1)));
        System.out.println(isBefore(LocalDateTime.MIN));
        System.out.println(addTime (LocalTime.of(10, 10), 10, ChronoUnit.MINUTES));
        System.out.println(getPeriodBetween(LocalDate.of(2016, 3, 1), LocalDate.of(2016, 1, 1)));
    }

    public static boolean isLeap(LocalDate date) {
        return date.isLeapYear();
    }

    public static boolean isBefore(LocalDateTime dateTime) {
        return dateTime.isBefore(LocalDateTime.now());
    }

    public static LocalTime addTime(LocalTime time, int n, ChronoUnit chronoUnit) {
        return time.plus(n, chronoUnit);
    }

    public static Period getPeriodBetween(LocalDate firstDate, LocalDate secondDate) {
        if (firstDate.isBefore(secondDate)) return Period.between(firstDate, secondDate);
        else return Period.between(secondDate, firstDate);
    }
}
