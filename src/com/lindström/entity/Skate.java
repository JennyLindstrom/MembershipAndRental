package com.lindström.entity;

public class Skate extends Item{

    private int size;
    private String brand;

    public Skate(int id, String name, int size, String Brand) {
        super(id, name);
        this.brand = Brand;
        this.size = size;

    }

    public int getSize() {
        return size;
    }

    public String getBrand() {
        return brand;
    }

    @Override
    public String getInfo() {
        return "Skridsko " + name + " (" + brand + "), storlek " + size;
    }
}
