package com.lindström;

import com.lindström.entity.Inventory;
import com.lindström.entity.MemberRegistry;
import com.lindström.entity.Rental;
import com.lindström.entity.Skate;
import com.lindström.pricing.JuniorPricePolicy;
import com.lindström.pricing.StandardPricePolicy;
import com.lindström.service.MembershipService;
import com.lindström.service.RentalService;

import java.util.List;


public class Main {


    public static void main(String[] args) {


        MemberRegistry memberRegistry = new MemberRegistry();

        System.out.println("ettan " + memberRegistry.findMemberById(0));
        System.out.println("Hela listan; " + memberRegistry.listMembers());

        Inventory inventory = new Inventory();
        System.out.println("Produkter " + inventory.getItems().toString());

        JuniorPricePolicy juniorPricePolicy = new JuniorPricePolicy();
        System.out.println("Junior price policy " + juniorPricePolicy.calculatePrice(5));
        StandardPricePolicy standardPricePolicy = new StandardPricePolicy();
        System.out.println("Standard price policy " + standardPricePolicy.calculatePrice(5));

        MembershipService membershipService = new MembershipService();
        System.out.println(membershipService.calculatePrice(5, "junior"));

        Rental rental = new Rental(memberRegistry.findMemberById(2), 2);
        Skate skate = new Skate(100.0, "Salkov ", 40, "Bauer");
        RentalService rentalService = new RentalService(rental);
        System.out.println("rentalservice " + rentalService.calculatePrice(skate, 5, memberRegistry.findMemberById(2)));

        List<Rental> rentalHistory = memberRegistry.listMembers().get(1).getRentalHistory();
        System.out.println("rentalHistory " + rentalHistory);


    }


}
