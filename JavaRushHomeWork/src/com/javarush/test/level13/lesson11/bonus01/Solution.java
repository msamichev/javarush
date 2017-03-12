package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String file = br.readLine();
        br.close();


        InputStream is = new FileInputStream(file);
        StringBuilder sb = new StringBuilder();
        while(is.available() > 0){
            byte[] b= new byte[is.available()];
            is.read(b);
            sb.append(new String(b));
        }
        is.close();

        String[] s = sb.toString().split("\n");

        List<Integer> num = new ArrayList<>();

        for (String s1 : s)
        {
            if(Integer.parseInt(s1) % 2 == 0){
                num.add(Integer.parseInt(s1));
            }
        }


        Collections.sort(num);
        for (Integer integer : num)
        {
            System.out.println(integer);
        }

    }
}
