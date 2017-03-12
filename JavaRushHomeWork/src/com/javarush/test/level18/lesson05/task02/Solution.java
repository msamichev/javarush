package com.javarush.test.level18.lesson05.task02;

/* Подсчет запятых
С консоли считать имя файла
Посчитать в файле количество символов ',', количество вывести на консоль
Закрыть потоки. Не использовать try-with-resources

Подсказка: нужно сравнивать с ascii-кодом символа ','
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) throws IOException
    {

        Scanner scanner = new Scanner(System.in);
        String filepath = scanner.next();

        scanner.close();

        int i = 0;
        FileInputStream stream = new FileInputStream(filepath);

        while (stream.available() > 0)
        {
            if (44 == stream.read())
            {
                i++;
            }
        }
        stream.close();

        System.out.println(i);

    }
}
