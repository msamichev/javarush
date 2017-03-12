package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution
{
    public static void main(String[] args)
    {

        Human c1 = new Human("р1", true, 10, Collections.<Human>emptyList());
        Human c2 = new Human("р2", false, 10, Collections.<Human>emptyList());
        Human c3 = new Human("р3", true, 10, Collections.<Human>emptyList());


        Human f = new Human("f", true, 10, Arrays.asList(c1, c2, c3));
        Human m = new Human("m", false, 10, Arrays.asList(c1, c2, c3));

        Human bab1 = new Human("bab1", false, 66, Arrays.asList(f));
        Human bab2 = new Human("bab2", false, 66, Arrays.asList(m));

        Human ded1 = new Human("дед1", true, 66, Arrays.asList(f));
        Human ded2 = new Human("дед2", true, 66, Arrays.asList(m));

        System.out.println(ded1);
        System.out.println(ded2);
        System.out.println(bab1);
        System.out.println(bab2);
        System.out.println(f);
        System.out.println(m);
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);

    }

    public static class Human
    {

        public String name;
        public boolean sex;
        public int age;
        List<Human> children;

        public Human(String name, boolean sex, int age, List<Human> children)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }


        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }

            return text;
        }
    }

}
