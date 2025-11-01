package com.lindström.item;

public class ProtectiveGear extends Item {


    private String size;
    private String type;

    public ProtectiveGear(String description, String size, String type) {
        super(description);
        this.size = size;
        this.type = type;
    }


    public String getSize() {
        return size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSize(String size) {
        this.size = size;
    }


}
