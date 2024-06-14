package com.andersen.User;

import com.andersen.AbstractEntity.AbstractEntity;

abstract public class User extends AbstractEntity {
    final String name;


    User(int id, String name) {
        super(id);

        this.name = name;
    }


    public void printRole() {
        System.out.printf("%d is a User", getId());
    }
}
