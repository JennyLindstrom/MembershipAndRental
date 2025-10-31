package com.lindström.pricing;

public class StandardPricePolicy implements PricePolicy {


    @Override
    public double calculatePrice(int days) {
        return days * 100.0;
    }
}
