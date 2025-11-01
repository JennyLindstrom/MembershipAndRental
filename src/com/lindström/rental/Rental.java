package com.lindström.rental;

import com.lindström.item.Item;
import com.lindström.member.Member;

import java.time.LocalDate;


public class Rental {
    private Member member;
    private Item item;
    private LocalDate startDate;
    private LocalDate endDate;
    private double rentalPrice;

    public Rental(Member member, Item item, LocalDate startDate, LocalDate endDate, double rentalPrice) {
        this.member = member;
        this.item = item;
        this.startDate = startDate;
        this.endDate = endDate;
        this.rentalPrice = rentalPrice;

    }

    public Member getMember() {
        return member;

    }

    public Item getItem() {
        return item;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public double getRentalPrice() {
        return rentalPrice;
    }

    public void setRentalPrice(double price) {
        this.rentalPrice = rentalPrice;
    }


    @Override
    public String toString() {
        return "Uthyrning: " + item + " till " + member +
                ", Från: " + startDate + " Till: " + endDate +
                ", Pris: " + rentalPrice + " kr";
    }
}
