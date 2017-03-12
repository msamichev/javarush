package com.javarush.test.level07.lesson04.task01;

import com.sun.java.swing.plaf.windows.WindowsInternalFrameTitlePane;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/* Максимальное среди массива на 20 чисел
1. В методе initializeArray():
1.1. Создайте массив на 20 чисел
1.2. Считайте с консоли 20 чисел и заполните ими массив
2. Метод max(int[] array) должен находить максимальное число из элементов массива
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        int[] array = initializeArray();
        int max = max(array);
        System.out.println(max);
    }
    public static int[] initializeArray() throws IOException {

        int[] a = new int[20];

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 20; i++)
        {
            a[i] = scanner.nextInt();
        }


        scanner.close();



        return a;
    }

    public static int max(int[] array) {

        int max =  array[0];
        for (int i : array)
        {
            if(max < i){
                max = i;
            }
        }

        return max;
    }
}
