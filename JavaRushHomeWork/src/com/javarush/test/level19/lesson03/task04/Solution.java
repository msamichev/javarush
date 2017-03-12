package com.javarush.test.level19.lesson03.task04;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.logging.SimpleFormatter;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1950

В файле хранится большое количество людей, данные одного человека находятся в одной строке. Метод read() должен читать данные одного человека.
*/

public class Solution {
    public static class PersonScannerAdapter implements PersonScanner {


        private Scanner scanner;

        public PersonScannerAdapter(Scanner scanner)
        {
            this.scanner = scanner;
        }

        @Override
        public Person read() throws IOException
        {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ddMMyyyy");
            Person p = null;
            if(scanner.hasNextLine()){
                  String[] s = scanner.nextLine().split("\\s");

                try
                {
                    p = new Person(s[1], s[2], s[0], simpleDateFormat.parse(s[3]+s[4]+s[5]));
                }
                catch (ParseException e)
                {
                    e.printStackTrace();
                }
            }
            return p;
        }

        @Override
        public void close() throws IOException
        {
            scanner.close();
        }
    }
}
