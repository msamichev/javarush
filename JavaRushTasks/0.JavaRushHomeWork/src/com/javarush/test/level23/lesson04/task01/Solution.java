package com.javarush.test.level23.lesson04.task01;

/* Inner
Реализовать метод getTwoSolutions, который должен возвращать массив из 2-х экземпляров класса Solution.
Для каждого экземпляра класса Solution инициализировать поле innerClasses двумя значениями.
Инициализация всех данных должна происходить только в методе getTwoSolutions.
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {

        Solution[] result = new Solution[2];

        Solution solution1 = new Solution();
        Solution solution2 = new Solution();


        InnerClass inner11 = solution1.new InnerClass();
        InnerClass inner12 = solution1.new InnerClass();
        solution1.innerClasses[0] = inner11;
        solution1.innerClasses[1] = inner12;

        InnerClass inner21 = solution2.new InnerClass();
        InnerClass inner22 = solution2.new InnerClass();
        solution2.innerClasses[0] = inner21;
        solution2.innerClasses[1] = inner22;



        result[0] = solution1;
        result[1] = solution2;

        return result;
    }
}
