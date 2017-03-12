package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.Tablet;

import java.io.IOException;
import java.util.List;

/**
 *
 */
public class Order
{
    protected List<Dish> dishes;
    private Tablet tablet;

    public Order(Tablet tablet) throws IOException
    {
        this.tablet = tablet;
        initDishes();
    }

    protected void initDishes() throws IOException
    {
        ConsoleHelper.writeMessage(Dish.allDishesToString());
        dishes = ConsoleHelper.getAllDishesForOrder();
    }


    @Override
    public String toString()
    {
        if (dishes.isEmpty())
            return "";
        else return "Your order: " + dishes + " of " + tablet;
    }

    public int getTotalCookingTime()
    {
        int total = 0;
        for (Dish dish : dishes)
        {
            total += dish.getDuration();
        }
        return total;
    }

    public Tablet getTablet()
    {
        return tablet;
    }

    public List<Dish> getDishes()
    {
        return dishes;
    }

    public boolean isEmpty()
    {
        return dishes.isEmpty();
    }

}
