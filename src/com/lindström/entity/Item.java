package com.lindström.entity;

public abstract class Item {
    private final double basePrice;

    protected String name;


    public Item(double basePrice, String name) {
        this.basePrice = basePrice;
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public double getBasePrice(int days) {
        return basePrice * days;
    }

    @Override
    public String toString() {
        return "Item{" +
                "basePrice=" + basePrice +
                ", name='" + name + '\'' +
                '}';
    }
}







