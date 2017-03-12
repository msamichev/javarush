package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

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


    public static String readString() throws IOException
    {
        String s = bufferedReader.readLine();

        return s;
    }


    public static List<Dish> getAllDishesForOrder() throws IOException
    {
        List<Dish> res = new ArrayList<>();
        writeMessage("Please, enter dishes.");
        writeMessage(Dish.allDishesToString());
        while (true)
        {
            String s = readString();
            if ("exit".equalsIgnoreCase(s)) break;
            try
            {
                Dish dish = Dish.valueOf(s);
                res.add(dish);
            }
            catch (IllegalArgumentException e)
            {
                writeMessage(s + " is not detected");
            }


        }

        return res;
    }


}
