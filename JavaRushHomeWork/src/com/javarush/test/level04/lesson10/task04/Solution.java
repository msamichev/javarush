package com.javarush.test.level04.lesson10.task04;

import java.io.*;
import java.util.Scanner;

/* S-квадрат
Вывести на экран квадрат из 10х10 букв S используя цикл while.
Буквы в каждой строке не разделять.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {

        String s = "S";

        int i = 0;
        while(i < 10){
            int j = 0;
            while (j < 10)
            {
                System.out.print(s);
                j++;
            }
            System.out.println();
            i++;

        }

    }
}
