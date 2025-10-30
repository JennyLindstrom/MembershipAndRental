package com.lindström.pricing;

import com.lindström.entity.Item;

public class StandardPricePolicy implements PricePolicy {


    @Override
    public double calculatePrice(Item item, int days) {
        double dailyRate = 100.0;
        return item.getBasePrice() * dailyRate * days;
    }
}
