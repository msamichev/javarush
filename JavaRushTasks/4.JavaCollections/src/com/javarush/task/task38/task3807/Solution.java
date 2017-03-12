package com.javarush.task.task38.task3807;

/* 
Предопределенные типы аннотаций (Predefined Annotation Types)
*/
@SuppressWarnings("deprecation")
@Deprecated
public class Solution {

    @SuppressWarnings("unused")
    @Deprecated
    private String[] arguments;

    @SafeVarargs
    @Deprecated
    public Solution(String... arguments) {
        this.arguments = arguments;
    }

    @Deprecated
    public void voidMethod() throws Exception {
    }

    @Deprecated
    public static void main(String[] args) throws Exception {
        new Solution().new SubSolution().voidMethod();
    }

    @Deprecated
    class SubSolution extends Solution {

        @Override
        @Deprecated
        public void voidMethod() throws Exception {
            super.voidMethod();
        }
    }
}
