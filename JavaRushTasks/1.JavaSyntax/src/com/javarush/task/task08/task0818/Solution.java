package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        //напишите тут ваш код
        HashMap<String, Integer> map = new HashMap<>();
        map.put("LastName1", 100);
        map.put("LastName2", 200);
        map.put("LastName3", 300);
        map.put("LastName4", 400);
        map.put("LastName5", 500);
        map.put("LastName6", 600);
        map.put("LastName7", 700);
        map.put("LastName8", 800);
        map.put("LastName9", 900);
        map.put("LastName10", 1000);
        return map;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        if(map != null){
            Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();

            while(iterator.hasNext()){
                if(iterator.next().getValue() < 500) iterator.remove();
            }
        }
    }

    public static void main(String[] args) {
        HashMap<String, Integer> map = createMap();
        removeItemFromMap(map);
    }
}