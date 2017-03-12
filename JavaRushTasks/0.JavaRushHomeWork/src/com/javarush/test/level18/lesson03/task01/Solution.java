package com.javarush.test.level18.lesson03.task01;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

/* Максимальный байт
Ввести с консоли имя файла
Найти максимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {

        Scanner scanner = new Scanner(System.in);

        File file = new File(scanner.next());
        while (!file.exists())
        {
            //System.out.println("File does not exist!");
            file = new File(scanner.next());
        }
        scanner.close();

        BufferedInputStream reader = new BufferedInputStream(new FileInputStream(file));

        int maxByte = Integer.MIN_VALUE;

        while (reader.available() > 0)
        {
            int b = reader.read();
            if(b > maxByte){
                maxByte = b;
            }

        }

        reader.close();

        System.out.println(maxByte);
    }
}
