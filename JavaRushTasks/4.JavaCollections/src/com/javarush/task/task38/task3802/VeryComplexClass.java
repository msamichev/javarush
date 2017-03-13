package com.javarush.task.task38.task3802;

/* 
Проверяемые исключения (checked exception)
*/


import java.io.FileInputStream;

public class VeryComplexClass {
    public void veryComplexMethod() throws Exception {

        new FileInputStream("abcd");
    }

    public static void main(String[] args) {
        VeryComplexClass veryComplexClass  = new VeryComplexClass();
        try {
            veryComplexClass.veryComplexMethod();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
