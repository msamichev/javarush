package com.javarush.test.level19.lesson10.home03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution
{
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException
    {

        if (args.length < 1)
        {
            System.exit(1);
        }

        String f = args[0];
        BufferedReader reader = new BufferedReader(new FileReader(f));
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

        String s;
        while ((s = reader.readLine()) != null)
        {
            String[] splt = s.split(" ");
            Date d = dateFormat.parse(splt[splt.length - 3] + "." + splt[splt.length - 2] + "." + splt[splt.length - 1]);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < splt.length - 3; i++)
            {
                sb.append(splt[i]).append(" ");
            }

            String n = sb.toString().trim();

            PEOPLE.add(new Person(n, d));
        }


        reader.close();


    }

}
