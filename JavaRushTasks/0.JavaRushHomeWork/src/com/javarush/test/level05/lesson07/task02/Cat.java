package com.javarush.test.level05.lesson07.task02;

/* Создать класс Cat
Создать класс Cat (кот) с пятью инициализаторами:
- Имя,
- Имя, вес, возраст
- Имя, возраст (вес стандартный)
- вес, цвет, (имя, адрес и возраст неизвестны, это бездомный кот)
- вес, цвет, адрес ( чужой домашний кот)
Задача инициализатора – сделать объект валидным. Например, если вес неизвестен, то нужно указать какой-нибудь средний вес. Кот не может ничего не весить. То же касательно возраста. А вот имени может и не быть (null). То же касается адреса: null.
*/

public class Cat
{

    String name;
    Integer weight;
    Integer age;
    String color;
    String address;

    public void initialize(String name)
    {
        initialize(name, 5);
    }

    public void initialize(String name, Integer weight, Integer age)
    {
        this.name = name;
        this.weight = weight;
        this.age = age;
    }

    public void initialize(String name, Integer age)
    {
        initialize(name, age, 5);
    }

    public void initialize(Integer weight, String color)
    {
        initialize((String) null, (Integer) null);
        initialize(weight, color, null);
    }

    public void initialize(Integer weight, String color, String address)
    {
        initialize((String) null, (Integer) null);
        this.weight = weight;
        this.color = color;
        this.address = address;
    }
}
