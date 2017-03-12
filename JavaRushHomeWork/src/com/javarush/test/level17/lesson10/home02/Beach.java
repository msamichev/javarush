package com.javarush.test.level17.lesson10.home02;

/* Comparable
Реализуйте интерфейс Comparable<Beach> в классе Beach, который будет использоваться нитями.
*/

public class Beach implements Comparable<Beach>
{

    private volatile String name;      //название
    private volatile float distance;   //расстояние
    private volatile int quality;    //качество

    public Beach(String name, float distance, int quality)
    {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public synchronized String getName()
    {
        return name;
    }

    public synchronized void setName(String name)
    {
        this.name = name;
    }

    public synchronized float getDistance()
    {
        return distance;
    }

    public synchronized void setDistance(float distance)
    {
        this.distance = distance;
    }

    public synchronized int getQuality()
    {
        return quality;
    }

    public synchronized void setQuality(int quality)
    {
        this.quality = quality;
    }

    @Override
    public synchronized int compareTo(Beach obj)
    {
        int distIndex = (int) (getDistance() - obj.getDistance());
        int qualIndex = getQuality() - obj.getQuality();
        return 10000 * name.compareTo(obj.getName()) + 100 * distIndex + qualIndex;
    }
}
