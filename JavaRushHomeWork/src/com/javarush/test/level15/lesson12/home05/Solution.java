package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution.
*/

public class Solution
{
    private Solution(int i)
    {
    }

    private Solution(int i, int j)
    {
    }

    private Solution(int i, int j, int b)
    {
    }


    protected Solution(String s)
    {
    }

    protected Solution(String s, String s1, String s2)
    {
    }

    protected Solution(String s, String s1)
    {
    }

    public Solution(Object o, int i, int j)
    {
    }

    public Solution(Object o, int i)
    {
    }

    public Solution()
    {
    }


    Solution(Object o, String i, String a)
    {

    }

    Solution(Object o, String i)
    {

    }

    Solution(Object o, String i, int a)
    {

    }
}

