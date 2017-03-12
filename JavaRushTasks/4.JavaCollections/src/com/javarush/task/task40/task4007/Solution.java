package com.javarush.task.task40.task4007;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.Executors;

/* 
Работа с датами
*/

public class Solution {
    public static void main(String[] args) {
        printDate("12.3.2017 15:56:45");
        System.out.println();
        printDate("21.4.2014");
        System.out.println();
        printDate("17:33:40");
    }

    public static void printDate(String date) {
        SimpleDateFormat df = null;
        boolean hasDate = false;
        boolean hasTime = false;


        if (date.contains(" ")) {
            df = new SimpleDateFormat("d.M.yyyy H:m:s");
            hasDate = true;
            hasTime = true;
        } else if (date.contains(".")) {
            df = new SimpleDateFormat("d.M.yyyy");
            hasDate = true;
        } else if (date.contains(":")) {
            df = new SimpleDateFormat("H:m:s");
            hasTime = true;
        }

        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(df.parse(date));


            if (hasDate) {
                System.out.println("День: " + calendar.get(Calendar.DAY_OF_MONTH));
                System.out.println("День недели: " + (calendar.get(Calendar.DAY_OF_WEEK) - 1 == 0 ? 7 : calendar.get(Calendar.DAY_OF_WEEK) - 1 ));
                System.out.println("День месяца: " + calendar.get(Calendar.DAY_OF_MONTH));
                System.out.println("День года: " + calendar.get(Calendar.DAY_OF_YEAR));
                System.out.println("Неделя месяца: " + calendar.get(Calendar.WEEK_OF_MONTH));
                System.out.println("Неделя года: " + calendar.get(Calendar.WEEK_OF_YEAR));
                System.out.println("Месяц: " + (calendar.get(Calendar.MONTH) + 1));
                System.out.println("Год: " + calendar.get(Calendar.YEAR));
            }
            if (hasTime) {
                if (calendar.get(Calendar.AM_PM) == 1)
                    System.out.println("AM или PM: PM");
                else
                    System.out.println("AM или PM: AM");
                System.out.println("Часы: " + calendar.get(Calendar.HOUR));
                System.out.println("Часы дня: " + calendar.get(Calendar.HOUR_OF_DAY));
                System.out.println("Минуты: " + calendar.get(Calendar.MINUTE));
                System.out.println("Секунды: " + calendar.get(Calendar.SECOND));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
