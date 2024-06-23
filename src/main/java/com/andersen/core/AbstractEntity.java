package com.andersen.core;

import java.util.Objects;

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

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof AbstractEntity)) return false;
        if (obj == this) return true;
        return this.getId() == ((AbstractEntity) obj).getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return String.format("AbstractEntity(id = %d)\n", getId());
    }
}
