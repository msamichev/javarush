package com.javarush.test.level22.lesson13.task03;

/* Проверка номера телефона
Метод checkTelNumber должен проверять, является ли аргумент telNumber валидным номером телефона.
Критерии валидности:
1) если номер начинается с '+', то он содержит 12 цифр
2) если номер начинается с цифры или открывающей скобки, то он содержит 10 цифр
3) может содержать 0-2 знаков '-', которые не могут идти подряд
4) может содержать 1 пару скобок '(' и ')'  , причем если она есть, то она расположена левее знаков '-'
5) скобки внутри содержат четко 3 цифры
6) номер не содержит букв
7) номер заканчивается на цифру

Примеры:
+380501234567 - true
+38(050)1234567 - true
+38050123-45-67 - true
050123-4567 - true

+38)050(1234567 - false
+38(050)1-23-45-6-7 - false
050ххх4567 - false
050123456 - false
(0)501234567 - false
*/
public class Solution
{

    public static void main(String[] args)
    {
        System.out.println(checkTelNumber("+380501234567"));
        System.out.println(checkTelNumber("+38(050)1234567"));
        System.out.println(checkTelNumber("0501234567"));
        System.out.println(checkTelNumber("(050)1234567"));
        System.out.println(checkTelNumber("+38050123-45-67"));
        System.out.println(checkTelNumber("050123-4567"));

        System.out.println(checkTelNumber("+38)050(1234567"));
        System.out.println(checkTelNumber("+38(050)1-23-45-6-7"));
        System.out.println(checkTelNumber("050ххх4567"));
        System.out.println(checkTelNumber("050123456"));
        System.out.println(checkTelNumber("(0)501234567"));
    }


    public static boolean checkTelNumber(String telNumber)
    {
        if (telNumber == null)
            return false;
        if (telNumber.length() < 10)
            return false;
        //CountNumbers
        int countNumbers = 0;
        for (int i = 0; i < telNumber.length(); i++)
        {
            String simbol = "" + telNumber.charAt(i);
            if (isDigit(simbol))
                countNumbers++;
        }
        String regexp1 = "(\\+)?([0-9])*(\\([0-9]{3}\\))?([0-9])*(-)?([0-9])+(-)?([0-9])*";
        String regexp2 = "(\\+)?([0-9])*(\\([0-9]{3}\\))?([0-9])*";
        if (telNumber.charAt(0) == '+' && telNumber.matches(regexp1) && countNumbers == 12 && telNumber.charAt(1) != '-' && isDigit(String.valueOf(telNumber.charAt(telNumber.length() - 1))))
            return true;
        else if (telNumber.charAt(0) == '+' && telNumber.matches(regexp2) && countNumbers == 12 && isDigit(String.valueOf(telNumber.charAt(telNumber.length() - 1))))
            return true;
        else if (telNumber.matches(regexp1) && countNumbers == 10 && telNumber.charAt(0) != '-' && isDigit(String.valueOf(telNumber.charAt(telNumber.length() - 1))))
            return true;
        else if (telNumber.matches(regexp2) && countNumbers == 10 && isDigit(String.valueOf(telNumber.charAt(telNumber.length() - 1))))
            return true;
        return false;
    }

    public static boolean isDigit(String str)
    {
        try
        {
            Integer.parseInt(str);
            return true;
        }
        catch (Exception ex)
        {
            return false;
        }
    }
}
