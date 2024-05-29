package com.andersen.HelloWorld;

public class HelloWorld {
    public static void main(String[] args) {
        String name = "Unknown Programmer";

        if (args.length > 0) {
            name = String.join(" ", args);
        }

        System.out.printf("Hello %s\n", name);
    }
}

