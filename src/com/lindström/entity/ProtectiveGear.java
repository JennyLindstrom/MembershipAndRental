package com.lindström.entity;

public class ProtectiveGear extends Item{

    private String type;
    private String size;

    public ProtectiveGear (int id, String Name, String type, String size){
        super(id,Name);
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
    public String getInfo() {
        return "Skydd: " + name + " (" + type + ", storlek: " + size + ")";
    }
}
