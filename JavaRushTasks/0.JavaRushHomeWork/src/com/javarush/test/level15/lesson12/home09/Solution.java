package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws IOException
    {


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String url = reader.readLine();


        reader.close();

        String[] paramPairs = url.substring(url.indexOf("?") + 1).split("&");

        boolean isObj = false;
        String objValue = null;
        for (String paramPair : paramPairs)
        {
            String[] paramValues = paramPair.split("=");
            if ("obj".equalsIgnoreCase(paramValues[0]))
            {
                isObj = true;
                objValue = paramValues.length > 1 ? paramValues[1] : null;
            }
            System.out.print(paramValues[0] + " ");
        }
        System.out.println();
        if (isObj)
        {
            if (isDouble(objValue))
            {
                alert(Double.parseDouble(objValue));
            } else
            {
                alert(objValue);
            }
        }
    }


    private static boolean isDouble(String s)
    {
        try
        {
            if (s != null )
            {
                Double.parseDouble(s);
                return true;
            }
            return false;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    public static void alert(double value)
    {
        System.out.println("double " + value);
    }

    public static void alert(String value)
    {
        System.out.println("String " + value);
    }
}
