package com.lindström.entity;

import java.util.HashMap;
import java.util.Map;

public class Rental {
    private final Member member;
    private final int days;
    private Map<Item, Rental> rentedItems = new HashMap<>();


    public Rental(Member member, int days) {
        this.member = member;
        this.days = days;

    }

    public Member getMember() {
        return member;
    }


    public int getDays() {
        return days;
    }


    public Map<Item, Rental> getRentedItems() {
        return rentedItems;
    }

    public void setRentedItems(Map<Item, Rental> rentedItems) {
        this.rentedItems = rentedItems;
    }


}
