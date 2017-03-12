package com.javarush.test.level14.lesson08.home05;

/**
 *
 */
public class Computer
{
    Keyboard keyboard;
    Mouse mouse;
    Monitor monitor;


    public Computer()
    {
        this.keyboard = new Keyboard();
        this.monitor = new Monitor();
        this.mouse = new Mouse();
    }

    public Keyboard getKeyboard()
    {
        return keyboard;
    }

    public Mouse getMouse()
    {
        return mouse;
    }

    public Monitor getMonitor()
    {
        return monitor;
    }
}
