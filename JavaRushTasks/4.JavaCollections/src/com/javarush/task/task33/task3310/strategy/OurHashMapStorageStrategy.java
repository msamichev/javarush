package com.javarush.task.task33.task3310.strategy;

/**
 *
 */
public class OurHashMapStorageStrategy implements StorageStrategy {

    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    private float loadFactor = DEFAULT_LOAD_FACTOR;
    private Entry[] table = new Entry[DEFAULT_INITIAL_CAPACITY];
    private int size;
    private int threshold = (int) (DEFAULT_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR);

    public OurHashMapStorageStrategy() {
        this.loadFactor = DEFAULT_LOAD_FACTOR;
    }

    private int hash(Long k) {
        int h;
        return (k == null) ? 0 : (h = k.hashCode()) ^ (h >>> 16);
    }

    private int indexFor(int hash, int length) {
        return (length - 1) & hash;
    }

    private Entry getEntry(Long key) {
        int hash = hash(key);
        Entry[] tab;
        Entry first, e;
        int n;
        Long k;
        if ((tab = table) != null && (n = tab.length) > 0 &&
                (first = tab[indexFor(hash, n)]) != null) {
            if (first.hash == hash && // always check first node
                    ((k = first.key) == key || (key != null && key.equals(k))))
                return first;
            if ((e = first.next) != null) {
                do {
                    if (e.hash == hash &&
                            ((k = e.key) == key || (key != null && key.equals(k))))
                        return e;
                } while ((e = e.next) != null);
            }
        }
        return null;
    }

    private void resize(int newCapacity) {
        threshold = (int) (newCapacity * loadFactor);
        Entry[] newTab = new Entry[newCapacity];
        transfer(newTab);
        table = newTab;
    }

    private void transfer(Entry[] newTable) {
        Entry[] oldTab = table;
        int oldCap = oldTab.length;
        int newCapacity = newTable.length;

        if (oldTab != null) {
            for (int j = 0; j < oldCap; ++j) {
                Entry e;
                if ((e = oldTab[j]) != null) {
                    oldTab[j] = null;
                    if (e.next == null)
                        newTable[indexFor(e.hash, newCapacity)] = e;
                    else { // preserve order
                        Entry loHead = null, loTail = null;
                        Entry hiHead = null, hiTail = null;
                        Entry next;
                        do {
                            next = e.next;
                            if (indexFor(e.hash, oldCap + 1) == 0) {
                                if (loTail == null)
                                    loHead = e;
                                else
                                    loTail.next = e;
                                loTail = e;
                            } else {
                                if (hiTail == null)
                                    hiHead = e;
                                else
                                    hiTail.next = e;
                                hiTail = e;
                            }
                        } while ((e = next) != null);
                        if (loTail != null) {
                            loTail.next = null;
                            newTable[j] = loHead;
                        }
                        if (hiTail != null) {
                            hiTail.next = null;
                            newTable[j + oldCap] = hiHead;
                        }
                    }
                }
            }
        }
    }

    private void addEntry(int hash, Long key, String value, int bucketIndex) {
        Entry[] tab = table;
        Entry p = tab[bucketIndex];
        Entry e;
        Long k;

        if (p.hash == hash &&
                ((k = p.key) == key || (key != null && key.equals(k))))
            e = p;
        else {
            for (; ; ) {
                if ((e = p.next) == null) {
                    p.next = new Entry(hash, key, value, null);
                    break;
                }
                if (e.hash == hash
                        && ((k = e.key) == key || (key != null && key.equals(k))))
                    break;
                p = e;
            }
        }
        if (e != null) { // existing mapping for key
            e.value = value;
        }
    }

    private void createEntry(int hash, Long key, String value, int bucketIndex) {
        Entry[] tab = table;
        tab[bucketIndex] = new Entry(hash, key, value, null);
    }

    @Override
    public boolean containsKey(Long key) {
        return getEntry(key) != null;
    }

    @Override
    public boolean containsValue(String value) {
        Entry[] tab;
        String v;
        if ((tab = table) != null && size > 0) {
            for (int i = 0; i < tab.length; ++i) {
                for (Entry e = tab[i]; e != null; e = e.next) {
                    if ((v = e.value) == value ||
                            (value != null && value.equals(v)))
                        return true;
                }
            }
        }
        return false;
    }

    @Override
    public void put(Long key, String value) {
        int hash = hash(key);

        Entry[] tab;
        int n, i;
        if ((tab = table) == null || (n = tab.length) == 0) {
            resize(tab.length << 1);
            n = (tab = table).length;
        }
        if (tab[i = indexFor(hash, n)] == null)
            createEntry(hash, key, value, i);
        else {
            addEntry(hash, key, value, i);
        }

        if (++size > threshold)
            resize(tab.length << 1);
    }

    @Override
    public Long getKey(String value) {
        Entry[] tab;
        String v;
        if ((tab = table) != null && size > 0) {
            for (int i = 0; i < tab.length; ++i) {
                for (Entry e = tab[i]; e != null; e = e.next) {
                    if ((v = e.value) == value ||
                            (value != null && value.equals(v)))
                        return e.key;
                }
            }
        }
        return null;
    }

    @Override
    public String getValue(Long key) {
        Entry e;
        return (e = getEntry(key)) == null ? null : e.value;
    }
}
