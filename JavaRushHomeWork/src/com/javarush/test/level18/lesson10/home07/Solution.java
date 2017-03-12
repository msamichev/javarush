package com.javarush.test.level18.lesson10.home07;

/* Поиск данных внутри файла
Считать с консоли имя файла
Найти в файле информацию, которая относится к заданному id, и вывести ее на экран в виде, в котором она записана в файле.
Программа запускается с одним параметром: id (int)
Закрыть потоки. Не использовать try-with-resources

В файле данные разделены пробелом и хранятся в следующей последовательности:
id productName price quantity

где id - int
productName - название товара, может содержать пробелы, String
price - цена, double
quantity - количество, int

Информация по каждому товару хранится в отдельной строке
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution
{
//    public static void main(String[] args) throws IOException
//    {
//
//        Scanner scanner = new Scanner(System.in);
//        String s = scanner.next();
//        scanner.close();
//
//        BufferedInputStream stream = new BufferedInputStream(new FileInputStream(s));
//
//        byte[] b = new byte[stream.available()];
//        stream.read(b);
//        stream.close();
//
//
//        String content = new String(b);
//
//        String[] lines = content.split("\\r\\n");
//
//        Map<String, String> m = new HashMap<>();
//
//        for (String line : lines)
//        {
//            if (!line.isEmpty())
//            {
//                m.put(line.split("\\s")[0], line);
//            }
//        }
//
//        System.out.println(m.get(args[0]));
//
//    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader input = new BufferedReader(new FileReader(reader.readLine()));
        reader.close();
        String b;
        while ((b = input.readLine()) != null)
        {
            if (b.startsWith(args[0] + " "))
            {
                System.out.println(b);
                break;
            }
        }
        input.close();
    }
}
