package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException
    {


        Scanner scanner = new Scanner(System.in);
        String filepath1 = scanner.next();
        String filepath2 = scanner.next();

        scanner.close();

        int i = 0;
        FileInputStream stream1 = new FileInputStream(filepath1);
        FileOutputStream stream2 = new FileOutputStream(filepath2);

        byte[] arrs = new byte[stream1.available()];
        while (stream1.available() > 0)
        {
             int c = stream1.read(arrs);


        }

        for (int j = arrs.length -1; j >= 0; j--)
        {
            stream2.write(arrs[j]);
        }

        stream1.close();
        stream2.close();



    }
}
