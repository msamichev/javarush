package com.javarush.test.level21.lesson08.task03;

/* Запретить клонирование
Разрешите клонировать класс А
Запретите клонировать класс B
Разрешите клонировать класс C
Метод main не участвует в тестировании.
*/
public class Solution
{
    public static void main(String[] args) throws CloneNotSupportedException
    {
        A a = new A(1, 1);
        A clone = (A) a.clone();

        System.out.println(a);
        System.out.println(clone);

        try
        {
            B b = new B(1, 1, "b");
            B cloneB = (B) b.clone();
            System.out.println(b);
            System.out.println(cloneB);
        }
        catch (CloneNotSupportedException e)
        {
            e.printStackTrace();
        }

        C c = new C(1, 1, "q");
        C cloneC = (C) c.clone();

        System.out.println(c);
        System.out.println(cloneC);

    }

    public static class A implements Cloneable
    {
        private int i;
        private int j;

        public A(int i, int j)
        {
            this.i = i;
            this.j = j;
        }

        public int getI()
        {
            return i;
        }

        public int getJ()
        {
            return j;
        }


        @Override
        protected Object clone() throws CloneNotSupportedException
        {
            return super.clone();
        }
    }

    public static class B extends A
    {
        private String name;

        public B(int i, int j, String name)
        {
            super(i, j);
            this.name = name;
        }

        public String getName()
        {
            return name;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException
        {
            throw new CloneNotSupportedException();
        }
    }

    public static class C extends B
    {
        public C(int i, int j, String name)
        {
            super(i, j, name);
        }

        @Override
        protected Object clone() throws CloneNotSupportedException
        {
            C clone = new C(getI(),getJ(),getName());

            return clone;
        }
    }
}
