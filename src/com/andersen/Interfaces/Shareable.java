package com.andersen.Interfaces;

public interface Shareable {
    public default void share(String phoneNumber) {
        System.out.printf("The class shared by the phone number - %s\n", phoneNumber);
    }

    public default void share(String phoneNumber, String email) {
        System.out.printf("The class shared by the phone number - '%s'\n and an email - '%s'\n", phoneNumber, email);
    }
}
