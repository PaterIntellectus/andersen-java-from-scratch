package com.andersen.AbstractEntity;

abstract public class AbstractEntity {
    private int id;

    public AbstractEntity() {}

    public AbstractEntity(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
