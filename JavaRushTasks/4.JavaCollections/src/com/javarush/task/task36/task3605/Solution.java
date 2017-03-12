package com.javarush.task.task36.task3605;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Set;
import java.util.TreeSet;

/* 
Использование TreeSet
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        Set<String> set = new TreeSet<>();

        try (InputStream is = new FileInputStream(args[0])) {
            int b;
            String c;

            while (is.available() > 0) {
                b = is.read();
                if ((b >= 65 && b <= 90) || (b >= 97 && b <= 122)) {
                    c = String.valueOf((char) b).toLowerCase();
                    set.add(c);
                }
            }
        }

        int i = 0;
        for (String str : set) {
            if (++i > 5) {
                break;
            }
            System.out.print(str);
        }
    }
}
