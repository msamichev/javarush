package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        String s = "qazxswedcvfrtgbnhyujmiklopQAZXSWEDCVFRTGBNHYUJMIKLOP";
        byte[] b = s.getBytes();

        int c = 0;
        BufferedInputStream stream = new BufferedInputStream(new FileInputStream(args[0]));

        while (stream.available() > 0)
        {
            int i = stream.read();
            for (byte b1 : b)
            {
                if (i == b1)
                {
                    c++;
                    break;
                }
            }
        }
        stream.close();

        System.out.println(c);


    }
}
