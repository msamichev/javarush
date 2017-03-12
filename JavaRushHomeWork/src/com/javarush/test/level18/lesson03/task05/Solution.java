package com.javarush.test.level18.lesson03.task05;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.*;




/* Сортировка байт
Ввести с консоли имя файла
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран
Закрыть поток ввода-вывода

Пример байт входного файла
44 83 44

Пример вывода
44 83
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        Set<Integer> set = new HashSet();

        Scanner scanner = new Scanner(System.in);

        File file = new File(scanner.next());
        while (!file.exists())
        {
            //System.out.println("File does not exist!");
            file = new File(scanner.next());
        }
        scanner.close();

        BufferedInputStream reader = new BufferedInputStream(new FileInputStream(file));


        while (reader.available() > 0)
        {

            set.add(reader.read());

        }

        reader.close();

        Integer[] arr = set.toArray(new Integer[1]);
        Arrays.sort(arr);

        for (Integer integer : arr)
        {
            System.out.print(integer + " ");
        }

    }
}
