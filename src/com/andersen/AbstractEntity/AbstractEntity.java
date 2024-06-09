package com.andersen.AbstractEntity;

abstract public class AbstractEntity {
    private int id;

    AbstractEntity(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void print() {
        System.out.printf("AbstractClass(id = %d)", id);
    }
}
