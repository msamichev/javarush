package com.javarush.test.level20.lesson02.task02;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution
{
    public static void main(String[] args)
    {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try
        {
            //File your_file_name = File.createTempFile("your_file_name", null);
            String your_file_name = "c:/temp/file1.txt";
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            User user1 = new User();
            user1.setLastName("lastname");
            //user1.setFirstName("first");
            user1.setBirthDate(new Date());
            user1.setCountry(User.Country.RUSSIA);
            User user2 = new User();
            user2.setLastName("lastname1");
            user2.setFirstName("first1");
            user2.setBirthDate(new Date());
            //user2.setCountry(User.Country.OTHER);
            javaRush.users.add(user1);
            javaRush.users.add(user2);
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        }
        catch (IOException e)
        {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        }
        catch (Exception e)
        {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush
    {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception
        {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");

            PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.println(users.size());

            for (User user : users)
            {
                StringBuilder sb = new StringBuilder();
                sb
                        .append(user.getFirstName() != null ? user.getFirstName() : "null")
                        .append("|").append(user.getLastName() != null ? user.getLastName() : "null")
                        .append("|").append(user.getBirthDate() != null ? simpleDateFormat.format(user.getBirthDate()) : "null")
                        .append("|").append(user.isMale() ? "M" : "F")
                        .append("|").append(user.getCountry() != null ? user.getCountry().getDisplayedName() : "null")
                        .append("|");
                printWriter.println(sb.toString());

            }
            printWriter.flush();
        }

        public void load(InputStream inputStream) throws Exception
        {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            int countOfUsers = Integer.parseInt(reader.readLine());
            for (int i = 0; i < countOfUsers; i++)
            {
                User user = new User();
                String line = reader.readLine();
                String[] splt = line.split("\\|");
                user.setFirstName("null".equals(splt[0]) ? null : splt[0]);
                user.setLastName("null".equals(splt[1]) ? null : splt[1]);
                user.setBirthDate("null".equals(splt[2]) ? null : simpleDateFormat.parse(splt[2]));
                user.setMale("M".equals(splt[3]));


                switch (splt[4])
                {
                    case "Russia":
                    {
                        user.setCountry(User.Country.RUSSIA);
                        break;
                    }
                    case "Ukraine":
                    {
                        user.setCountry(User.Country.UKRAINE);
                        break;
                    }
                    case "Other":
                    {
                        user.setCountry(User.Country.OTHER);
                    }
                }

                users.add(user);
            }

            //implement this method - реализуйте этот метод
        }
    }
}
