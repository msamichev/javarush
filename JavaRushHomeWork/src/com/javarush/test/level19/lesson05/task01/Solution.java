package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
Закрыть потоки ввода-вывода.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String f1 = reader.readLine();
        String f2 = reader.readLine();

        reader.close();


        BufferedInputStream stream1 = new BufferedInputStream(new FileInputStream(f1));
        BufferedOutputStream stream2 = new BufferedOutputStream(new FileOutputStream(f2));

        int i = 0;
        while (stream1.available() > 0)
        {
            i++;
            int b = stream1.read();
            if (i % 2 == 0)
            {
                stream2.write(b);
            }
        }


        stream1.close();
        stream2.close();

    }
}
