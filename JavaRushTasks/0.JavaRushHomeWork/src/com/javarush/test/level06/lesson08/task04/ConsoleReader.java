package com.javarush.test.level06.lesson08.task04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/* Класс ConsoleReader
Сделать класс ConsoleReader, у которого будут 4 статических метода:
String readString() – читает с клавиатуры строку
int readInt() – читает с клавиатуры число
double readDouble() – читает с клавиатуры дробное число
boolean readBoolean() – читает с клавиатуры строку "true" или "false" и возвращает соответствующую логическую переменную true или false
Внимание: создавайте переменную для чтения данных с консоли (BufferedReader или Scanner) внутри каждого метода
*/

public class ConsoleReader
{
    public static String readString() throws Exception
    {
        Scanner scanner = new Scanner(System.in);
        String res =  scanner.next();

        scanner.close();

        return res;

    }

    public static int readInt() throws Exception
    {
        Scanner scanner = new Scanner(System.in);
        int res =  scanner.nextInt();

        scanner.close();

        return res;

    }

    public static double readDouble() throws Exception
    {
        Scanner scanner = new Scanner(System.in);
        double res =  scanner.nextDouble();

        scanner.close();

        return res;

    }

    public static boolean readBoolean() throws Exception
    {
        Scanner scanner = new Scanner(System.in);
        boolean res =  scanner.nextBoolean();

        scanner.close();

        return res;

    }
}
