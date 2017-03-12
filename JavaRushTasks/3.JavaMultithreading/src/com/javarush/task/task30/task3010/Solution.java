package com.javarush.task.task30.task3010;

/* 
Минимальное допустимое основание системы счисления
*/

import java.math.BigInteger;

public class Solution {
    public static void main(String[] args) {
        try {
            String one = args[0];
            boolean check = true;
            for (int i = 2; i < 37; i++) {
                try {
                    new BigInteger(one, i);
                    System.out.println(i);
                    check = false;
                    break;
                } catch (NumberFormatException e) {
                }
            }
            if (check) {
                System.out.println("incorrect");
            }

        } catch (Exception e) {
        }
    }
}