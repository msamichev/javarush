package com.javarush.task.task38.task3804;

/* 
Фабрика исключений
*/

public class Solution {
    public static Class getFactoryClass() {
        return ExceptionFactory.class;
    }

    public static void main(String[] args) {
        System.out.println(ExceptionFactory.getException(ExceptionUserMessage.USER_DOES_NOT_EXIST));
    }
}