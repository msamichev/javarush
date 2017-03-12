package com.javarush.task.task38.task3804;

/**
 *
 */
public class ExceptionFactory {

    private ExceptionFactory() {
    }

    public static Throwable getException(Enum e) {
        Throwable res;
        if (e instanceof ExceptionApplicationMessage) {
            res = new Exception(e.name().substring(0, 1).toUpperCase() + e.name().substring(1).replace("_", " ").toLowerCase());
        } else if (e instanceof ExceptionDBMessage) {
            res = new RuntimeException(e.name().substring(0, 1).toUpperCase() + e.name().substring(1).replace("_", " ").toLowerCase());
        } else if (e instanceof ExceptionUserMessage) {
            res = new Error(e.name().substring(0, 1).toUpperCase() + e.name().substring(1).replace("_", " ").toLowerCase());
        } else {
            res = new IllegalArgumentException();
        }

        return res;
    }

}
