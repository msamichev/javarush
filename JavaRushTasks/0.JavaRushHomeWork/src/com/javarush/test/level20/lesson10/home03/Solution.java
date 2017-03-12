package com.javarush.test.level20.lesson10.home03;

import java.io.*;

/* Найти ошибки
Почему-то при сериализации/десериализации объекта класса B возникают ошибки.
Найдите проблему и исправьте ее.
Класс A не должен реализовывать интерфейсы Serializable и Externalizable.
Сигнатура класса В не содержит ошибку :)
Метод main не участвует в тестировании.
*/
public class Solution implements Serializable{
    public static class A {
        protected String name = "A";

        public A(String name) {
            this.name += name;
        }

        public A()
        {
        }

        @Override
        public String toString()
        {
            return "A{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    public class B extends A implements Serializable {
        public B(String name) {
            super(name);
            this.name += name;
        }

        public B()
        {
        }

        private void writeObject(ObjectOutputStream out) throws IOException {
            out.defaultWriteObject();
            out.writeObject(name);
        }

        private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
            in.defaultReadObject();
            name = (String) in.readObject();
        }


        @Override
        public String toString()
        {
            return super.toString();
        }
    }


    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        File file = new File("c:/temp/file1.txt");

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));

        B b = new Solution().new B("test");
        out.writeObject(b);
        out.close();
        System.out.println(b);

        ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));

        B b1 = (B) in.readObject();
        System.out.println(b1);
        in.close();
    }
}
