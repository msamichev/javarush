package com.javarush.test.level05.lesson09.task02;

/* Создать класс Cat
Создать класс Cat (кот) с пятью конструкторами:
- Имя,
- Имя, вес, возраст
- Имя, возраст (вес стандартный)
- вес, цвет, (имя, адрес и возраст – неизвестные. Кот - бездомный)
- вес, цвет, адрес ( чужой домашний кот)
Задача конструктора – сделать объект валидным. Например, если вес не известен, то нужно указать какой-нибудь средний вес. Кот не может ничего не весить. То же касательно возраста. А вот имени может и не быть (null). То же касается адреса: null.
*/

public class Cat

{

    String name;
    Integer weight;
    Integer age;
    String color;
    String address;

    public Cat(String name)
    {
        this(name, 5);
    }

    public Cat(String name, Integer weight, Integer age)
    {
        this.name = name;
        this.weight = weight;
        this.age = age;
    }

    public Cat(String name, Integer age)
    {
        this(name, age, 5);
    }

    public Cat(Integer weight, String color)
    {
        this((String) null, (Integer) null);
        this.weight = weight;
        this.color = color;
    }

    public Cat(Integer weight, String color, String address)
    {
        this((String) null, (Integer) null);
        this.weight = weight;
        this.color = color;
        this.address = address;
    }
}
