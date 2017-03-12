package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        int count = 0;
        int sum = 0;
        int i;

        while ((i = scanner.nextInt()) != -1) {
            count++;
            sum += i;
        }

        System.out.println((double) sum / count);

    }
}

