package com.javarush.test.level17.lesson10.bonus02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD 2
CrUD Batch - multiple Creation, Updates, Deletion
!!!РЕКОМЕНДУЕТСЯ выполнить level17.lesson10.bonus01 перед этой задачей!!!

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u  - обновляет соответствующие данные людей с заданными id
-d  - производит логическое удаление всех людей с заданными id
-i  - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople
Порядок вывода данных соответствует вводу данных
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных)
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat
*/

public class Solution
{
    public volatile static List<Person> allPeople = new ArrayList<Person>();

    static
    {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException
    {
        if (args.length < 2)
        {
            System.out.println("Incorrect number of arguments");
            System.exit(1);
        }

        SimpleDateFormat df1 = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        SimpleDateFormat df2 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

        switch (args[0])
        {
            case "-c":
            {
                synchronized (Solution.class)
                {
                    int i = 1;
                    System.out.println();
                    while (args.length > i * 3)
                    {

                        //System.out.println("Create...");
                        if ("м".equals(args[i * 3 - 1]))
                        {
                            allPeople.add(Person.createMale(args[i * 3 - 2], df1.parse(args[i * 3])));
                        } else
                        {
                            allPeople.add(Person.createFemale(args[i * 3 - 2], df1.parse(args[i * 3])));
                        }
                        i++;
                        System.out.println(allPeople.size() - 1);
                    }
                }
                break;
            }
            case "-u":
            {
                synchronized (Solution.class)
                {
                    int i = 1;
                    while (args.length > i * 4)
                    {
                        //System.out.println("Update...");

                        Person person = allPeople.get(Integer.parseInt(args[i * 4 - 3]));
                        person.setName(args[i * 4 - 2]);
                        person.setSex("м".equals(args[i * 4 - 1]) ? Sex.MALE : Sex.FEMALE);
                        person.setBirthDay(df1.parse(args[i * 4]));
                        i++;
                    }
                }
                break;

            }
            case "-d":
            {
                synchronized (Solution.class)
                {
                    int i = 1;
                    while (args.length > i * 1)
                    {
                        //System.out.println("Delete...");
                        Person person = allPeople.get(Integer.parseInt(args[i * 1]));
                        person.setName(null);
                        person.setSex(null);
                        person.setBirthDay(null);
                        i++;
                    }
                }
                break;
            }
            case "-i":
            {
                synchronized (Solution.class)
                {
                    int i = 1;
                    while (args.length > i * 1)
                    {
                        //System.out.println("Info...");
                        Person person = allPeople.get(Integer.parseInt(args[i * 1]));
                        System.out.println(person.getName() + " " + (Sex.MALE.equals(person.getSex()) ? "м" : "ж") + " " + df2.format(person.getBirthDay()));
                        i++;
                    }
                }
                break;
            }
            default:
            {
                System.out.println("Incorrect params....");
            }
        }

        //System.out.println(allPeople);


    }
}
