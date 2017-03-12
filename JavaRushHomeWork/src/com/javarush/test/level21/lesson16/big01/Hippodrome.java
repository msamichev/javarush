package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

/**
 *
 */
public class Hippodrome
{
    public static Hippodrome game;

    private ArrayList<Horse> horses = new ArrayList<Horse>();

    public static void main(String[] args) throws InterruptedException
    {
        game = new Hippodrome();

        Horse h1 = new Horse("racer1", 3, 0);
        Horse h2 = new Horse("racer2", 3, 0);
        Horse h3 = new Horse("racer3", 3, 0);

        game.getHorses().add(h1);
        game.getHorses().add(h2);
        game.getHorses().add(h3);

        game.run();
        game.printWinner();

    }

    public Horse getWinner()
    {
        Horse winner = null;
        for (Horse horse : horses)
        {
            if (winner != null)
            {
                if (winner.getDistance() < horse.getDistance())
                {
                    winner = horse;
                }
            } else
            {
                winner = horse;
            }
        }
        return winner;

    }

    public void printWinner()
    {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

    public void run() throws InterruptedException
    {

        for (int i = 1; i <= 100; i++)
        {
            move();
            print();
            Thread.sleep(200);
        }

    }

    public void move()
    {
        for (Horse horse : horses)
        {
            horse.move();
        }
    }

    public void print()
    {
        for (Horse horse : horses)
        {
            horse.print();
        }
        System.out.println();
        System.out.println();
    }


    public ArrayList<Horse> getHorses()
    {
        return horses;
    }


}
