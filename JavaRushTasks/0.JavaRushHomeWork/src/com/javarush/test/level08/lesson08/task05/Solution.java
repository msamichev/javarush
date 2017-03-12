package com.javarush.test.level08.lesson08.task05;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution
{

    public static void main(String[] args)
    {
        Map map = createMap();
        removeTheFirstNameDuplicates((HashMap<String, String>) map);

        System.out.println(map);
    }

    public static HashMap<String, String> createMap()
    {

        Map map = new HashMap();

        map.put("Петров1", "Иван1");
        map.put("Петров2", "Иван2");
        map.put("Петров3", "Иван3");
        map.put("Петров4", "Иван4");
        map.put("Петров5", "Иван5");
        map.put("Петров6", "Иван5");
        map.put("Петров7", "Иван6");
        map.put("Петров8", "Иван7");
        map.put("Петров9", "Иван7");
        map.put("Петров0", "Иван7");


        return (HashMap<String, String>) map;

    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {

//        Set set = new HashSet();
//
//        Iterator<Map.Entry<String, String>> itr = map.entrySet().iterator();
//        while (itr.hasNext())
//        {
//            String name = itr.next().getValue();
//            if (set.contains(name))
//            {
//                itr.remove();
//            } else
//            {
//                set.add(name);
//            }
//        }

        Map<String, String> dmap = new HashMap(map);

        Set set = new HashSet();

        for (Map.Entry<String, String> stringStringEntry : dmap.entrySet())
        {
            if (set.contains(stringStringEntry.getValue()))
            {
                removeItemFromMapByValue(map, stringStringEntry.getValue());
            } else
            {
                set.add(stringStringEntry.getValue());
            }
        }
    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair : copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }
}
