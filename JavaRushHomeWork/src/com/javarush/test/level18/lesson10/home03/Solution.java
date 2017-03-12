package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String s1 = reader.readLine();
        String s2 = reader.readLine();
        String s3 = reader.readLine();
        reader.close();


        BufferedInputStream is2 = new BufferedInputStream(new FileInputStream(s2));
        BufferedInputStream is3 = new BufferedInputStream(new FileInputStream(s3));
        BufferedOutputStream os1 = new BufferedOutputStream(new FileOutputStream(s1));

        byte[] b = new byte[is2.available()];
        while(is2.available() > 0){
            int c = is2.read(b);
            os1.write(b, 0, c);
        }

        b = new byte[is3.available()];
        while(is3.available() > 0){
            int c = is3.read(b);
            os1.write(b, 0, c);
        }



        is2.close();
        is3.close();
        os1.close();




    }
}
