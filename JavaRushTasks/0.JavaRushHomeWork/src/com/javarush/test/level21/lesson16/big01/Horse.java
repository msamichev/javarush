package com.javarush.test.level21.lesson16.big01;

/**
 *
 */
public class Horse
{
    private String name;
    private double speed;
    private double distance;

    public Horse(String name, double speed, double distance)
    {
        this.name = name;
        this.speed = speed;
        this.distance = distance;
    }


    public void move(){
        distance += speed * Math.random();
    }
    public void print(){
        String format  = "%"+ ((int)distance + name.length())+ "s";

        String s = String.format(format, name).replaceAll(" ", ".");
        System.out.println(s);
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public double getSpeed()
    {
        return speed;
    }

    public void setSpeed(double speed)
    {
        this.speed = speed;
    }

    public double getDistance()
    {
        return distance;
    }

    public void setDistance(double distance)
    {
        this.distance = distance;
    }
}
