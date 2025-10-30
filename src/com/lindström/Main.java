package com.lindström;

import com.lindström.entity.*;
import com.lindström.pricing.JuniorPricePolicy;
import com.lindström.pricing.StandardPricePolicy;
import com.lindström.service.MembershipService;
import com.lindström.service.RentalService;

import java.time.LocalDate;

public class Main {


    public static void main(String[] args) {


        Member member1 = new Member("Anna Bengtsson", "Junior");
        Member member2 = new Member("Julia Bengtsson", "Senior");
        Member member3 = new Member("Adam Bengtsson", "Junior");
        Member member4 = new Member("Anders Bengtsson", "Senior");

        MemberRegistry memberRegistry = new MemberRegistry();
        MemberRegistry.addMember(member1);
        MemberRegistry.addMember(new Member("Jonas Eriksson", "Standard"));

//        System.out.println(memberRegistry.listMembers());
        Member m1 = memberRegistry.findMemberById(1);
//        System.out.println(m1);


//            System.out.println(member2.getId() + " " + member2.getName());
//            System.out.println(member3.getId() + " " + member3.getName());
//            System.out.println(member4.getId() + " " + member4.getName());
//            System.out.println(member1.getId() + " " + member1.getName());

        Skate skate1 = new Skate(1, "Vapor", 37, "Bauer");
        Skate skate2 = new Skate(2, "FX INT", 41, "CCM");
        Skate skate3 = new Skate(3, "Suprime", 38, "Bauer");
        Skate skate4 = new Skate(4, "FX", 41, "CCM");
//            System.out.println("Skridsko: " + skate1.getName() + " tillgänglig: " + skate1.isAvailable());

        Rental rent = new Rental(member1, skate1, LocalDate.now());
        StandardPricePolicy standardPricePolicy = new StandardPricePolicy();
        rent.close(LocalDate.now().plusDays(10), standardPricePolicy);
//        System.out.println(rent);

        Rental rent2 = new Rental(member2, skate2, LocalDate.now());
        JuniorPricePolicy juniorPricePolicy = new JuniorPricePolicy();
        rent2.close(LocalDate.now().plusDays(20), juniorPricePolicy);
//        System.out.println(rent2);


        HockeyStick stick1 = new HockeyStick(1, "Bauer Nexus", "Junior", "Left", "Composite");
        HockeyStick stick2 = new HockeyStick(2, "CCN", "85", "Right", "Composite");
        HockeyStick stick3 = new HockeyStick(3, "Bauer", "80", "Left", "Composite");
        HockeyStick stick4 = new HockeyStick(4, "CCN", "85", "Left", "Composite");
//            System.out.println(stick4.getInfo() + " " + stick4.isAvailable());
//            System.out.println(stick1.getFlex() + " " + stick1.isAvailable());

        ProtectiveGear gear1 = new ProtectiveGear(1, "Bauer", "Hjälm", "57");
        ProtectiveGear gear2 = new ProtectiveGear(2, "Bauer", "Knäskydd", "M");
        ProtectiveGear gear3 = new ProtectiveGear(3, "Bauer", "Halsslydd", "S");
//            System.out.println(gear1.getInfo() + " " + gear1.isAvailable());
//            System.out.println(gear2.getInfo() + " " + gear2.isAvailable());


        Inventory.addItem(new Skate(1, "Bauer Vapor", 42, "Bauer"));
        Inventory.addItem(new HockeyStick(2, "CCM Ribcor", "85", "Left", "Komposit"));
        Inventory.addItem(new ProtectiveGear(3, "Bauer Supreme", "Axelskydd", "L"));
//            System.out.println("hämta items " + Inventory.getItems());


        MembershipService service = new MembershipService();

//        service.upgradeLevel(member1);
//        System.out.println(service);
//        service.upgradeLevel(member2);
//        System.out.println(service);
//        service.upgradeLevel(member3);
//        System.out.println(service);

        RentalService rentalService = new RentalService();
        Rental rental = rentalService.startRental(member2, skate1, LocalDate.now(), juniorPricePolicy);
//        System.out.println(rental);

        member1.addRental(rent);
        member2.addRental(rent);

        System.out.println("Historik för medlem " + member1.getName() + ":");
        for (Rental rental1 : member1.getHistory()) {
//            System.out.println(rental1);
        }
        Inventory inventory = new Inventory();


        inventory.addItem(skate3);


//        System.out.println("Försöker starta uthyrning...");
        Rental rental2 = rentalService.startRental(member2, skate3, LocalDate.now(), standardPricePolicy);

        if (rental2 != null) {
//            System.out.println("Uthyrning lyckades!");

            // Avsluta uthyrningen efter några dagar
            rentalService.endRental(rental2, LocalDate.now().plusDays(5), standardPricePolicy);
        } else {
//            System.out.println("Uthyrning kunde inte startas.");
        }

        System.out.println("Uthyrningshistorik för " + member2.getName() + ":");
        for (Rental r : member2.getHistory()) {
//            System.out.println(r);
        }


    }
}