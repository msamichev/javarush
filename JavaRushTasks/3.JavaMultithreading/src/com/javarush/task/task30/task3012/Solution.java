package com.javarush.task.task30.task3012;

/* 
Получи заданное число
*/

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private String s;

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.createExpression(1234);
    }

    public void createExpression(int number) {
        String s = convertToRadix3(number);

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '-') list.add(Integer.parseInt(s.substring(i, ++i + 1)));
            else list.add(Integer.parseInt(s.substring(i, i + 1)));
        }

        StringBuilder sb = new StringBuilder();
        sb.append(number).append(" = ");

        for (int i = list.size() - 1; i >= 0; i--) {
            int n = list.get(i);

            if (n > 0) sb.append(" + ").append((int) Math.pow(3, list.size() - i - 1));
            else if (n < 0) sb.append(" - ").append((int) Math.pow(3, list.size() - i - 1));

        }

        System.out.println(sb.toString());
    }


    private static String convertToRadix3(int number) {
        String s = "";
        int n = number;

        while (n > 0) {
            int q = n / 3;
            int r = n % 3;
            if (r <= 1) {
                s = (char) (r + '0') + s;
                n = q;
            } else {
                r = 3 - r;
                s = '-' + ((char) (r + '0') + s);
                n = q + 1;
            }
        }
        return s;
    }
}