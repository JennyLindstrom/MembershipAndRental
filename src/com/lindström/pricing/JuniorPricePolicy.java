package com.lindström.pricing;

import com.lindström.entity.Item;



public class JuniorPricePolicy implements PricePolicy {
    @Override
    public double calculatePrice(Item item, int days) {
        double dailyRate = 80.0;
        return (item.getBasePrice() * days);
    }
}
