package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.Tablet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 */
public class TestOrder extends Order
{
    public TestOrder(Tablet tablet) throws IOException
    {
        super(tablet);
    }

    @Override
    protected void initDishes() throws IOException
    {
        dishes = new ArrayList<>();
        dishes.addAll(Arrays.asList(Dish.values()));
        int randDishCount = (int) (ThreadLocalRandom.current().nextDouble(1) * Dish.values().length) + 1;
        int countOfDishToDelete = dishes.size() - randDishCount;
        for (int i = 0; i < countOfDishToDelete; i++)
        {
            dishes.remove((int) (ThreadLocalRandom.current().nextDouble(1) * dishes.size()));
        }

    }
}
