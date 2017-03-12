package com.javarush.task.task39.task3902;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Биты были биты
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Please type in a number: ");

        long l = Long.parseLong(reader.readLine());
        String result = isWeightEven(l) ? "even" : "odd";
        System.out.println("Number of ones in a given number is " + result);

    }

    public static boolean isWeightEven(long number) {
        int lo = (int) number;
        lo -= ((lo >> 1) & 0x55555555);
        lo = (lo & 0x33333333) + ((lo >> 2) & 0x33333333);
        int hi = (int) (number >> 32);
        hi -= ((hi >> 1) & 0x55555555);
        hi = (hi & 0x33333333) + ((hi >> 2) & 0x33333333);
        hi += lo;
        hi = (hi & 0x0F0F0F0F) + ((hi >> 4) & 0x0F0F0F0F);
        hi += (hi >> 16);
        return ((hi + (hi >> 8)) & 0x000000FF) % 2 == 0;
    }
}
