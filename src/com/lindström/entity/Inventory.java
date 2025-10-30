package com.lindström.entity;

import java.util.ArrayList;
import java.util.List;


public class Inventory {
    private static List<Item> items = new ArrayList<Item>();

    public static void addItem(Item item) {
        items.add(item);
    }
    private static void removeItem(Item item) {
        items.remove(item);
    }
    public static List<Item> getItems() {
        return items;
    }

    public void listAllItems() {
        for (Item item : items) {
            System.out.println(item.getName());

        }
    }

    public Item findItemById(int i) {
        for (Item item : items) {
            if (item.getId() == i) {
                return item;
            }
        }
        return null;
    }
}
