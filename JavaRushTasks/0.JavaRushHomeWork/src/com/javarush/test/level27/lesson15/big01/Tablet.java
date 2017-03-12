package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.ad.AdvertisementManager;
import com.javarush.test.level27.lesson15.big01.ad.NoVideoAvailableException;
import com.javarush.test.level27.lesson15.big01.kitchen.Order;
import com.javarush.test.level27.lesson15.big01.kitchen.TestOrder;

import java.io.IOException;
import java.util.Observable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 */
public class Tablet
{
    public static Logger logger = Logger.getLogger(Tablet.class.getName());
    public final int number;
    private LinkedBlockingQueue<Order> queue;

    public Tablet(int number)
    {
        this.number = number;
    }

    public void createOrder()
    {
        try
        {
            final Order order = new Order(this);
            createInsideOrder(order);
        }
        catch (IOException e)
        {
            logger.log(Level.SEVERE, "Console is unavailable.");
        }
    }

    public void createTestOrder() {
        try {
            final Order order = new TestOrder(this);
            createInsideOrder(order);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
        }
    }

    private void createInsideOrder(Order order)
    {
        ConsoleHelper.writeMessage(order.toString());
        if (!order.isEmpty())
        {
            try {
                queue.put(order);
            } catch (InterruptedException ignored) {
            }
            try
            {
                AdvertisementManager advertisementManager = new AdvertisementManager(order.getTotalCookingTime() * 60);
                advertisementManager.processVideos();
            }
            catch (NoVideoAvailableException e){
                logger.log(Level.INFO, "No video is available for the order " + order);
            }
        }
    }

    public void setQueue(LinkedBlockingQueue<Order> queue)
    {
        this.queue = queue;
    }

    @Override
    public String toString()
    {
        return "Tablet{number=" + number + "}";
    }
}
