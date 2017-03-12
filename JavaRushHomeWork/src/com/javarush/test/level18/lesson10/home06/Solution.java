package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution
{
    public static void main(String[] args) throws IOException
    {

        Map<Integer, Integer> m = new HashMap();

        BufferedInputStream stream = new BufferedInputStream(new FileInputStream(args[0]));

        while (stream.available() > 0)
        {
            int b = stream.read();
            if (m.containsKey(b))
            {
                m.put(b, m.get(b) + 1);
            } else
            {
                m.put(b, 1);
            }

        }

        stream.close();

        Integer[] i = m.keySet().toArray(new Integer[1]);
        Arrays.sort(i);

        for (Integer integer : i)
        {

            System.out.println(((char) integer.intValue()) + " " + m.get(integer));
        }


    }
}
