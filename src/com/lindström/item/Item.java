package com.lindström.item;

import java.util.UUID;

public abstract class Item {
    private final String id;
    private String description;
    private boolean available;

    public Item(String description) {
        this.id = UUID.randomUUID().toString();
        this.description = description;
        this.available = true;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", available=" + available +
                '}';
    }
}







