package com.andersen.core;

import java.util.Arrays;

public class ArrayListTest {
    public static void main(String[] args) {
        final var a1 = new ArrayList<>(1);
        final var a2 = new ArrayList<Integer>();

        a1.put("first");
        a1.put(2);
        a1.put(a2);

        a2.put(23);
        a2.put(11);
        a2.put(2001);

        a1.delete(1);

        printArrayInfo(a1, "a1");
        printArrayInfo(a2, "a2");

        System.out.printf("a1[1]: %s\n", a1.get(1));

        final var a3 = new ArrayList<>(Arrays.asList("I", "am", "the", "Cure"));
        a3.put("!");
        printArrayInfo(a3, "a3");
    }

    static private void printArrayInfo(ArrayList arr, String title) {
        System.out.printf("%s: %s, size: %d, capacity: %d\n", title, arr, arr.getSize(), arr.getCapacity());
    }
}
