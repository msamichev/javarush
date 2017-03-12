package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution
{
    public static void main(String[] args) throws IOException
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String f1 = reader.readLine();
        String f2 = reader.readLine();

        reader.close();

        List<String> l = new ArrayList<>();
        BufferedReader reader1 = new BufferedReader(new FileReader(f1));

        String s;
        while ((s = reader1.readLine()) != null)
        {
            String[] arr = s.split("\\s");
            for (String s1 : arr)
            {
                try
                {
                    Integer.parseInt(s1);
                    l.add(s1);
                }
                catch (Exception e)
                {
                }
            }
        }

        reader1.close();

        BufferedWriter writer = new BufferedWriter(new FileWriter(f2));


        int i = 0;
        for (String s1 : l)
        {
            if(i != 0){
                writer.write(" ");
            }
            writer.write(s1);
            i++;
        }

        writer.close();
    }
}
