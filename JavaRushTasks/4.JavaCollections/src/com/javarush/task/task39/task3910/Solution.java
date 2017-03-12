package com.javarush.task.task39.task3910;

/* 
isPowerOfThree
*/
public class Solution {
    public static void main(String[] args) {
        for (int i = 0; i < 30; i++) {
            System.out.println(i + " " + isPowerOfThree(i));
        }

    }

    public static boolean isPowerOfThree(int n) {
        if (n < 0 || n == 0) return false;
        if (n == 1) return true;
        double d = n;
        while (d >= 3)
            d/=3;

        return d == 1? true:false ;
    }
}
