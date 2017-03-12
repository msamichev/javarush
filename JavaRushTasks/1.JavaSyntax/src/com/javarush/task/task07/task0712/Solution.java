package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int listLong = 0;
        int listShort = 0;
        for (int i = 0; i < 10; i++) {
            String line = reader.readLine();
            list.add(line);
            if (i == 0) {
                listLong = list.get(0).length();
                listShort = listLong;
            }
            if (line.length() > listLong) {
                listLong = line.length();
            }
            if (line.length() < listShort) {
                listShort = line.length();
            }
        }
        for (String s : list) {
            if (s.length() == listLong) {
                System.out.println(s);
                break;
            }
            if (s.length() == listShort) {
                System.out.println(s);
                break;
            }
        }
    }

}
