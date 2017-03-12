package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) throws IOException
    {

        Scanner scanner = new Scanner(System.in);
        String filepath1 = scanner.next();
        String filepath2 = scanner.next();
        String filepath3 = scanner.next();

        scanner.close();

        int i = 0;
        FileInputStream stream1 = new FileInputStream(filepath1);
        FileOutputStream stream2 = new FileOutputStream(filepath2);
        FileOutputStream stream3 = new FileOutputStream(filepath3);

        int a = stream1.available();

        //System.out.println(a);
        //System.out.println(a/2);

        while (stream1.available() > 0)
        {
            if(stream1.available() > a/2){
                stream2.write(stream1.read());
            }else{
                stream3.write(stream1.read());
            }
        }
        stream1.close();
        stream2.close();
        stream3.close();


    }
}
