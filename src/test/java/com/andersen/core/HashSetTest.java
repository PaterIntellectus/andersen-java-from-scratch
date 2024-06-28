package com.andersen.core;


public class HashSetTest {
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
