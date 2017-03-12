package com.javarush.test.level17.lesson10.bonus01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD
CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-c  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u  - обновляет данные человека с данным id
-d  - производит логическое удаление человека с id
-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке
Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров: -c Миронов м 15/04/1990
*/

public class Solution
{
    public static List<Person> allPeople = new ArrayList<Person>();
    public static List<Person> removedPeople = new ArrayList<Person>();

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
                //System.out.println("Create...");
                if ("м".equals(args[2]))
                {
                    allPeople.add(Person.createMale(args[1], df1.parse(args[3])));
                } else
                {
                    allPeople.add(Person.createFemale(args[1], df1.parse(args[3])));
                }
                System.out.println(allPeople.size() - 1);
                break;
            }
            case "-u":
            {
                //System.out.println("Update...");
                Person person = allPeople.get(Integer.parseInt(args[1]));
                person.setName(args[2]);
                person.setSex("м".equals(args[3]) ? Sex.MALE : Sex.FEMALE);
                person.setBirthDay(df1.parse(args[4]));
                break;
            }
            case "-d":
            {
                //System.out.println("Delete...");
                Person person = allPeople.get(Integer.parseInt(args[1]));
                person.setName(null);
                person.setSex(null);
                person.setBirthDay(null);
                break;
            }
            case "-i":
            {
                //System.out.println("Info...");
                Person person = allPeople.get(Integer.parseInt(args[1]));
                System.out.println(person.getName() + " " + (Sex.MALE.equals(person.getSex()) ? "м" : "ж") + " " + df2.format(person.getBirthDay()));
                break;
            }
            default:
            {
                System.out.println("Incorrect params....");
            }
        }

        //System.out.println(allPeople);
        //start here - начни тут
    }
}
