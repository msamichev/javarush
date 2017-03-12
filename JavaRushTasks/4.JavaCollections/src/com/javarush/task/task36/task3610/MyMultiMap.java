package com.javarush.task.task36.task3610;

import java.io.Serializable;
import java.util.*;

public class MyMultiMap<K, V> extends HashMap<K, V> implements Cloneable, Serializable {
    static final long serialVersionUID = 123456789L;
    private HashMap<K, List<V>> map;
    private int repeatCount;

    public MyMultiMap(int repeatCount) {
        this.repeatCount = repeatCount;
        map = new HashMap<>();
    }

    @Override
    public int size() {
        int res = 0;
        for (List<V> list : map.values()) {
            res += list.size();
        }
        return res;
    }

    @Override
    public V put(K key, V value) {
        //напишите тут ваш код
        if (key == null) throw new IllegalArgumentException();

        if (map.containsKey(key)) {
            List<V> list = map.get(key);
            if (repeatCount == list.size()) {
                list.remove(0);
            }
            V lastValue = list.get(list.size() - 1);
            list.add(value);
            return lastValue;
        } else {
            List<V> list = new ArrayList<V>();
            list.add(value);
            map.put(key, list);
            return null;
        }
    }

    @Override
    public V remove(Object key) {
        //напишите тут ваш код
        if (map.containsKey(key)) {
            List<V> list = map.get(key);
            V removedValue = list.remove(0);
            if (list.isEmpty()) {
                map.remove(key);
            }
            return removedValue;
        } else {
            return null;
        }
    }

    @Override
    public Set<K> keySet() {
        return map.keySet();
    }

    @Override
    public Collection<V> values() {
        //напишите тут ваш код
        ArrayList<V> res = new ArrayList<V>();

        for (List<V> list : map.values()) {
            res.addAll(list);
        }

        return res;
    }

    @Override
    public boolean containsKey(Object key) {
        //напишите тут ваш код
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        //напишите тут ваш код
        for (List<V> list : map.values()) {
            if (list.contains(value)) return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (Map.Entry<K, List<V>> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            for (V v : entry.getValue()) {
                sb.append(v);
                sb.append(", ");
            }
        }
        String substring = sb.substring(0, sb.length() - 2);
        return substring + "}";
    }
}