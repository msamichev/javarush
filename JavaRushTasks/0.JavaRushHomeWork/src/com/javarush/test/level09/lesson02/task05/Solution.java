package com.javarush.test.level09.lesson02.task05;

/* Метод должен возвращать результат – глубину его стек-трейса
Написать метод, который возвращает результат – глубину его стек трейса – количество методов в нем (количество элементов в списке). Это же число метод должен выводить на экран.
*/

public class Solution
{

    public static void main(String[] args)
    {
        getStackTraceDeep();
    }
    public static int getStackTraceDeep()
    {
        StackTraceElement[] a = Thread.currentThread().getStackTrace();
        int i  = a.length;
        System.out.println(i);
        return i;

    }
}
