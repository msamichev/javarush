package com.javarush.test.level04.lesson07.task02;

/* Строка - описание
Ввести с клавиатуры целое число в диапазоне 1 - 999. Вывести его строку-описание следующего вида:
«четное однозначное число» - если число четное и имеет одну цифру,
«нечетное однозначное число» - если число нечетное и имеет одну цифру,
«четное двузначное число» - если число четное и имеет две цифры,
«нечетное двузначное число» - если число нечетное и имеет две цифры,
«четное трехзначное число» - если число четное и имеет три цифры,
«нечетное трехзначное число» - если число нечетное и имеет три цифры.
Если введенное число не попадает в диапазон 1 - 999, в таком случае ничего не выводить на экран.
Пример для числа 100:
четное трехзначное число
Пример для числа 51:
нечетное двузначное число
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());

        boolean isEven = a % 2 == 0;

        if (a >= 1 && a < 10)
        {
            if (isEven)
            {
                System.out.println("четное однозначное число");
            } else
            {
                System.out.println("нечетное однозначное число");
            }
        } else if (a >= 10 && a < 100)
        {
            if (isEven)
            {
                System.out.println("четное двузначное число");
            } else
            {
                System.out.println("нечетное двузначное число");
            }
        } else if (a >= 100 && a <= 999)
        {
            if (isEven)
            {
                System.out.println("четное трехзначное число");
            } else
            {
                System.out.println("нечетное трехзначное число");
            }
        }

    }
}
