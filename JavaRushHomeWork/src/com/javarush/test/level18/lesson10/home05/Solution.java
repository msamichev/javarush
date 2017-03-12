package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s1 = reader.readLine();
        String s2 = reader.readLine();
        reader.close();

        BufferedInputStream stream = new BufferedInputStream(new FileInputStream(s1));
        byte[] b = new byte[stream.available()];
        stream.read(b);
        stream.close();

        String line = new String(b);
        String[] ar = line.split("\\s");
        StringBuilder sb = new StringBuilder();

        for (String s : ar)
        {
            if (sb.length() != 0)
            {
                sb.append(" ");
            }
            sb.append(Math.round(Double.parseDouble(s)));
        }

        BufferedOutputStream stream2 = new BufferedOutputStream(new FileOutputStream(s2));
        stream2.write(sb.toString().getBytes());
        stream2.close();
    }
}
