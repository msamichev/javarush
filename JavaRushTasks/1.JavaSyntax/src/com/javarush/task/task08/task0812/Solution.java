package com.javarush.task.task08.task0812;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> l = new ArrayList<Integer>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            l.add(Integer.parseInt(reader.readLine()));
        }
        reader.close();


        Integer prev = null;

        int maxLenth = 0;
        int currLenth = 0;

        for (Integer i : l) {
            if(i.equals(prev)){
                currLenth++;
                if(currLenth > maxLenth) maxLenth = currLenth;
            }else{
                if(currLenth > maxLenth) maxLenth = currLenth;
                currLenth = 1;
                prev = i;
            }
        }


        System.out.println(maxLenth);

    }
}