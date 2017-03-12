package com.javarush.task.task33.task3308;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 */
@XmlRootElement
@XmlType(name = "shop")
public class Shop {

    public Goods goods;
    public String[] secretData;
    public  int count;
    public double profit;

    @Override
    public String toString() {
        return "Shop{" +
                "goods=" + goods +
                ", secretData=" + Arrays.toString(secretData) +
                ", count=" + count +
                ", profit=" + profit +
                '}';
    }

    public static class Goods{

        public List<String> names = new ArrayList<>();

        @Override
        public String toString() {
            return "Goods{" +
                    "names=" + names +
                    '}';
        }
    }
}
