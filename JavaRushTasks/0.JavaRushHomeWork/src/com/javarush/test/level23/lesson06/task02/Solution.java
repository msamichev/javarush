package com.javarush.test.level23.lesson06.task02;

/* Рефакторинг
Отрефакторите класс Solution: вынесите все константы в public вложенный(nested) класс Constants.
Запретите наследоваться от Constants.
*/
public class Solution {

    public class ServerNotAccessibleException extends Exception {
        public ServerNotAccessibleException() {
            super(Constants.CONST1);
        }

        public ServerNotAccessibleException(Throwable cause) {
            super(Constants.CONST1, cause);
        }
    }

    public class UnauthorizedUserException extends Exception {
        public UnauthorizedUserException() {
            super(Constants.CONST2);
        }

        public UnauthorizedUserException(Throwable cause) {
            super(Constants.CONST2, cause);
        }
    }

    public class BannedUserException extends Exception {
        public BannedUserException() {
            super(Constants.CONST3);
        }

        public BannedUserException(Throwable cause) {
            super(Constants.CONST3, cause);
        }
    }

    public class RestrictionException extends Exception {
        public RestrictionException() {
            super(Constants.CONST4);
        }

        public RestrictionException(Throwable cause) {
            super(Constants.CONST4, cause);
        }
    }

    public static final class Constants{
        public static final String CONST1 = "Server is not accessible for now.";
        public static final String CONST2 = "User is not authorized.";
        public static final String CONST3 = "User is banned.";
        public static final String CONST4 = "Access is denied.";
    }
}
