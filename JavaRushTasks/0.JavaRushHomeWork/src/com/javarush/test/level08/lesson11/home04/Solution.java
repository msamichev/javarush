package com.javarush.test.level08.lesson11.home04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/* Минимальное из N чисел
1. Ввести с клавиатуры число N.
2. Считать N целых чисел и заполнить ими список - метод getIntegerList.
3. Найти минимальное число среди элементов списка - метод getMinimum.
*/

public class Solution
{
    public static void main(String[] args) throws Exception {
        List<Integer> integerList = getIntegerList();
        System.out.println(getMinimum(integerList));
    }

    public static int getMinimum(List<Integer> array) {
        int res = Integer.MAX_VALUE;

        for (Integer integer : array)
        {
            if(integer < res){
                res = integer;
            }
        }
        return res;
    }

    public static List<Integer> getIntegerList() throws IOException {

        List<Integer> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        Integer i = scanner.nextInt();

        for (int j = 0; j < i; j++)
        {
            list.add(scanner.nextInt());
        }


        scanner.close();
        //Тут создать и заполнить список
        return list;
    }
}
