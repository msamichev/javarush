package com.javarush.test.level10.lesson11.home05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* Количество букв
Ввести с клавиатуры 10 строчек и подсчитать в них количество различных букв (для 33 букв алфавита).  Вывести результат на экран.
Пример вывода:
а 5
б 8
в 3
г 7
д 0
…
я 9
*/

public class Solution
{
    public static void main(String[] args)  throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //алфавит
        String abc = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        char[] abcArray = abc.toCharArray();

        ArrayList<Character> alphabet = new ArrayList<Character>();
        for (int i = 0; i < abcArray.length; i++)
        {
            alphabet.add(abcArray[i]);
        }

        //ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++)
        {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }


        Map<String, Integer> map = new HashMap<>();
        for (Character c : alphabet)
        {
            map.put(String.valueOf(c), 0);
        }


        for (String s : list)
        {
            for (char c : s.toCharArray())
            {
                if(map.containsKey(Character.toString(c))){
                    map.put(Character.toString(c), map.get(Character.toString(c)) + 1);
                }
            }
        }

        for (Character character : alphabet)
        {
            System.out.println(character + " " + map.get(Character.toString(character)));
        }

    }

}
