package com.javarush.test.level19.lesson10.bonus01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
Пример:
оригинальный   редактированный    общий
file1:         file2:             результат:(lines)

строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка4                           REMOVED строка4
строка5        строка5            SAME строка5
строка0                           ADDED строка0
строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка5                           ADDED строка5
строка4        строка4            SAME строка4
строка5                           REMOVED строка5
*/

public class Solution
{
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String f1 = reader.readLine();
        String f2 = reader.readLine();
        reader.close();

        List<String> l1 = new ArrayList<>();
        BufferedReader reader1 = new BufferedReader(new FileReader(f1));
        BufferedReader reader2 = new BufferedReader(new FileReader(f2));
        boolean takePrev = false;
        String prevLine1 = null;
        String prevLine2 = null;
        while (reader1.ready() || reader2.ready() || takePrev)
        {
            String line1;
            String line2;
            if(!takePrev)
            {
                line1 = reader1.ready() ? reader1.readLine() : null;
                line2 = reader2.ready() ? reader2.readLine() : null;
            }else{
                line1 = prevLine1;
                line2 = prevLine2;
                takePrev = false;
            }

            if (line1 == null)
            {
                lines.add(new LineItem(Type.ADDED, line2));
            } else if (line2 == null)
            {
                lines.add(new LineItem(Type.REMOVED, line1));
            } else if (line1.equals(line2))
            {
                lines.add(new LineItem(Type.SAME, line1));
            } else
            {
                String line3 = reader2.ready() ? reader2.readLine() : null;
                if (line1.equals(line3))
                {
                    lines.add(new LineItem(Type.ADDED, line2));
                    lines.add(new LineItem(Type.SAME, line1));
                } else
                {
                    String line4 = reader1.ready() ? reader1.readLine() : null;
                    String line5 = reader1.ready() ? reader1.readLine() : null;
                    lines.add(new LineItem(Type.REMOVED, line1));
                    lines.add(new LineItem(Type.SAME, line2));

                    prevLine1 = line5;
                    prevLine2 = line3;
                    takePrev = true;
                }
            }
        }

        reader1.close();
        reader2.close();


//        for (int i = 0; i < l1.size(); i++)
//        {
//            if (l2.contains(l1.get(i)))
//            {
//                for (int j = 0; j < l2.size(); j++)
//                {
//                    if (l1.get(i).equals(l2.get(j)))
//                    {
//                        if (j != 0 && !l1.contains(l2.get(j - 1)))
//                        {
//                            lines.add(new LineItem(Type.ADDED, l2.get(j - 1)));
//                        }
//                        lines.add(new LineItem(Type.SAME, l1.get(i)));
//                        if (j == l2.size() - 2 && !l1.contains(l2.get(j + 1)))
//                        {
//                            lines.add(new LineItem(Type.ADDED, l2.get(j + 1)));
//                        }
//                        break;
//                    }
//                }
//            } else
//            {
//                lines.add(new LineItem(Type.REMOVED, l1.get(i)));
//            }
//        }

        for (LineItem line : lines)
        {
            System.out.println(line);
        }

    }


    public static enum Type
    {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem
    {
        public Type type;
        public String line;

        public LineItem(Type type, String line)
        {
            this.type = type;
            this.line = line;
        }


        @Override
        public String toString()
        {
            return type + " - " + line;
        }
    }
}
