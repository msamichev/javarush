package com.javarush.test.level07.lesson04.task05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/* Один большой массив и два маленьких
1. Создать массив на 20 чисел.
2. Ввести в него значения с клавиатуры.
3. Создать два массива на 10 чисел каждый.
4. Скопировать большой массив в два маленьких: половину чисел в первый маленький, вторую половину во второй маленький.
5. Вывести второй маленький массив на экран, каждое значение выводить с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {

        int[] a = new int[20];
        int[] b = new int[10];
        int[] c = new int[10];

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < a.length; i++)
        {
             a[i] = scanner.nextInt();
        }
        scanner.close();

        for (int i = 0; i < a.length; i++)
        {
              if(i < a.length/2){
                  b[i] = a[i];
              }else{
                  c[i - a.length/2] = a[i];
              }
        }

        for (int i : c)
        {
            System.out.println(i);
        }
    }
}
