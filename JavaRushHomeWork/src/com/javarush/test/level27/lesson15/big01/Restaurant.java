package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
import com.javarush.test.level27.lesson15.big01.kitchen.Order;
import com.javarush.test.level27.lesson15.big01.kitchen.Waitor;
import com.javarush.test.level27.lesson15.big01.statistic.StatisticEventManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.LinkedBlockingQueue;

/**
 *
 */
public class Restaurant
{
    private static final int ORDER_CREATING_INTERVAL = 100;

    private static final LinkedBlockingQueue<Order> QUEUE = new LinkedBlockingQueue<>();

    public static void main(String[] args)
    {

        Locale.setDefault(Locale.ENGLISH);
        Cook cook = new Cook("Amigo");
        cook.setQueue(QUEUE);
        Cook cook1 = new Cook("Bender");
        cook1.setQueue(QUEUE);

        Thread cook1Thread=new Thread(cook);
        cook1Thread.start();
        Thread cook2Thread=new Thread(cook1);
        cook2Thread.start();

        Waitor waitor = new Waitor();
        cook.addObserver(waitor);
        cook1.addObserver(waitor);
        List<Tablet> tablets = new ArrayList<>();
        for (int i = 0; i < 5; i++)
        {
            Tablet t = new Tablet(i);
            t.setQueue(QUEUE);
            tablets.add(t);
        }
        Thread thread = new Thread(new RandomOrderGeneratorTask(tablets, ORDER_CREATING_INTERVAL));
        thread.start();
        try
        {
            Thread.sleep(1000);
        }
        catch (InterruptedException e)
        {
        }

        thread.interrupt();
        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkloading();
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();

    }
}
