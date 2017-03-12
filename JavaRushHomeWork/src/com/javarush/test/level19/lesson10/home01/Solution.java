package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution
{
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

        String[] keys = m.keySet().toArray(new String[1]);
        Arrays.sort(keys);

        for (String key : keys)
        {
            System.out.println(key + " " + m.get(key));
        }
    }
}
