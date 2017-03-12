package com.javarush.test.level18.lesson10.home08;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution
{
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException, InterruptedException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String s;
        while (!(s = reader.readLine()).equals("exit"))
        {
            new ReadThread(s).start();

        }

        reader.close();
//        Thread.sleep(1000);
//
//        for (Map.Entry<String, Integer> entry : resultMap.entrySet())
//        {
//            System.out.println(entry.getKey() + " - " + entry.getValue());
//        }

    }

    public static class ReadThread extends Thread
    {

        private String fileName;

        public ReadThread(String fileName)
        {
            this.fileName = fileName;
        }

        @Override
        public void run()
        {
            Map<Integer, Integer> m = new HashMap<>();
            int max = 0;

            BufferedInputStream stream = null;
            try
            {
                stream = new BufferedInputStream(new FileInputStream(fileName));
                while (stream.available() > 0)
                {
                    int i = stream.read();
                    if (m.containsKey(i))
                    {
                        m.put(i, m.get(i) + 1);
                    } else
                    {
                        m.put(i, 1);
                    }

                    if (m.get(i) > max)
                    {
                        max = m.get(i);
                    }
                }
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            finally
            {
                try
                {
                    stream.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }

            for (Map.Entry<Integer, Integer> entry : m.entrySet())
            {
                if (entry.getValue() == max)
                {
                    synchronized (Solution.class)
                    {
                        resultMap.put(fileName, entry.getKey());
                    }
                }
            }
        }
    }
}
