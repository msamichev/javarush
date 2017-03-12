package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String s1 = reader.readLine();
        String s2 = reader.readLine();
        reader.close();



        BufferedInputStream is1 = new BufferedInputStream(new FileInputStream(s1));
        BufferedInputStream is2 = new BufferedInputStream(new FileInputStream(s2));

        byte[] b1 = new byte[is1.available()];
        byte[] b2 = new byte[is2.available()];

        int c1 = is1.read(b1);
        int c2 = is2.read(b2);
        is1.close();
        is2.close();



        BufferedOutputStream os1 = new BufferedOutputStream(new FileOutputStream(s1));
        os1.write(b2, 0, c2);
        os1.write(b1, 0, c1);

        os1.close();
    }
}
