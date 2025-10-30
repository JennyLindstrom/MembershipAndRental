package com.lindström.pricing;


import com.lindström.entity.Item;

public interface PricePolicy {
    double calculatePrice(Item item, int days);


}
