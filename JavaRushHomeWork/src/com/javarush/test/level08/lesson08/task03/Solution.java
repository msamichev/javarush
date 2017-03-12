package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;
import java.util.Map;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        Map map = new HashMap<>();
        map.put("попов1", "максим1");
        map.put("попов2", "максим2");
        map.put("попов3", "максим3");
        map.put("попов4", "максим4");
        map.put("попов5", "максим5");
        map.put("попов6", "максим6");
        map.put("попов7", "максим7");
        map.put("попов8", "максим8");
        map.put("попов9", "максим9");
        map.put("попов0", "максим0");


        return (HashMap<String, String>) map;


    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
        int count = 0;

        for (String s : map.values())
        {
            if (s.equals(name))
            {
                count++;
            }
        }

        return count;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName)
    {
        int count = 0;

        for (String s : map.keySet())
        {
            if (s.equals(lastName))
            {
                count++;
            }
        }

        return count;

    }
}
