package com.lindström.item;

public class Skate extends Item {

    private int size;

    public Skate(String description, int size) {
        super(description);
        this.size = size;

    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Skate{" +
                "size=" + size +
                '}';
    }
}
