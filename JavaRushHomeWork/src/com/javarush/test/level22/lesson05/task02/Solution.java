package com.javarush.test.level22.lesson05.task02;

/* Между табуляциями
Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
На некорректные данные бросить исключение TooShortStringException.
Класс TooShortStringException не менять.
*/
public class Solution
{
    public static String getPartOfString(String string) throws TooShortStringException
    {
//        if (string == null || string.isEmpty() || string.indexOf("\t") == -1 || string.indexOf("\t") == string.lastIndexOf("\t"))
//        {
//            throw new TooShortStringException();
//        }
//
//        return string.substring(string.indexOf("\t"), string.indexOf("\t", string.indexOf("\t") + 1));

        try
        {
            int iStart = string.indexOf("\t");
            int iEnd = string.indexOf("\t", iStart + 1);

            return string.substring(iStart + 1, iEnd);
        }
        catch (Exception e)
        {
            throw new TooShortStringException();
        }

    }

    public static void main(String[] args) throws TooShortStringException
    {
        System.out.println(getPartOfString("tab0\ttab\ttab1\t"));       //tab
        System.out.println(getPartOfString("\t\t"));                    //
        System.out.println(getPartOfString("123\t123"));                //Exception
        System.out.println(getPartOfString(null));                      //Exception
    }

    public static class TooShortStringException extends Exception
    {
    }
}
