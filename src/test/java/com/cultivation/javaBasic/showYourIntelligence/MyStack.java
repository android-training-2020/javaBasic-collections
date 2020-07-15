package com.cultivation.javaBasic.showYourIntelligence;


@SuppressWarnings({"unused", "FieldCanBeLocal"})
public class MyStack {
    private int[] storage;
    private int capacity;
    private int count;
    private static final int GROW_FACTOR = 2;

    public MyStack(int initialCapacity) {
        if (initialCapacity < 1) {
            throw new IllegalArgumentException("Capacity too small.");
        }

        capacity = initialCapacity;
        storage = new int[initialCapacity];
        count = 0;
    }

    public void push(int value) {
        if (count == capacity) {
            ensureCapacity();
        }
        storage[count] = value;
        count = count + 1;
    }

    private void ensureCapacity() {
        int newCapacity = capacity * GROW_FACTOR;
        capacity = newCapacity;
        int[] newStorage = new int[newCapacity];
        for (int i = 0; i < count; i++) {
            newStorage[i] = storage[i];
        }
        storage = newStorage;
    }

    public int[] popToArray() {
        final int totalItemsCount = count;
        int[] array = new int[totalItemsCount];

        while (count > 0) {
            array[totalItemsCount - count] = pop();
        }

        return array;
    }

    private int pop() {
        int[] newStack = new int[count - 1];
        for (int i = 0; i < count - 1; i++) {
            newStack[i] = storage[i];
        }
        int lastItem = storage[count - 1];
        storage = newStack;
        count = count - 1;
        return lastItem;
    }
}
