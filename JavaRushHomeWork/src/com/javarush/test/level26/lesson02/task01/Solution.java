package com.javarush.test.level26.lesson02.task01;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* Почитать в инете про медиану выборки
Реализовать логику метода sort, который должен сортировать данные в массиве по удаленности от его медианы
Вернуть отсортированный массив от минимального расстояния до максимального
Если удаленность одинаковая у нескольких чисел, то выводить их в порядке возрастания
*/
public class Solution
{
//    public static void main(String[] args)
//    {
//        Integer[] test = new Integer[]{1, 5, 11, 8, 1, 20, 33, 9};
//        for (Integer integer : sort(test))
//        {
//            System.out.println(integer);
//        }
//
//    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here
        final double mediana;
        Arrays.sort(array);
//        for (Integer integer : array)
//        {
//            System.out.println(integer);
//        }
//        System.out.println("---------------------");

        if(array.length%2==0){
            mediana = (double)((array[array.length/2 - 1] + array[array.length/2]))/2;
        } else mediana = array[array.length/2];
        Arrays.sort(array, new Comparator<Integer>()
        {
            @Override
            public int compare(Integer o1, Integer o2)
            {
                double result = Math.abs(o1 - mediana) - Math.abs(o2 - mediana);
                if(result==0)
                    return o1.compareTo(o2);
                return (int)result;
            }
        });
        return array;
    }

}
