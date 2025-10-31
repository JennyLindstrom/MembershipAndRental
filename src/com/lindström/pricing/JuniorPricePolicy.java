package com.lindström.pricing;

public class JuniorPricePolicy implements PricePolicy {

    @Override
    public double calculatePrice(int days) {
        double v = days * 75.0;
        return v;
    }
}
