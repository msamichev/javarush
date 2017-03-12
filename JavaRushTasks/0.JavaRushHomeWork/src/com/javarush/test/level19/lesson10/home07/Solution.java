package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.*;
import java.util.Arrays;
import java.util.Iterator;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        if (args.length != 2)
        {
            System.exit(1);
        }


        String f1 = args[0];
        String f2 = args[1];

        BufferedReader reader = new BufferedReader(new FileReader(f1));
        BufferedWriter writer = new BufferedWriter(new FileWriter(f2));
        StringBuilder sb = new StringBuilder();
        while (reader.ready())
        {
            String line = reader.readLine();
            Iterator<String> i = Arrays.asList(line.split(" ")).iterator();
            while (i.hasNext())
            {
                String s = i.next();
                if (s.length() > 6)
                {
                    if (sb.length() == 0)
                    {
                        sb.append(s);
                    } else
                    {
                        sb.append(",").append(s);
                    }
                }
            }

        }
        writer.write(sb.toString());

        reader.close();
        writer.close();


    }
}
