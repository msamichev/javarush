package com.javarush.task.task07.task0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Проверка на упорядоченность
*/
public class Solution {
    public static void main(String[] args) throws IOException {

        ArrayList<String> words = new ArrayList<>(10);
        BufferedReader rr = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            String s = rr.readLine();
            words.add(s);
        }
        int previous = 0;
        for (int i = 0; i < words.size(); i++) {
            int current = words.get(i).toCharArray().length;
            if (previous > current) {
                System.out.println(i);
                break;
            } else previous = current;
        }

    }
}

