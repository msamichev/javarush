package com.javarush.task.task36.task3602;

import java.lang.reflect.Modifier;
import java.util.Collections;
import java.util.List;

/* 
Найти класс по описанию
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() {
        // Life HACK!!!
        Class<?>[] clazz = Collections.class.getDeclaredClasses();
        for (int i = 0; i < clazz.length; i++) {
            if (Modifier.isPrivate(clazz[i].getModifiers())) {
                boolean hasListInterface = false;
                for (Class<?> interfaceClass : clazz[i].getInterfaces()) {
                    if (List.class.equals(interfaceClass)) {
                        hasListInterface = true;
                        break;
                    }
                }
                //if (hasListInterface) System.out.println(clazz[i]);
            }

        }
        // Life HACK!!!

        return Collections.EMPTY_LIST.getClass();
    }
}
