package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        if (args.length != 2)
        {
            System.exit(1);
        }

        String f1 = args[0];
        String f2 = args[1];

        BufferedReader reader = new BufferedReader(new FileReader(f1));
        BufferedWriter writer = new BufferedWriter(new FileWriter(f2));

        String s;
        StringBuilder sb = new StringBuilder();
        while ((s = reader.readLine()) != null)
        {
            String[] spl = s.split(" ");
            for (String s1 : spl)
            {
                if(s1.matches(".*\\d+.*")){
                    sb.append(s1).append(" ");
                }
            }


        }
        writer.write(sb.toString().trim());

        reader.close();
        writer.close();


    }
}
