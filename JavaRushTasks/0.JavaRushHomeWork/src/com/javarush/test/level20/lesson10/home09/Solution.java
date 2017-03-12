package com.javarush.test.level20.lesson10.home09;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/* Знакомство с графами
Прочитать в дополнительных материалах о сериализации графов.
Дан ориентированный плоский граф Solution, содержащий циклы и петли.
Пример, http://edu.nstu.ru/courses/saod/images/graph1.gif
Сериализовать Solution.
Все данные должны сохранить порядок следования.
*/
public class Solution implements Serializable{
    int node;
    List<Solution> edges = new LinkedList<>();

    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        Solution solution1 = new Solution();
        solution1.node = 1;

        Solution solution2 = new Solution();
        solution2.node = 2;

        Solution solution3 = new Solution();
        solution3.node = 3;

        Solution solution4 = new Solution();
        solution4.node = 4;

        Solution solution5 = new Solution();
        solution5.node = 5;

        Solution solution6 = new Solution();
        solution6.node = 6;

        solution6.edges.add(solution3);
        solution1.edges.add(solution2);
        solution2.edges.add(solution2);
        solution2.edges.add(solution4);
        solution2.edges.add(solution5);
        solution5.edges.add(solution4);
        solution4.edges.add(solution5);
        solution4.edges.add(solution1);

       System.out.println(solution2);


        File file = new File("c:/temp/file1.txt");

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));

        out.writeObject(solution2);

        out.close();


        ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));

        Solution loadSolution = (Solution) in.readObject();
        in.close();


    }

}
