package com.javarush.test.level08.lesson11.home09;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;/* Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true, если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате MAY 1 2013
Не забудьте учесть первый день года.
Пример:
JANUARY 1 2000 = true
JANUARY 2 2020 = false
*/
import java.util.Locale;

public class Solution
{
    public static void main(String[] args) throws ParseException
    {

        System.out.println(isDateOdd("JANUARY 1 2000"));
        System.out.println(isDateOdd("JANUARY 2 2020"));
        System.out.println(isDateOdd("MARCH 2 2000"));
    }

    public static boolean isDateOdd(String date) throws ParseException
    {
        DateFormat dateFormat = new SimpleDateFormat("MMMM dd yyyy", Locale.US);
        Date d = dateFormat.parse(date);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        int dy = calendar.get(Calendar.DAY_OF_YEAR);

        if(dy%2 == 0){
            return false;
        }

        return true;
    }
}
