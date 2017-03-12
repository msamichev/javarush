package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        Map<Integer, String> l = new HashMap<>();

        String outFile = null;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String s;
        while (!(s = reader.readLine()).equals("end"))
        {
            if (outFile == null)
            {
                outFile = s.substring(0, s.lastIndexOf(".part"));
            }
            Integer n = Integer.parseInt(s.substring(s.lastIndexOf(".part") + 5));

            l.put(n, s);
        }

        reader.close();

        Integer[] i = l.keySet().toArray(new Integer[1]);
        Arrays.sort(i);

        BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(outFile, true));
        BufferedInputStream is;

        for (Integer integer : i)
        {
            is = new BufferedInputStream(new FileInputStream(l.get(integer)));
            byte[] b = new byte[is.available()];
            is.read(b);
            os.write(b);
            is.close();
        }
        os.close();
    }
}
