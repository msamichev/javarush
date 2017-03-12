package com.javarush.task.task34.task3413;

import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SoftCache {
    private Map<Long, SoftReference<AnyObject>> cacheMap = new ConcurrentHashMap<>();

    public AnyObject get(Long key) {
        AnyObject res = null;
        SoftReference<AnyObject> softReference = cacheMap.get(key);
        if(softReference != null) {
            res = softReference.get();
        }
        return res;
    }

    public AnyObject put(Long key, AnyObject value) {
        AnyObject res = null;
        SoftReference<AnyObject> softReference = cacheMap.put(key, new SoftReference<>(value));
        if(softReference != null) {
            res = softReference.get();
            softReference.clear();
        }
        return res;
    }

    public AnyObject remove(Long key) {
        AnyObject res = null;
        SoftReference<AnyObject> softReference = cacheMap.remove(key);
        if(softReference != null) {
            res = softReference.get();
            softReference.clear();
        }
        return res;
    }
}