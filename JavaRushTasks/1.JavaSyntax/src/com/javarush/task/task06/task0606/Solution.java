package com.javarush.task.task06.task0606;

import java.io.IOException;
import java.util.Scanner;

/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        String s = String.valueOf(Math.abs(i));

        for (int j = 0; j < s.length(); j++) {
            if (Integer.parseInt(s.substring(j, j + 1)) % 2 == 0) even++;
            else odd++;

        }

        System.out.println(String.format("Even: %d Odd: %d", even, odd));


    }
}
