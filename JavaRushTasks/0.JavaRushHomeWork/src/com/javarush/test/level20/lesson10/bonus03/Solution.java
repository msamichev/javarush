package com.javarush.test.level20.lesson10.bonus03;

import java.util.ArrayList;
import java.util.List;

/* Кроссворд
1. Дан двумерный массив, который содержит буквы английского алфавита в нижнем регистре.
2. Метод detectAllWords должен найти все слова из words в массиве crossword.
3. Элемент(startX, startY) должен соответствовать первой букве слова, элемент(endX, endY) - последней.
text - это само слово, располагается между начальным и конечным элементами
4. Все слова есть в массиве.
5. Слова могут быть расположены горизонтально, вертикально и по диагонали как в нормальном, так и в обратном порядке.
6. Метод main не участвует в тестировании
*/
public class Solution
{
    public static void main(String[] args)
    {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        System.out.println(detectAllWords(crossword, "home", "same", "erl", "pre", "oor", "mrr"));

        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words)
    {

        List<Word> allWorld = parseCrossword(crossword);
        List<Word> result = new ArrayList<>();


        for (String word : words)
        {
            for (Word crWord : allWorld)
            {
                if (crWord.text.contains(word))
                {

                    int x = crWord.startX - crWord.endX;
                    int y = crWord.startY - crWord.endY;

                    int iStart = crWord.text.indexOf(word);

                    Word newWord = new Word(word);

                    int startX;
                    int startY;
                    int endX;
                    int endY;
                    if (x < 0)
                    {
                        startX = crWord.startX + iStart;
                        endX = startX + word.length() - 1;
                    } else if (x > 0)
                    {
                        startX = crWord.startX - iStart;
                        endX = startX - word.length() + 1;
                    } else
                    {
                        startX = crWord.startX;
                        endX = crWord.startX;
                    }
                    if (y < 0)
                    {
                        startY = crWord.startY + iStart;
                        endY = startY + word.length() - 1;
                    } else if (y > 0)
                    {
                        startY = crWord.startY - iStart;
                        endY = startY - word.length() + 1;
                    } else
                    {
                        startY = crWord.startY;
                        endY = crWord.startY;
                    }

                    newWord.setStartPoint(startX, startY);
                    newWord.setEndPoint(endX, endY);
                    result.add(newWord);
                    //System.out.println(newWord);
                    //System.out.println("FIND - " + word + " in " + crWord);
                    break;
                }
            }
        }

        return result;
    }

    private static List<Word> parseCrossword(int[][] crossword)
    {

        List<Word> allWorld = new ArrayList<>();
        int x = 0;
        int y = 0;
//        System.out.println("1------------------");
        for (int i = 0; i < crossword.length; i++)
        {
            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < crossword[i].length; j++)
            {
//                System.out.print((char) crossword[i][j]);
                sb.append((char) crossword[i][j]);
                x = j;
                y = i;
            }
//            System.out.println();
            Word word = new Word(sb.toString());
            word.setStartPoint(0, y);
            word.setEndPoint(x, y);
            allWorld.add(word);
            Word wordRevers = new Word(sb.reverse().toString());
            wordRevers.setEndPoint(0, y);
            wordRevers.setStartPoint(x, y);
            allWorld.add(wordRevers);
        }
//        System.out.println("2------------------");
        for (int i = 0; i < crossword[0].length; i++)
        {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < crossword.length; j++)
            {
//                System.out.print((char) crossword[j][i]);
                sb.append((char) crossword[j][i]);
                x = i;
                y = j;
            }
//            System.out.println();
            Word word = new Word(sb.toString());
            word.setStartPoint(x, 0);
            word.setEndPoint(x, y);
            allWorld.add(word);
            Word wordRevers = new Word(sb.reverse().toString());
            wordRevers.setEndPoint(x, 0);
            wordRevers.setStartPoint(x, y);
            allWorld.add(wordRevers);

        }
//        System.out.println("3-----------------");
        for (int i = 0; i < crossword[0].length; i++)
        {
            StringBuilder sb = new StringBuilder();
            for (int j = 0, k = i; j < crossword.length && k < crossword[0].length; j++, k++)
            {
//                System.out.print((char) crossword[j][k]);
                sb.append((char) crossword[j][k]);
                x = k;
                y = j;
            }
//            System.out.println();
            Word word = new Word(sb.toString());
            word.setStartPoint(i, 0);
            word.setEndPoint(x, y);
            allWorld.add(word);
            Word wordRevers = new Word(sb.reverse().toString());
            wordRevers.setEndPoint(i, 0);
            wordRevers.setStartPoint(x, y);
            allWorld.add(wordRevers);
        }

//        System.out.println("4------------------");
        for (int i = 1; i < crossword.length; i++)
        {
            StringBuilder sb = new StringBuilder();
            for (int j = 0, k = i; j < crossword[0].length && k < crossword.length; j++, k++)
            {
//                System.out.print((char) crossword[k][j]);
                sb.append((char) crossword[k][j]);
                x = j;
                y = k;
            }
//            System.out.println();
            Word word = new Word(sb.toString());
            word.setStartPoint(0, i);
            word.setEndPoint(x, y);
            allWorld.add(word);
            Word wordRevers = new Word(sb.reverse().toString());
            wordRevers.setEndPoint(0, i);
            wordRevers.setStartPoint(x, y);
            allWorld.add(wordRevers);
        }

//        System.out.println("5-----------------");
        for (int i = crossword[0].length - 1; i >= 0; i--)
        {
            StringBuilder sb = new StringBuilder();
            for (int j = 0, k = i; j < crossword.length && k >= 0; j++, k--)
            {
//                System.out.print((char) crossword[j][k]);
                sb.append((char) crossword[j][k]);
                x = k;
                y = j;
            }
//            System.out.println();
            Word word = new Word(sb.toString());
            word.setStartPoint(i, 0);
            word.setEndPoint(x, y);
            allWorld.add(word);
            Word wordRevers = new Word(sb.reverse().toString());
            wordRevers.setEndPoint(i, 0);
            wordRevers.setStartPoint(x, y);
            allWorld.add(wordRevers);
        }

//        System.out.println("6-----------------");
        for (int i = 1; i < crossword.length; i++)
        {
            StringBuilder sb = new StringBuilder();
            for (int j = crossword[0].length - 1, k = i; j >= 0 && k < crossword.length; j--, k++)
            {
//                System.out.print((char) crossword[k][j]);
                sb.append((char) crossword[k][j]);
                x = j;
                y = k;
            }
//            System.out.println();
            Word word = new Word(sb.toString());
            word.setStartPoint(crossword[0].length - 1, i);
            word.setEndPoint(x, y);
            allWorld.add(word);
            Word wordRevers = new Word(sb.reverse().toString());
            wordRevers.setEndPoint(crossword[0].length - 1, i);
            wordRevers.setStartPoint(x, y);
            allWorld.add(wordRevers);
        }

//        System.out.println(allWorld);
        return allWorld;
    }

    public static class Word
    {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text)
        {
            this.text = text;
        }

        public void setStartPoint(int i, int j)
        {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j)
        {
            endX = i;
            endY = j;
        }

        @Override
        public String toString()
        {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
