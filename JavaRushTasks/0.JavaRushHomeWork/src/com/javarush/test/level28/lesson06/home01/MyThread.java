package com.javarush.test.level28.lesson06.home01;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 */
public class MyThread extends Thread
{
    private static AtomicInteger priority = new AtomicInteger(1);

    public MyThread()
    {
        setPriority(getCustPriority());
    }

    public MyThread(Runnable target)
    {
        super(target);
        setPriority(getCustPriority());
    }

    public MyThread(ThreadGroup group, Runnable target)
    {
        super(group, target);
        int pr = getCustPriority();
        int maxPr = group.getMaxPriority();
        setPriority(pr > maxPr ? maxPr : pr);
    }

    public MyThread(String name)
    {
        super(name);
        setPriority(getCustPriority());
    }

    public MyThread(ThreadGroup group, String name)
    {
        super(group, name);
        int pr = getCustPriority();
        int maxPr = group.getMaxPriority();
        setPriority(pr > maxPr ? maxPr : pr);
    }

    public MyThread(Runnable target, String name)
    {
        super(target, name);
        setPriority(getCustPriority());
    }

    public MyThread(ThreadGroup group, Runnable target, String name)
    {
        super(group, target, name);
        int pr = getCustPriority();
        int maxPr = group.getMaxPriority();
        setPriority(pr > maxPr ? maxPr : pr);
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize)
    {
        super(group, target, name, stackSize);
        int pr = getCustPriority();
        int maxPr = group.getMaxPriority();
        setPriority(pr > maxPr ? maxPr : pr);
    }

    private int getCustPriority()
    {
        int res = priority.getAndIncrement();
        priority.compareAndSet(Thread.MAX_PRIORITY + 1, Thread.MIN_PRIORITY);
        return res;
    }
}
