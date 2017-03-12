package com.javarush.test.level13.lesson11.home04;

/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести абсолютно все введенные строки в файл, каждую строчку с новой стороки.
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution
{
    public static void main(String[] args) throws IOException
    {

        List<String> l = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileName = reader.readLine();


        while (true)
        {
            String s = reader.readLine();
            l.add(s);
            if ("exit".equalsIgnoreCase(s))
            {
                break;
            }

        }

        reader.close();


        OutputStream os = new FileOutputStream(fileName);

        for (String s : l)
        {
            StringBuilder sb = new StringBuilder(s).append("\n");
            os.write(sb.toString().getBytes());
        }

        os.close();

    }
}
