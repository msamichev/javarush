package com.javarush.test.level31.lesson02.home01;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* Проход по дереву файлов
1. На вход метода main подаются два параметра.
Первый - path - путь к директории, второй - resultFileAbsolutePath - имя файла, который будет содержать результат.
2. Для каждого файла в директории path и в ее всех вложенных поддиректориях выполнить следующее:
2.1. Если у файла длина в байтах больше 50, то удалить его.
2.2. Если у файла длина в байтах НЕ больше 50, то для всех таких файлов:
2.2.1. отсортировать их по имени файла в возрастающем порядке, путь не учитывать при сортировке
2.2.2. переименовать resultFileAbsolutePath в 'allFilesContent.txt'
2.2.3. в allFilesContent.txt последовательно записать содержимое всех файлов из п. 2.2.1. Тела файлов разделять "\n"
2.3. Удалить директории без файлов (пустые).
Все файлы имеют расширение txt.
*/
public class Solution
{

    private static List<File> files = new ArrayList();


    public static void main(String[] args)
    {
        if (args == null || args.length < 2)
        {
            System.exit(0);
        }

        String path = args[0];
        String resultFileAbsolutePath = args[1];

        readAllFiles(new File(path));

        Collections.sort(files, new Comparator<File>()
        {
            @Override
            public int compare(File o1, File o2)
            {
                return o1.getName().compareTo(o2.getName());
            }
        });


        File resultFile = new File(resultFileAbsolutePath);

        try (FileWriter output = new FileWriter(resultFile)) {
            for (File file : files) {
                FileReader input = new FileReader(file);
                while (input.ready()) {
                    char[] buf = new char[1024];
                    int count = input.read(buf);
                    output.write(buf, 0, count);
                    output.write("\r\n");
                }
                input.close();
            }
        } catch (IOException e) {}



        File newResultFile = new File(resultFile.getParent() + "/allFilesContent.txt");
        resultFile.renameTo(newResultFile);

    }


    public static void readAllFiles(File dir)
    {
        if (!dir.exists()) return;

        File[] fileList = dir.listFiles();
        if (fileList.length == 0) dir.delete();

        for (File file : fileList)
        {
            if (file.isDirectory())
            {
                readAllFiles(file);
            } else
            {
                if (file.length() > 50)
                {
                    file.delete();
                } else
                {
                    files.add(file);
                }
            }
        }
    }
}
