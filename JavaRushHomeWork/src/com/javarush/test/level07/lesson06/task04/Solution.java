package com.javarush.test.level07.lesson06.task04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 10 строчек в начало списка
1. Создай список строк в методе main.
2. Добавь в него 10 строчек с клавиатуры, но только добавлять не в конец списка, а в начало.
3. Используя цикл выведи содержимое на экран, каждое значение с новой строки.
*/
public class Solution
{
    public static void main(String[] args) throws Exception
    {
        List<String> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 10; i++)
        {
            list.add(0, scanner.nextLine());
        }



        scanner.close();

        for (String s : list)
        {
            System.out.println(s);
        }
    }
}
