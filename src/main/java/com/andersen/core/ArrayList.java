package com.andersen.core;

import java.util.Arrays;
import java.util.Collection;

public class ArrayList<ItemType> {
    private static final int DEFAULT_SIZE = 3;

    private int size = 0;

    private ItemType[] items;


    public ArrayList() {
        this.items = createArrayOfItems(DEFAULT_SIZE);
    }

    public ArrayList(int capacity) {
        this.items = createArrayOfItems(capacity);
    }

    public ArrayList(final Collection<ItemType> items) {
        this.items = createArrayOfItems(items);
        setSize(items.size());
    }


    public int getSize() {
        return this.size;
    }

    private void setSize(int size) {
        this.size = size;
    }

    public int getCapacity() {
        return this.items.length;
    }



    public void put(final ItemType item) {
        if (getCapacity() == getSize()) {
            increaseCapacity(DEFAULT_SIZE);
        }

        items[size++] = item;
    }

    
    public ItemType get(final int index) {
        checkIndex(index);

        return (ItemType) items[index];
    }

    public void delete(final int index) {
        checkIndex(index);

        final var temp = createArrayOfItems(getCapacity() - 1);

        System.arraycopy(items, 0, temp, 0, index);
        System.arraycopy(items, index + 1, temp, index, getSize() - index - 1);

        this.items = temp;
        --size;
    }

    /**
     * Checks if current ArrayList has element at the specified index
     * if index is not valid, throws IndexOutOfBoundsException
     * otherwise ends without throwing
     *
     * @param  addition the index to check
     * @throws IndexOutOfBoundsException if index is not valid
     */
    public void increaseCapacity(final int addition) {
        var temp = items;
        items = createArrayOfItems(getCapacity() + addition);
        System.arraycopy(temp, 0, items, 0, temp.length);
    }

    /**
     * Checks if current ArrayList has element at the specified index
     * if index is not valid, throws IndexOutOfBoundsException
     * otherwise ends without throwing
     *
     * @param  index the index to check
     * @throws IndexOutOfBoundsException if index is not valid
     */
    private void checkIndex(int index) throws IndexOutOfBoundsException {
        if (index < 0 || getSize() - 1 < index){
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Creates an array of items
     * @param size of new array
     * @return array of objects cast to ItemType
     */
    @SuppressWarnings("unchecked")
    private ItemType[] createArrayOfItems(int size) {
        return (ItemType[]) new Object[size];
    }

    /**
     * Creates an array of items
     * @param items existing array
     * @return array of objects cast to ItemType
     */
    @SuppressWarnings("unchecked")
    private ItemType[] createArrayOfItems(final Collection<ItemType> items) {
        return (ItemType[]) items.toArray();
    }

    @Override
    public String toString() {
        final StringBuilder str = new StringBuilder("ArrayList(");

        if (getSize() > 0) {
            str.append(items[0]);
            for (int i = 1; i < getSize(); ++i) {
                str.append(String.format(", %s", items[i]));
            }
        }

        str.append(")");

        return str.toString();
    }


    public void print() {

    }

}
