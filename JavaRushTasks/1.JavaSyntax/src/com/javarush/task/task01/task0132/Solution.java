package com.javarush.task.task01.task0132;

/* 
Сумма цифр трехзначного числа
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(sumDigitsInNumber(546));
    }

    public static int sumDigitsInNumber(int number) {
        String s = String.valueOf(number);
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += Integer.parseInt(s.substring(i, i + 1));
        }
        return count;
    }
}