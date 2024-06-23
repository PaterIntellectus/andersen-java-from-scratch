package com.andersen.users;

import com.andersen.core.AbstractEntity;

abstract public class User extends AbstractEntity {
    private String name;


    public User(int id, String name) {
        super(id);

        this.name = name;
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void printRole() {
        System.out.printf("%s is a User", getName());
    }
}
