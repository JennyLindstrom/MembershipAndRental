package com.lindström.entity;

import com.lindström.pricing.PricePolicy;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private String name;
    private String level;
    private int id;
    private static int nextId = 1;
//    private final List<Rental> rentalHistory;
//    private PricePolicy pricePolicy;

    public Member(String name, String level) {
        this.id = nextId++;
        this.name = name;
//        this.rentalHistory = new ArrayList<>();
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String standard) {
    }

    public int getId() {
        return id;
    }


//    public List<Rental> getHistory() {
//        return history;
//    }
//    public void addRental(Rental rental) {
//        history.add(rental);
//    }

    @Override
    public String toString() {
        return name + " (" + level + ")";
    }



}
