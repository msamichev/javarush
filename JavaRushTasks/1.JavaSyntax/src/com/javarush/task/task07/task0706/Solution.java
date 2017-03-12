package com.javarush.task.task07.task0706;

import java.util.Scanner;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] array = new int[15];
        int odd = 0;
        int even = 0;

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 15; i++) {
            array[i] = scanner.nextInt();
        }

        for (int i = 0; i < array.length; i++) {
            if (i % 2 == 0) odd += array[i];
            else even += array[i];
        }

        if(odd < even) System.out.println("В домах с нечетными номерами проживает больше жителей.");
        else System.out.println("В домах с четными номерами проживает больше жителей.");

    }
}
