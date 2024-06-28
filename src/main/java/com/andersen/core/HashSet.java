package com.andersen.core;

import java.util.HashMap;
import java.util.Iterator;

public class HashSet<Item> implements Iterable<Item> {
    private HashMap<Item, Object> map = new HashMap<Item, Object>();

    int currentIndex = 0;
    private static final Object PRESENT = new Object();

    public boolean add(final Item item) {
        return map.put(item, PRESENT) == null;
    };

    public boolean remove(final Item item) {
        return map.remove(item) == PRESENT;
    }

    public boolean contains(final Item item) {
        return map.containsKey(item);
    }


    public int size() { return map.size(); }

    public Iterator<Item> iterator() {
        return map.keySet().iterator();
    }

}

