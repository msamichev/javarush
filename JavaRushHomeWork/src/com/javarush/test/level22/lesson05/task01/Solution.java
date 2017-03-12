package com.javarush.test.level22.lesson05.task01;

/* Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
Пример: "JavaRush - лучший сервис обучения Java."
Результат: "- лучший сервис обучения"
На некорректные данные бросить исключение TooShortStringException (сделать исключением).
Сигнатуру метода getPartOfString не менять.
Метод main не участвует в тестировании.
*/
public class Solution
{

    public static void main(String[] args)
    {
        System.out.println(getPartOfString("JavaRush - лучший сервис Java"));
    }

    public static String getPartOfString(String string)
    {
        String a = null;
        try
        {
            String [] x = string.split(" ");
            a = x[1] + " " + x[2] + " " + x[3] + " " + x[4];
        }
        catch(Exception e)
        {
            throw new TooShortStringException();
        }
        return a;
    }

    public static class TooShortStringException extends RuntimeException
    {
    }
}
