package com.javarush.test.level18.lesson05.task05;

/* DownloadException
1 Считывать с консоли имена файлов.
2 Если файл меньше 1000 байт, то:
2.1 Закрыть потоки
2.2 выбросить исключение DownloadException
*/

import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        Scanner scanner = null;
        try
        {
            scanner = new Scanner(System.in);

            while (true)
            {
                File file = new File(scanner.next());
                FileInputStream stream = null;
                try
                {
                    stream = new FileInputStream(file);

                    if (stream.available() < 1000)
                    {
                        throw new DownloadException();
                    }
                }
                finally
                {
                    stream.close();
                }
            }
        }
        finally
        {
            scanner.close();
        }
    }

    public static class DownloadException extends Exception
    {


    }
}
