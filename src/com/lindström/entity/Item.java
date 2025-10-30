package com.lindström.entity;

public abstract class Item {
    public double getBasePrice;
    protected int id;
    protected String name;
    protected boolean available = true;


    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public boolean isAvailable() {
        return available;
    }

    public void rentOut() {
        this.available = false;
    }

    public void returnItem() {
        this.available = true;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;

    }

    public double getBasePrice() {
        return getBasePrice;
    }

    public void setGetBasePrice(double getBasePrice) {
        this.getBasePrice = getBasePrice;
    }

    public abstract String getInfo();

}




