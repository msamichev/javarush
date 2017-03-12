package com.javarush.test.level20.lesson02.task03;

import java.io.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution
{
    public static Map<String, String> properties = new HashMap<>();

//    public static void main(String[] args) throws Exception
//    {
//        new Solution().fillInPropertiesMap();
//    }

    public void fillInPropertiesMap() throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String f = reader.readLine();
        reader.close();


        FileInputStream is = new FileInputStream(f);
        load(is);
        is.close();
        //implement this method - реализуйте этот метод
    }

    public void save(OutputStream outputStream) throws Exception
    {
        Properties saveProperties = new Properties();
        for (Map.Entry<String, String> prop : properties.entrySet())
        {
            saveProperties.setProperty(prop.getKey(), prop.getValue());
        }
        saveProperties.store(outputStream, null);
        //implement this method - реализуйте этот метод
    }

    public void load(InputStream inputStream) throws Exception
    {
        Properties proper = new Properties();
        proper.load(inputStream);
        Enumeration en = proper.propertyNames();
        while (en.hasMoreElements())
        {
            String key = (String) en.nextElement();
            properties.put(key, proper.getProperty(key));
        }
        //implement this method - реализуйте этот метод
    }
}
