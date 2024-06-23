package com.andersen.interfaces;

public interface Shareable {
    default void share(String phoneNumber) {
        System.out.printf("The class shared via phone: %s\n", phoneNumber);
    }

    default void share(String phoneNumber, String email) {
        System.out.printf("The class shared via phone: '%s', and email: '%s'\n", phoneNumber, email);
    }
}
