package com.lindström.entity;

import java.util.ArrayList;
import java.util.List;


public class Inventory {
    private static final List<Item> items = new ArrayList<Item>();

    public Inventory() {
        initializeInventory();
    }


    public static void addItem(Item item) {
        items.add(item);
    }

    public List<Item> getItems() {
        return items;
    }


    private void initializeInventory() {
        Skate skate1 = new Skate(100.0, "Vapor", 37, "Bauer");
        Skate skate2 = new Skate(200.0, "FX INT", 41, "CCM");
        Skate skate3 = new Skate(300.0, "Suprime", 38, "Bauer");
        Skate skate4 = new Skate(400.0, "FX", 41, "CCM");

        addItem(skate1);
        addItem(skate2);
        addItem(skate3);
        addItem(skate4);

        HockeyStick stick1 = new HockeyStick(100.0, "Bauer Nexus", "Junior", "Left", "Composite");
        HockeyStick stick2 = new HockeyStick(300.0, "CCN", "85", "Right", "Composite");
        HockeyStick stick3 = new HockeyStick(150.0, "Bauer", "80", "Left", "Composite");
        HockeyStick stick4 = new HockeyStick(210.0, "CCN", "85", "Left", "Composite");

        addItem(stick1);
        addItem(stick2);
        addItem(stick3);
        addItem(stick4);

        ProtectiveGear gear1 = new ProtectiveGear(100.0, "Bauer", "Hjälm", "57");
        ProtectiveGear gear2 = new ProtectiveGear(200.0, "Bauer", "Knäskydd", "M");
        ProtectiveGear gear3 = new ProtectiveGear(300.0, "Bauer", "Halsslydd", "S");

        addItem(gear1);
        addItem(gear2);
        addItem(gear3);

    }

}
