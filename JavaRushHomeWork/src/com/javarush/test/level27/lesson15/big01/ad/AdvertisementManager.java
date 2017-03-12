package com.javarush.test.level27.lesson15.big01.ad;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.statistic.StatisticEventManager;
import com.javarush.test.level27.lesson15.big01.statistic.event.VideoSelectedEventDataRow;

import java.util.*;

/**
 *
 */
public class AdvertisementManager
{
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();

    private int timeSeconds;

    public AdvertisementManager(int timeSeconds)
    {
        this.timeSeconds = timeSeconds;
    }

    private Set<List<Advertisement>> myPowerSet(List<Advertisement> list)
    {
        Set<List<Advertisement>> set = new HashSet();


        if (!list.isEmpty())
            set.add(list);

        for (Advertisement ad : list)
        {
            List<Advertisement> subList = new ArrayList<>(list);
            subList.remove(ad);
            set.addAll(myPowerSet(subList));
        }

        return set;
    }

    public void processVideos()
    {
        List<List<Advertisement>> powerSet = new ArrayList<>(myPowerSet(storage.list()));
        Iterator iterator = powerSet.iterator();
        while (iterator.hasNext())
        {
            List<Advertisement> list = (List<Advertisement>) iterator.next();
            int time = 0;
            boolean hasHits = true;
            for (Advertisement ad : list)
            {
                time += ad.getDuration();
                if (ad.getHits() <= 0)
                    hasHits = false;
            }

            if (time > timeSeconds || !hasHits)
                iterator.remove();
        }

        Collections.sort(powerSet, new Comparator<List<Advertisement>>()
        {
            @Override
            public int compare(List<Advertisement> list1, List<Advertisement> list2)
            {
                long money1 = 0;
                long money2 = 0;
                int time1 = 0;
                int time2 = 0;
                int qty1 = list1.size();
                int qty2 = list2.size();
                for (Advertisement ad : list1)
                {
                    money1 += ad.getAmountPerOneDisplaying();
                    time1 += ad.getDuration();
                }
                for (Advertisement ad : list2)
                {
                    money2 += ad.getAmountPerOneDisplaying();
                    time2 += ad.getDuration();
                }
                if (money2 - money1 != 0)
                    return (int) (money2 - money1);
                if (time2 - time1 != 0)
                    return time2 - time1;
                else
                    return qty1 - qty2;
            }
        });

        if (powerSet.isEmpty()) throw new NoVideoAvailableException();


        List<Advertisement> videos = powerSet.get(0);
        if (videos.isEmpty()) throw new NoVideoAvailableException();

        Collections.sort(videos, new Comparator<Advertisement>()
        {
            @Override
            public int compare(Advertisement o1, Advertisement o2)
            {
                long result = o2.getAmountPerOneDisplaying() - o1.getAmountPerOneDisplaying();
                if (result != 0)
                {
                    return (int) result;
                } else
                {
                    return (int) (o1.getAmountPerOneDisplaying() * 1000 / o1.getDuration() - o2.getAmountPerOneDisplaying() * 1000 / o2.getDuration());
                }
            }
        });

        long sumAmount = 0;
        int sumDuration = 0;
        for(Advertisement a : videos){
            sumAmount += a.getAmountPerOneDisplaying();
            sumDuration += a.getDuration();
        }

        StatisticEventManager.getInstance().register(
                new VideoSelectedEventDataRow(
                        videos,
                        sumAmount,
                        sumDuration
                )
        );

        int countedTime = 0;
        for (Advertisement vid : videos)
        {
            if (vid.getHits() <= 0 || vid.getDuration() > timeSeconds) continue;
            countedTime += vid.getDuration();
            ConsoleHelper.writeMessage(vid.getName() + " is displaying... " + vid.getAmountPerOneDisplaying() + ", " + vid.getAmountPerOneDisplaying() * 1000 / vid.getDuration());
            vid.revalidate();
            if (countedTime > timeSeconds)
            {
                break;
            }
        }
    }
}

