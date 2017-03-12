package com.javarush.test.level22.lesson09.task03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* Составить цепочку слов
В методе main считайте с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставить все слова в таком порядке,
чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Метод getLine должен возвращать любой вариант.
Слова разделять пробелом.
В файле не обязательно будет много слов.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена
*/
public class Solution
{
    public static void main(String[] args) throws IOException
    {
        //...
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String f = reader.readLine();
        reader.close();


        BufferedReader in = new BufferedReader(new FileReader(f));

        StringBuilder sb = new StringBuilder();

        String line;
        while ((line = in.readLine()) != null)
        {
            sb.append(line).append(" ");
        }


        in.close();

        StringBuilder result = getLine(sb.toString().toString().trim().split(" "));
        System.out.println(result.toString());
    }


    public static StringBuilder getLine(String... words)
    {
        StringBuilder sb = new StringBuilder();
        if (words == null || words.length == 0) return sb;
        if (words.length == 1) return sb.append(words[0]);
        List<String> list = Arrays.asList(words);
        int count = 0;
        while (true)
        {
            for (int i = 0; i < words.length - 1; i++)
            {
                String s1 = list.get(i).substring(list.get(i).length() - 1);
                String s2 = list.get(i + 1).substring(0, 1);
                if (s1.equalsIgnoreCase(s2))// в дебажере здесь можно увидеть, что первый символ обрезан и равен ""
                {
                    count++;
                } else
                {
                    count = 0;
                    break;
                }
            }
            if (count + 1 == words.length)
            {
                for (int i = 0; i < list.size(); i++)
                {
                    sb.append(list.get(i)).append(" ");
                }
                sb.substring(0, sb.length());
                return sb;
            }
            Collections.shuffle(list);
//            System.out.println(".");
        }
    }


    //    public static StringBuilder getLine(String... words)
//    {
//
//        StringBuilder sb = new StringBuilder();
//
//        if (words != null && words.length > 0)
//        {
//
//            for (int i = 0; i < words.length; i++)
//            {
//                if (words[i] != null)
//                {
//                    if (sb.length() == 0)
//                    {
//                        sb.append(words[i]);
//                        words[i] = null;
//                        i = 0;
//                    } else
//                    {
//                        if (String.valueOf(sb.charAt(sb.length() - 1)).equalsIgnoreCase(String.valueOf(words[i].charAt(0))))
//                        {
//                            sb.append(" ").append(words[i]);
//                            words[i] = null;
//                            i = 0;
//                        }
//                    }
//                }
//            }
//        }
//        return sb;
//    }
}
