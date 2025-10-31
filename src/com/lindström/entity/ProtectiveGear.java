package com.lindström.entity;

public class ProtectiveGear extends Item {

    private final String type;
    private final String size;

    public ProtectiveGear(double dailyPrice, String name, String type, String size) {
        super(dailyPrice, name);
        this.type = type;
        this.size = size;

    }

    public String getSize() {
        return size;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "ProtectiveGear{" +
                "name='" + name + '\'' +
                ", size='" + size + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
