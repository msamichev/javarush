package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран соотношение количества пробелов к количеству всех символов. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
4. Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Solution
{
    public static void main(String[] args) throws IOException
    {

        int sc = 0;
        int ac = 0;
        BufferedInputStream stream = new BufferedInputStream(new FileInputStream(args[0]));

        while (stream.available() > 0)
        {
            int i = stream.read();
            if (i == 32)
            {
                sc++;
            }
            ac++;
        }
        stream.close();

        System.out.println((double) Math.round(sc / (double) ac * 100 * 100) / 100);

    }
}
