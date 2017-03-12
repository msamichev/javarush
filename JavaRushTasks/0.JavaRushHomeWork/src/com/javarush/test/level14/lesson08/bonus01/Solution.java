package com.javarush.test.level14.lesson08.bonus01;

import com.sun.org.apache.bcel.internal.classfile.ClassFormatException;
import com.sun.org.apache.bcel.internal.generic.ClassGenException;
import com.sun.org.apache.xerces.internal.impl.dv.DatatypeException;

import java.util.*;
import java.util.prefs.BackingStoreException;
import java.util.prefs.InvalidPreferencesFormatException;

/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution
{
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args)
    {
        initExceptions();

        for (Exception exception : exceptions)
        {
            System.out.println(exception);
        }
    }

    private static void initExceptions()
    {   //it's first exception
        try
        {
            float i = 1 / 0;

        } catch (Exception e)
        {
            exceptions.add(e);
        }

        exceptions.add(new CloneNotSupportedException());
        exceptions.add(new ConcurrentModificationException());
        exceptions.add(new TooManyListenersException());
        exceptions.add(new CloneNotSupportedException());
        exceptions.add(new ClassNotFoundException());
        exceptions.add(new ClassCastException());
        exceptions.add(new ClassFormatException());
        exceptions.add(new ClassGenException());
        exceptions.add(new NumberFormatException());

    }
}
