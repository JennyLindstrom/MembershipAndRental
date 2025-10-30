package com.lindström.entity;

import com.lindström.pricing.PricePolicy;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Rental {
    private Member member;
    private Item item;
    private LocalDate startDate;
    private LocalDate endDate;
    private double totalCost;
    private List<Rental> activeRentals = new ArrayList<>();


    public Rental(Member member, Item item, LocalDate startDate) {
        this.member = member;
        this.item = item;
        this.startDate = startDate;


    }
    public void close(LocalDate endDate, PricePolicy policy) {
        this.endDate = endDate;
        int days = (int) (endDate.toEpochDay() - startDate.toEpochDay());
        int day = (int) (endDate.toEpochDay() - startDate.toEpochDay());
        double pricePolicy = policy.calculatePrice(item, day);
        item.returnItem();

    }
    public double getTotalCost() {
        return totalCost;
    }
    public Item getItem() {
        return item;
    }

    private LocalDate getEndDate() {
        return endDate;
    }

    @Override
    public String toString() {
        return item.getName() + " hyrd av " + member.getName() + " från " + startDate + (endDate != null ? (" till " + endDate + ", kostnad: " + totalCost + " kr") : "");
    }

    public void close(LocalDate localDate) {
    }
}
