package com.lindström.service;

import com.lindström.pricing.JuniorPricePolicy;
import com.lindström.pricing.StandardPricePolicy;

public class MembershipService {
    private final StandardPricePolicy standardPricePolicy = new StandardPricePolicy();
    private final JuniorPricePolicy juniorPricePolicy = new JuniorPricePolicy();

    public double calculatePrice(int days, String strategyType) {
        switch (strategyType.toLowerCase()) {
            case "standard":
                return standardPricePolicy.calculatePrice(days);
            case "junior":
                return juniorPricePolicy.calculatePrice(days);
            default:
                throw new IllegalArgumentException("Ogiltlig medlemskapssnivå");
        }

    }
}
