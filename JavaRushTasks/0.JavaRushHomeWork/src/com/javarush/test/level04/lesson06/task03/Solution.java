package com.javarush.test.level04.lesson06.task03;

/* Сортировка трех чисел
Ввести с клавиатуры три числа, и вывести их в порядке убывания.
*/

import java.util.Arrays;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int[] list = new int[]{a, b, c};

        Arrays.sort(list);
        for (int i = list.length; i != 0; i--)
        {
            System.out.println(list[i - 1]);
        }


        scanner.close();
    }
}
