package com.lindström.entity;

public class Skate extends Item {

    private final int size;
    private final String brand;

    public Skate(double dailyPrice, String name, int size, String Brand) {
        super(dailyPrice, name);
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
    public String toString() {
        return "Skate{" +
                "size=" + size +
                ", brand='" + brand + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
