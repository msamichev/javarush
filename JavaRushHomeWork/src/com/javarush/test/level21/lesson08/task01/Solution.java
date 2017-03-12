package com.javarush.test.level21.lesson08.task01;

import java.util.LinkedHashMap;
import java.util.Map;

/* Глубокое клонирование карты
Клонируйтие объект класса Solution используя глубокое клонирование.
Данные в карте users также должны клонироваться.
Метод main изменять нельзя.
*/
public class Solution implements Cloneable
{

    protected Map<String, User> users = new LinkedHashMap();

    public static void main(String[] args)
    {
        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
        Solution clone = null;
        try
        {
            clone = solution.clone();
            System.out.println(solution);
            System.out.println(clone);

            System.out.println(solution.users);
            System.out.println(clone.users);

        }
        catch (CloneNotSupportedException e)
        {
            e.printStackTrace(System.err);
        }


    }

    @Override
    protected Solution clone() throws CloneNotSupportedException
    {
        Solution clone = new Solution();
        for (Map.Entry<String, User> entry : users.entrySet())
        {
            clone.users.put(entry.getKey(), entry.getValue() != null ? new User(entry.getValue().age, entry.getValue().name) : null);
        }

        return clone;
    }

    public static class User implements Cloneable
    {
        int age;
        String name;

        public User(int age, String name)
        {
            this.age = age;
            this.name = name;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException
        {
            return super.clone();
        }
    }
}
