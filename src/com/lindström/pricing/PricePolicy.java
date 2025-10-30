package com.lindström.pricing;


import com.lindström.entity.Item;

public interface PricePolicy {
    double calculatePrice(Item item, int days);

//    double calculateJuniorPrice(Item item, int day);

    //                //förslag.  Innebär att item får en ny metod
//    double calculateStandardPrice(Item item, int day);

}
