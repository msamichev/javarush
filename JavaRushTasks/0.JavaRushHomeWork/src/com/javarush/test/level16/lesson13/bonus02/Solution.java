package com.javarush.test.level16.lesson13.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Клубок
1. Создай 5 различных своих нитей c отличным от Thread типом:
1.1. нить 1 должна бесконечно выполняться;
1.2. нить 2 должна выводить "InterruptedException" при возникновении исключения InterruptedException;
1.3. нить 3 должна каждые полсекунды выводить "Ура";
1.4. нить 4 должна реализовать интерфейс Message, при вызове метода showWarning нить должна останавливаться;
1.5. нить 5 должна читать с консоли цифры пока не введено слово "N", а потом вывести в консоль сумму введенных цифр.
2. В статическом блоке добавь свои нити в List<Thread> threads в перечисленном порядке.
3. Нити не должны стартовать автоматически.
Подсказка: Нить 4 можно проверить методом isAlive()
*/

public class Solution
{
    public static List<Thread> threads = new ArrayList<Thread>(5);

    static
    {
        threads.add(new ThreadLine1());
        threads.add(new ThreadLine2());
        threads.add(new ThreadLine3());
        threads.add(new ThreadLine4());
        threads.add(new ThreadLine5());

    }

    public static class ThreadLine1 extends Thread
    {
        @Override
        public void run()
        {
            while (true) ;
        }
    }

    public static class ThreadLine2 extends Thread
    {
        @Override
        public void run()
        {
            try
            {
                while (true)
                {
                    sleep(1);
                }
            }
            catch (InterruptedException e)
            {
                System.out.println("InterruptedException");
            }
        }
    }

    public static class ThreadLine3 extends Thread
    {
        @Override
        public void run()
        {
            while (true)
            {
                try
                {
                    sleep(500);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                System.out.println("Ура");
            }
        }
    }

    public static class ThreadLine4 extends Thread implements Message
    {

        @Override
        public void run()
        {
            try
            {
                while (true)
                {
                    sleep(1);
                }

            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }

        @Override
        public void showWarning()
        {
            this.interrupt();
            try
            {
                this.join();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }

    public static class ThreadLine5 extends Thread
    {
        @Override
        public void run()
        {
            int cout = 0;
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try
            {


                while (true)
                {

                    String str = reader.readLine();
                    if ("N".equalsIgnoreCase(str))
                    {
                        break;
                    }

                    cout += Integer.parseInt(str);
                }

                reader.close();

                System.out.println(cout);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

}


