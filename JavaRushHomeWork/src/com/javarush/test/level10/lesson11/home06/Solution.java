package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {

        String firstName;
        String lastName;
        int age;
        int weight;
        int length;
        String address;

        public Human(int age, int weight, int length, String address)
        {
            this(null, null, 0, 0, 0, address);
        }


        public Human(String lastName, int age, int weight, int length, String address)
        {
            this(null, lastName, 0, 0, 0, address);
        }



        public Human(String firstName, String lastName, String address)
        {
            this(firstName, lastName, 0, 0, 0, address);
        }


        public Human()
        {
            this(null);
        }


        public Human(String firstName)
        {
            this(firstName, null);
        }


        public Human(String firstName, String lastName)
        {
            this(firstName, lastName, 0);
        }

        public Human(String firstName, String lastName, int age)
        {
            this(firstName, lastName, age, 0);
        }

        public Human(String firstName, String lastName, int age, int weight)
        {
            this(firstName, lastName, age, weight, 0);
        }

        public Human(String firstName, String lastName, int age, int weight, int length)
        {
            this(firstName, lastName, age, weight, length, null);
        }

        public Human(String firstName, String lastName, int age, int weight, int length, String address)
        {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.weight = weight;
            this.length = length;
            this.address = address;
        }
    }
}
