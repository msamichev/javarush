package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {

        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String f1 = r.readLine();
        String f2 = r.readLine();

        r.close();


        BufferedReader reader = new BufferedReader(new FileReader(f1));
        BufferedWriter writer = new BufferedWriter(new FileWriter(f2));

        String s;
        while((s = reader.readLine()) != null){
            writer.write(s.replace(".", "!") + "\n");
        }

        reader.close();
        writer.close();





    }
}
