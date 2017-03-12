package com.javarush.test.level20.lesson10.bonus01;

import java.util.Arrays;
import java.util.TreeSet;

/* Алгоритмы-числа
Число S состоит из M чисел, например, S=370 и M(количество цифр)=3
Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N (long)
находить все числа, удовлетворяющие следующему критерию:
число S равно сумме его цифр, возведенных в M степень
getNumbers должен возвращать все такие числа в порядке возрастания

Пример искомого числа:
370 = 3*3*3 + 7*7*7 + 0*0*0
8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8

На выполнение дается 10 секунд и 50 МБ памяти.
*/
public class Solution
{

    public static void main(String[] args)
    {
        long startTime = System.currentTimeMillis();
        long memoryStart = Runtime.getRuntime().freeMemory();
        System.out.println(Arrays.toString(getNumbers(Integer.MAX_VALUE)));
        long estimatedTime = System.currentTimeMillis() - startTime;
        long memoryEnd = Runtime.getRuntime().freeMemory();
        long estimatedMemory = memoryStart - memoryEnd;
        System.out.println("Время подсчета: " + (double) estimatedTime / 1000 + " c");
        System.out.println("Использованная память: " + (double) estimatedMemory / 1024 / 1024 + " МБ");
    }

    public static int[] getNumbers(int N)
    {
        int[] result = null;
        byte lengthNumber = (byte) Long.toString(N).length();
        TreeSet<Integer> resultSet = new TreeSet<>();
        for (byte i = 1; i <= lengthNumber; i++)
        {
            byte[] numbers = new byte[i];
            Arrays.fill(numbers, (byte) 0);
            while (numbers[0] != 9)
            {
                if (numbers[numbers.length - 1] == 9)
                {
                    for (byte j = (byte) (i - 1); j >= 0; j--)
                    {
                        if (numbers[j] == 9 && numbers[j - 1] != 9)
                        {
                            numbers[j - 1]++;
                            Arrays.fill(numbers, j - 1, numbers.length, numbers[j - 1]);
                            break;
                        }
                    }
                } else
                    numbers[numbers.length - 1]++;
                isArmstrong(numbers, resultSet, N);
            }
        }
        result = new int[resultSet.size()];
        int i = 0;
        for (int resultNumber : resultSet)
        {
            result[i] = resultNumber;
            i++;
        }
        return result;
    }

    public static long stepin(byte a, byte b)
    {
        long number = 1;
        for (int i = 0; i < b; i++)
        {
            number *= a;
        }
        return number;
    }

    public static void isArmstrong(byte[] numbers, TreeSet<Integer> resultSet, int N)
    {
        int numberSum = 0;
        for (int j = 0; j < numbers.length; j++)
        {
            numberSum += stepin(numbers[j], (byte) numbers.length);
        }
        if (numberSum < stepin((byte) 10, (byte) (numbers.length - 1)))
            return;
        byte[] arrayNumber = longToArray(numberSum, numbers.length);
        Arrays.sort(arrayNumber);
        if (Arrays.equals(numbers, arrayNumber) && numberSum <= N)
            resultSet.add(numberSum);
    }

    public static byte[] longToArray(int number, int length)
    {
        int numberCopy = number;
        byte[] numbers = new byte[length];
        for (int i = 0; i < numbers.length; i++)
        {
            numbers[i] = (byte) (numberCopy % 10);
            numberCopy = numberCopy / 10;
        }
        return numbers;
    }
}
