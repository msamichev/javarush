package com.javarush.test.level07.lesson09.task01;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* Три массива
1. Введи с клавиатуры 20 чисел, сохрани их в список и рассортируй по трём другим спискам:
Число делится на 3 (x%3==0), делится на 2 (x%2==0) и все остальные.
Числа, которые делятся на 3 и на 2 одновременно, например 6, попадают в оба списка.
2. Метод printList должен выводить на экран все элементы списка с новой строки.
3. Используя метод printList выведи эти три списка на экран. Сначала тот, который для x%3, потом тот, который для x%2, потом последний.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        List<Integer> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();


        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 20; i++)
        {
            list.add(scanner.nextInt());
        }

        scanner.close();

        for (Integer integer : list)
        {
            boolean b = false;
            if (integer.intValue() % 3 == 0)
            {
                list1.add(integer);
                b = true;
            }
            if (integer.intValue() % 2 == 0)
            {
                list2.add(integer);
                b = true;
            }
            if (!b)
            {
                list3.add(integer);
            }
        }

        printList(list1);
        printList(list2);
        printList(list3);

    }


    public static void printList(List<Integer> list)
    {

        for (Integer integer : list)
        {
            System.out.println(integer);
        }

    }
}
