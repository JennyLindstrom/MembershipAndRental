package com.lindström.pricing;


import com.lindström.item.Item;

public interface PricePolicy {


    double calculatePrice(Item item, int days);

}
