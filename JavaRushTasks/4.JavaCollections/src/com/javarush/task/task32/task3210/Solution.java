package com.javarush.task.task32.task3210;

/*
Используем RandomAccessFile
*/

import java.io.IOException;
import java.io.RandomAccessFile;

public class Solution {
    public static void main(String... args) throws IOException {

        String fileName = args[0];
        int number = Integer.parseInt(args[1]);
        String text = args[2];

        try (RandomAccessFile raf = new RandomAccessFile(fileName, "rw")) {
            raf.seek(number);

            byte[] bytes = new byte[text.length()];
            raf.read(bytes, 0, text.length());

            raf.seek(raf.length());

            if (convertByteToString(bytes).equals(text)) {
                raf.write("true".getBytes());
            } else {
                raf.write("false".getBytes());
            }
        }

    }

    private static String convertByteToString(byte[] readBytes) {
        return new String(readBytes);
    }

}
