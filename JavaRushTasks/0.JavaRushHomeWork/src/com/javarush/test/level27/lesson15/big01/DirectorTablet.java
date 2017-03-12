package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.ad.Advertisement;
import com.javarush.test.level27.lesson15.big01.ad.StatisticAdvertisementManager;
import com.javarush.test.level27.lesson15.big01.statistic.StatisticEventManager;

import java.text.SimpleDateFormat;
import java.util.*;


public class DirectorTablet
{
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

    public void printAdvertisementProfit() {
        Map<Date, Object> advresults = StatisticEventManager.getInstance().getStatisticAdv();
        double sum = 0;
        for (Map.Entry<Date, Object> dt : advresults.entrySet()) {
            ConsoleHelper.writeMessage(String.format(Locale.ENGLISH, "%s - %.2f", simpleDateFormat.format(dt.getKey()), dt.getValue()));
            sum += (Double) dt.getValue();
        }
        ConsoleHelper.writeMessage(String.format(Locale.ENGLISH, "Total - %.2f", sum));
        //ConsoleHelper.writeMessage("");
    }
    public void printCookWorkloading() {
        Map<Date, Object> advresults = StatisticEventManager.getInstance().getStatisticCook();
        for (Map.Entry<Date, Object> dt : advresults.entrySet()) {
            ConsoleHelper.writeMessage(simpleDateFormat.format(dt.getKey()));
            HashMap<String, Integer> temp = (HashMap<String, Integer>) dt.getValue();
            List<String> list = new ArrayList<String>();
            for (Map.Entry<String, Integer> e : temp.entrySet()) list.add(e.getKey());
            Collections.sort(list);
            for (String name : list) ConsoleHelper.writeMessage(String.format(Locale.ENGLISH, "%s - %d min", name, temp.get(name)));
            ConsoleHelper.writeMessage("");
        }
    }

    public void printActiveVideoSet() {
        List<Advertisement> videoSet = StatisticAdvertisementManager.getInstance().getActiveAdvertisements();
        Collections.sort(videoSet, new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });
        for (Advertisement advertisement : videoSet) {
            ConsoleHelper.writeMessage(String.format("%s - %d",
                    advertisement.getName(),
                    advertisement.getHits()));
        }
    }

    public void printArchivedVideoSet() {
        List<Advertisement> videoSet = StatisticAdvertisementManager.getInstance().getNonActiveAdvertisements();
        Collections.sort(videoSet, new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });
        for (Advertisement advertisement : videoSet) {
            ConsoleHelper.writeMessage(advertisement.getName());
        }
    }
}