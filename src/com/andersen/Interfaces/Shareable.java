package com.andersen.Interfaces;

public interface Shareable {
    default void share(String phoneNumber) {
        System.out.printf("The class shared by the phone number - %s\n", phoneNumber);
    }

    default void share(String phoneNumber, String email) {
        System.out.printf("The class shared by the phone number - '%s'\n and an email - '%s'\n", phoneNumber, email);
    }
}
