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


    // testing
    public static void main(String[] args) {
        final var hs = new HashSet<Integer>();

        hs.add(1);
        hs.add(3);
        hs.add(51);
        hs.add(21);

        hs.remove(434);
        hs.add(434);

        hs.add(12);
        hs.add(12);
        hs.remove(12);
        System.out.printf("HashSet has 12: %b\n", hs.contains(12));
        System.out.printf("HashSet has 434: %b\n", hs.contains(434));

        System.out.print("Hash Set(");
        for (final var v : hs) {
            System.out.printf("%s,", v);
        }
        System.out.println(")");
    }

}

