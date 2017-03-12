package com.javarush.test.level20.lesson02.task05;

import java.io.*;

/* И еще раз о синхронизации
Разберитесь почему не работает метод main()
Реализуйте логику записи в файл и чтения из файла для класса Object
Метод load должен инициализировать объект данными из файла
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution
{
    public volatile static int countStrings;

    public static void main(java.lang.String[] args)
    {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try
        {
//            File your_file_name = File.createTempFile("your_file_name", null);
            File your_file_name = new File("c:/temp/file1.txt");
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            Object object = new Object();
            object.string1 = new String();   //string #1
            object.string2 = new String();   //string #2
            System.out.println(object);
            object.save(outputStream);
            outputStream.flush();

            Object loadedObject = new Object();
            loadedObject.string1 = new String(); //string #3
            loadedObject.string2 = new String(); //string #4


            loadedObject.load(inputStream);
            System.out.println(loadedObject);
            //check here that the object variable equals to loadedObject - проверьте тут, что object и loadedObject равны

            outputStream.close();
            inputStream.close();

        }
        catch (IOException e)
        {
            e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class Object
    {
        public String string1;
        public String string2;

        public void save(OutputStream outputStream) throws Exception
        {
            PrintWriter writer = new PrintWriter(outputStream);
            writer.println(string1 != null ? string1.toString() : "null");
            writer.println(string2 != null ? string2.toString() : "null");
            writer.flush();
        }

        public void load(InputStream inputStream) throws Exception
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            java.lang.String line = null;

            line = reader.readLine();

            if (!"null".equals(line))
            {
                int i = Integer.parseInt(line.substring(line.indexOf("#") + 1));
                string1 = new String(i);
            }
            line = reader.readLine();
            if (!"null".equals(line))
            {
                int i = Integer.parseInt(line.substring(line.indexOf("#") + 1));
                string2 = new String(i);
            }

        }

        @Override
        public java.lang.String toString()
        {
            return "Object{" +
                    "string1=" + string1 +
                    ", string2=" + string2 +
                    '}';
        }
    }

    public static class String
    {
        private final int number;

        public String()
        {
            synchronized (Solution.class)
            {
                number = ++countStrings;
            }
        }


        public String(int number)
        {
            this.number = number;
        }

        public void print()
        {
            System.out.println("string #" + number);
        }


        @Override
        public java.lang.String toString()
        {
            return "string #" + number;
        }
    }
}
