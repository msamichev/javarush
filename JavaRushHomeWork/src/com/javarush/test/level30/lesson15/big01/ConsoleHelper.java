package com.javarush.test.level30.lesson15.big01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 */
public class ConsoleHelper
{
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));


    public static void writeMessage(String message)
    {
        System.out.println(message);
    }


    public static String readString()
    {


        while (true)
        {
            try
            {
                return bufferedReader.readLine();

            }
            catch (IOException e)
            {
                writeMessage("Произошла ошибка при попытке ввода текста. Попробуйте еще раз.");
            }
        }

    }


    public static int readInt()
    {

        while (true)
        {
            String s = readString();

            try
            {
                return Integer.parseInt(s);
            }
            catch (NumberFormatException e)
            {

                writeMessage("Произошла ошибка при попытке ввода текста. Попробуйте еще раз.");
            }
        }
    }
}
