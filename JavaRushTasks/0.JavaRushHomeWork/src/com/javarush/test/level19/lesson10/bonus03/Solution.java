package com.javarush.test.level19.lesson10.bonus03;

/* Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат
Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span><span>Super</span><span>girl</span>
Первым параметром в метод main приходит тег. Например, "span"
Вывести на консоль все теги, которые соответствуют заданному тегу
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле
Количество пробелов, \n, \r не влияют на результат
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нету
Тег может содержать вложенные теги
Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>
<span>Super</span>
<span>girl</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        if (args.length != 1)
        {
            System.exit(1);
        }
        String startTag = "<" + args[0];
        String endTag = "</" + args[0] + ">";

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String f = reader.readLine();
        reader.close();


        BufferedReader reader1 = new BufferedReader(new FileReader(f));
        StringBuilder sb = new StringBuilder();
        while (reader1.ready())
        {
            sb.append(reader1.readLine());
        }
        reader1.close();

        Map<Integer, TagType> m = new HashMap<>();
        String content = sb.toString().replaceAll("\\n", "");
        //System.out.println(content);

        int position = -1;
        while ((position = content.indexOf(startTag, position + 1)) != -1)
        {
            m.put(position, TagType.START);
        }

        position = -1;
        while ((position = content.indexOf(endTag, position + 1)) != -1)
        {
            m.put(position, TagType.END);
        }

        Integer[] keys = m.keySet().toArray(new Integer[0]);
        Arrays.sort(keys);

        int counter = 0;
        int startPosition = 0;
        int endPosition = 0;
        for (int i = 0; i < keys.length; i++)
        {
            if (m.get(keys[i]).equals(TagType.START))
            {
                startPosition = keys[i];
                counter++;
                for (int j = i + 1; j < keys.length; j++)
                {
                    if (m.get(keys[j]).equals(TagType.START))
                    {
                        counter++;
                    } else
                    {
                        endPosition = keys[j];
                        counter--;
                    }
                    if (counter == 0)
                    {
                        break;
                    }
                }
                System.out.println(content.substring(startPosition, endPosition + endTag.length()));
            }
        }
    }


    enum TagType
    {
        START, END
    }
}
