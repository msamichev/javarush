package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.FileStorageStrategy;
import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.OurHashMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.StorageStrategy;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 *
 */
public class Solution {

    public static void main(String[] args) {

        testStrategy(new HashMapStorageStrategy(), 10);
        testStrategy(new OurHashMapStorageStrategy(), 10);
        testStrategy(new FileStorageStrategy(), 10);

    }

    public static Set<Long> getIds(Shortener shortener, Set<String> strings) {
        Set<Long> res = new HashSet<>();

        for (String s : strings) {
            res.add(shortener.getId(s));
        }
        return res;
    }


    public static Set<String> getStrings(Shortener shortener, Set<Long> keys) {
        Set<String> res = new HashSet<>();

        for (Long l : keys) {
            res.add(shortener.getString(l));
        }
        return res;
    }


    public static void testStrategy(StorageStrategy strategy, long elementsNumber) {
        Helper.printMessage(strategy.getClass().getSimpleName());

        Set<String> strings = new HashSet<>();
        for (long i = 0; i < elementsNumber; i++) {
            strings.add(Helper.generateRandomString());
        }

        Shortener shortener = new Shortener(strategy);

        Date start1 = new Date();
        Set<Long> ids = getIds(shortener, strings);
        Date end1 = new Date();
        Helper.printMessage(String.valueOf(end1.getTime() - start1.getTime()));

        Date start2 = new Date();
        Set<String> stringsTest = getStrings(shortener, ids);
        Date end2 = new Date();
        Helper.printMessage(String.valueOf(end2.getTime() - start2.getTime()));

        if (strings.size() == stringsTest.size()) Helper.printMessage("Тест пройден.");
        else Helper.printMessage("Тест не пройден.");

    }


}
