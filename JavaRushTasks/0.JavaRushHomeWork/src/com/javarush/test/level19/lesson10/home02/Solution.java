package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException
    {

        if (args.length < 1)
        {
            System.exit(1);
        }

        String f = args[0];

        Map<String, Double> m = new HashMap<>();
        BufferedReader reader = new BufferedReader(new FileReader(f));
        String line;
        while ((line = reader.readLine()) != null)
        {
            String[] s = line.split(" ");
            if (m.containsKey(s[0]))
            {
                m.put(s[0], m.get(s[0]) + Double.parseDouble(s[1]));
            } else
            {
                m.put(s[0], Double.parseDouble(s[1]));
            }

        }
        reader.close();

        Double[] val = m.values().toArray(new Double[1]);
        Arrays.sort(val);

        for (Map.Entry<String, Double> entry : m.entrySet())
        {
            if(entry.getValue().equals(val[val.length-1])){
                System.out.println(entry.getKey());
            }
        }
    }
}
