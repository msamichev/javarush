package com.javarush.test.level03.lesson04.task03;

/* StarCraft
Создать 10 зергов, 5 протосов и 12 терран.
Дать им всем уникальные имена.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Zerg z1 = new Zerg();
        Zerg z2 = new Zerg();
        Zerg z3 = new Zerg();
        Zerg z4 = new Zerg();
        Zerg z5 = new Zerg();
        Zerg z6 = new Zerg();
        Zerg z7 = new Zerg();
        Zerg z8 = new Zerg();
        Zerg z9 = new Zerg();
        Zerg z10 = new Zerg();
        z1.name = "z1";
        z2.name = "z2";
        z3.name = "z3";
        z4.name = "z4";
        z5.name = "z5";
        z6.name = "z6";
        z7.name = "z7";
        z8.name = "z8";
        z9.name = "z9";
        z10.name = "z10";

        Protos p1 = new Protos();
        Protos p2 = new Protos();
        Protos p3 = new Protos();
        Protos p4 = new Protos();
        Protos p5 = new Protos();
        p1.name = "p1";
        p2.name = "p2";
        p3.name = "p3";
        p4.name = "p4";
        p5.name = "p5";

        Terran t1 = new Terran();
        Terran t2 = new Terran();
        Terran t3 = new Terran();
        Terran t4 = new Terran();
        Terran t5 = new Terran();
        Terran t6 = new Terran();
        Terran t7 = new Terran();
        Terran t8 = new Terran();
        Terran t9 = new Terran();
        Terran t10 = new Terran();
        Terran t11 = new Terran();
        Terran t12 = new Terran();

        t1.name = "t1";
        t2.name = "t2";
        t3.name = "t3";
        t4.name = "t4";
        t5.name = "t5";
        t6.name = "t6";
        t7.name = "t7";
        t8.name = "t8";
        t9.name = "t9";
        t10.name = "t10";
        t11.name = "t11";
        t12.name = "t12";


        //напишите тут ваш код

    }

    public static class Zerg
    {
        public String name;
    }

    public static class Protos
    {
        public String name;
    }

    public static class Terran
    {
        public String name;
    }
}