package com.javarush.test.level22.lesson09.task01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Порядок слов first/second не влияет на тестирование.
Использовать StringBuilder.
Пример содержимого файла
рот тор торт о
о тот тот тот
Вывод:
рот тор
о о
тот тот
*/
public class Solution
{
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException
    {

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

        String[] arr = sb.toString().split(" ");

        Map<String, Pair> set = new LinkedHashMap<>();

        for (int i = 0; i < arr.length; i++)
        {
            String w1 = arr[i];
            String w2 = new StringBuilder(w1).reverse().toString();


            if (set.containsKey(w2))
            {
                if (set.get(w2).second == null)
                {
                    set.get(w2).second = w1;
                }
            } else
            {
                Pair p = new Pair();
                p.first = w1;
                set.put(w1, p);
            }
        }

        for (Map.Entry<String, Pair> entry : set.entrySet())
        {
            if (entry.getValue().second != null)
            {
                result.add(entry.getValue());
            }
        }


        for (Pair pair : result)
        {
            System.out.println(pair);
        }

    }

    public static class Pair
    {
        String first;
        String second;

        @Override
        public String toString()
        {
            return first == null && second == null ? "" :
                    first == null && second != null ? second :
                            second == null && first != null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }

    }

}
