package com.lindström.service;


import com.lindström.entity.Item;
import com.lindström.entity.Member;
import com.lindström.entity.Rental;
import com.lindström.pricing.PricePolicy;

import java.util.Map;

public class RentalService implements PricePolicy {

    private final Rental rental;
    private final Map<Item, Rental> rentedItems;

    public RentalService(Rental rental) {
        this.rental = rental;
        this.rentedItems = rental.getRentedItems();
    }


    @Override
    public double calculatePrice(int days) {
        return 0;

    }

    public double calculatePrice(Item item, int days, Member member) {
        if (item == null || item.getBasePrice(days) <= 0) {
            System.out.println("Varning: Inget föremål eller felaktigt pris: " + item);
            return 0;
        }
        return item.getBasePrice(days);
    }

}
