package com.javarush.test.level30.lesson04.home01;

import java.util.concurrent.TransferQueue;

/**
 *
 */
public class Producer implements Runnable
{
    private TransferQueue<ShareItem> queue;

    public Producer(TransferQueue<ShareItem> queue)
    {
        this.queue = queue;
    }

    @Override
    public void run()
    {
        try
        {
            for (int i = 1; i < 10 && !Thread.currentThread().isInterrupted(); i++)
            {
                ShareItem shareItem = new ShareItem("ShareItem-" + i, i);
                System.out.format("Элемент '%s' добавлен\n", shareItem.getDescription());
                queue.offer(shareItem);


                Thread.currentThread().sleep(100);

                if(queue.hasWaitingConsumer()) System.out.println("Consumer в ожидании!");
            }
        }
        catch (InterruptedException e)
        {
            //e.printStackTrace();
        }
    }
}

