package com.lindström.service;

import com.lindström.entity.Inventory;
import com.lindström.entity.Item;
import com.lindström.entity.Member;
import com.lindström.entity.Rental;
import com.lindström.pricing.PricePolicy;

import java.time.LocalDate;

public class RentalService {
    private final Inventory inventory;

    public RentalService(Inventory inventory) {
        this.inventory = inventory;
    }

    public Rental startRental(Member member, Item item, LocalDate startDate, PricePolicy pricePolicy) {
        if (!item.isAvailable()) {
            System.out.println("Utrustningen är redan uthyrd.");
            return null;
        }
        item.rentOut();
        Rental rental = new Rental(member, item, startDate);
//        member.addRental(rental);
        System.out.println("Uthyrning startad: " + item.getName() + " till " + member.getName());
        return rental;
    }
    public void endRental(Rental rental, LocalDate endDate, PricePolicy pricePolicy) {
        rental.close(endDate, pricePolicy);
        System.out.println("Uthyrning avslutad. Kostnad: " + rental.getTotalCost() + " kr");
    }
}
