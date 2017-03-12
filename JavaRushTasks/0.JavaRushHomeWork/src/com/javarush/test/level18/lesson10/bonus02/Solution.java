package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
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
        long maxId = 0;
        while ((line = r.readLine()) != null)
        {
            long id = Long.parseLong(line.substring(0, 8).trim());
            String name = line.substring(8, 38);
            double price = Double.parseDouble(line.substring(38, 46).trim());
            long count = Long.parseLong(line.substring(46, 50).trim());

            m.put(id, new Item(id, name, price, count));

            if (maxId < id)
            {
                maxId = id;
            }

        }
        r.close();

        m.put(maxId + 1, new Item(maxId + 1, args[1], Double.parseDouble(args[2]), Long.parseLong(args[3])));
        BufferedWriter bw = new BufferedWriter(new FileWriter(s, true));
        bw.write(new Item(maxId + 1, args[1], Double.parseDouble(args[2]), Long.parseLong(args[3])).getLine());

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
            sb.append(String.format("%-8s", price));
            sb.append(String.format("%-4s", count));

            return sb.toString();
        }

    }

}
