package com.javarush.test.level05.lesson12.home04;

/* Вывести на экран сегодняшнюю дату
Вывести на экран текущую дату в аналогичном виде "21 02 2014".
*/

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

public class Solution
{
    public static void main(String[] args)
    {

        SimpleDateFormat formatter = new SimpleDateFormat("dd MM yyyy");
        System.out.println(formatter.format(new Date()));

    }

}
