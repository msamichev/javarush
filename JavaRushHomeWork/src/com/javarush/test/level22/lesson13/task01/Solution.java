package com.javarush.test.level22.lesson13.task01;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/* StringTokenizer
Используя StringTokenizer разделить query на части по разделителю delimiter.
Пример,
getTokens("level22.lesson13.task01", ".") == {"level22", "lesson13", "task01"}
*/
public class Solution
{

//
//    public static void main(String[] args)
//    {
//        String[] s = getTokens("level22.lesson13.task01", ".");
//
//        for (String s1 : s)
//        {
//            System.out.println(s1);
//        }
//    }


    public static String[] getTokens(String query, String delimiter)
    {

        List<String> l = new ArrayList();
        if (query != null && delimiter != null)
        {
            StringTokenizer st = new StringTokenizer(query, delimiter);

            while (st.hasMoreTokens())
            {
                l.add(st.nextToken());
            }
        }

        return l.toArray(new String[0]);
    }
}
