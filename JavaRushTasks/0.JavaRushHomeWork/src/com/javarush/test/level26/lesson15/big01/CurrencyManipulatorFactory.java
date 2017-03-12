package com.javarush.test.level26.lesson15.big01;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class CurrencyManipulatorFactory
{
    private static Map<String, CurrencyManipulator> manipulatorMap = new HashMap<>();


    private CurrencyManipulatorFactory()
    {
    }

    public static Collection<CurrencyManipulator> getAllCurrencyManipulators(){
        return manipulatorMap.values();
    }

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode)
    {
        if (manipulatorMap.containsKey(currencyCode))
        {
            return manipulatorMap.get(currencyCode);
        } else
        {
            CurrencyManipulator currencyManipulator = new CurrencyManipulator(currencyCode);
            manipulatorMap.put(currencyCode, currencyManipulator);

            return currencyManipulator;
        }
    }
}
