package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

public class Solution
{
    public static void main(String[] args) throws Exception
    {

        Map<Long, Item> m = new TreeMap<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        reader.close();

        BufferedReader r = new BufferedReader(new FileReader(s));
        String line;
        while ((line = r.readLine()) != null)
        {
            long id = Long.parseLong(line.substring(0, 8).trim());
            String name = line.substring(8, 38);
            double price = Double.parseDouble(line.substring(38, 46).trim());
            long count = Long.parseLong(line.substring(46, 50).trim());

            m.put(id, new Item(id, name, price, count));

        }
        r.close();

        String key = args[0];
        switch (key)
        {
            case "-u":
            {
                m.put(Long.parseLong(args[1]), new Item(Long.parseLong(args[1]), args[2], Double.parseDouble(args[3]), Long.parseLong(args[4])));
                break;
            }
            case "-d":
            {
                m.remove(Long.parseLong(args[1]));
                break;
            }
        }


        BufferedWriter bw = new BufferedWriter(new FileWriter(s));

        boolean first = true;
        for (Map.Entry<Long, Item> entry : m.entrySet())
        {
            //System.out.println(entry.getKey() + " - " + entry.getValue().getLine());
            if(!first){bw.append("\n");}
            bw.append(entry.getValue().getLine());
            first = false;
        }

        bw.close();
    }


    public static class Item
    {
        long id;
        String name;
        double price;
        long count;

        public Item(long id, String name, double price, long count)
        {
            this.id = id;
            this.name = name;
            this.price = price;
            this.count = count;
        }

        public String getLine()
        {
            StringBuilder sb = new StringBuilder();
            sb.append(String.format("%-8s", id));
            sb.append(String.format("%-30s", name));
            sb.append(String.format(Locale.ENGLISH, "%1$-8.2f", price));
            sb.append(String.format("%-4s", count));

            return sb.toString();
        }

    }

}
