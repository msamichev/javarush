package com.javarush.test.level27.lesson15.big01.ad;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
class AdvertisementStorage
{
    private final static AdvertisementStorage instance  = new AdvertisementStorage();

    private final List<Advertisement> videos = new ArrayList<>();

    private AdvertisementStorage()
    {
        Object someContent = new Object();
        add(new Advertisement(someContent, "First Video", 5000, 100, 3 * 60));
        add(new Advertisement(someContent, "Second Video", 100, 10, 15 * 60));
        add(new Advertisement(someContent, "Third Video", 400, 2, 10 * 60));
    }

    static AdvertisementStorage getInstance()
    {
        return instance;
    }

    List<Advertisement> list(){
        return videos;
    }

    void add(Advertisement advertisement){
        videos.add(advertisement);
    }

}
