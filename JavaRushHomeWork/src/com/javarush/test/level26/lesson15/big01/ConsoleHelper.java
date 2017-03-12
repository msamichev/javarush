package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ResourceBundle;

/**
 *
 */
public class ConsoleHelper
{
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "common_en");

    public static void writeMessage(String message)
    {
        System.out.println(message);

    }

    public static Operation askOperation() throws InterruptOperationException
    {
        while (true)
        {
            try
            {
                writeMessage("Enter operation number:");
                String s = readString();
                int i = Integer.parseInt(s);
                return Operation.getAllowableOperationByOrdinal(i);
            }
            catch (NumberFormatException e)
            {
                writeMessage(res.getString("invalid.data"));
            }
            catch (IllegalArgumentException e)
            {
                writeMessage(res.getString("invalid.data"));
            }

        }

    }

    public static String askCurrencyCode() throws InterruptOperationException
    {
        writeMessage(res.getString("choose.currency.code"));
        String s = readString();
        while (s == null || s.length() != 3)
        {
            writeMessage(res.getString("invalid.data"));
            writeMessage(res.getString("choose.currency.code"));
            s = readString();
        }

        return s.toUpperCase();
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException
    {
        String[] result = null;
        while (true)
        {
            writeMessage(res.getString("choose.denomination.and.count.format"));
            String s = readString();
            if (s != null && s.split(" ").length == 2)
            {
                result = s.split(" ");
                try
                {
                    int i = Integer.parseInt(result[0]);
                    int j = Integer.parseInt(result[1]);
                    if (i > 0 && j > 0) break;
                }
                catch (NumberFormatException e)
                {
                }
            }
            writeMessage(res.getString("invalid.data"));
        }
        return result;
    }

    public static String readString() throws InterruptOperationException
    {
        String s = null;
        try
        {
            s = bufferedReader.readLine();
        }
        catch (Exception e)
        {
        }
        if ("exit".equalsIgnoreCase(s)) throw new InterruptOperationException();

        return s;
    }


    public static void printExitMessage(){
        writeMessage(res.getString("the.end"));
    }
}
