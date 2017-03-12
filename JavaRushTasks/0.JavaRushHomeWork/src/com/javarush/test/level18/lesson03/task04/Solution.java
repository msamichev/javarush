package com.javarush.test.level18.lesson03.task04;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байт или байты с минимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {

        Map<Integer, Integer> map = new HashMap();


        Scanner scanner = new Scanner(System.in);

        File file = new File(scanner.next());
        while (!file.exists())
        {
            //System.out.println("File does not exist!");
            file = new File(scanner.next());
        }
        scanner.close();

        BufferedInputStream reader = new BufferedInputStream(new FileInputStream(file));

        int minCount = Integer.MAX_VALUE;

        while (reader.available() > 0)
        {

            int b = reader.read();
            //System.out.println(b);
            int currentCount = 0;
            if (map.containsKey(b))
            {
                currentCount = map.get(b);
                map.put(b, currentCount + 1);

            } else
            {
                map.put(b, currentCount + 1);
            }
            if (minCount > currentCount + 1)
            {
                minCount = currentCount + 1;
            }
        }

        reader.close();

        for (Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            if (entry.getValue() == minCount)
            {
                System.out.print(entry.getKey() + " ");
            }
        }


    }
}
