package com.andersen.interfaces;

public interface Printable {
    default void print() {
        System.out.println("This class is printable, please override the initial functionality of 'print' method in your class");
    }
}
