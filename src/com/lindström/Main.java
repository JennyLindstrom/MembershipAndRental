package com.lindström;

import com.lindström.item.HockeyStick;
import com.lindström.item.Inventory;
import com.lindström.item.ProtectiveGear;
import com.lindström.item.Skate;
import com.lindström.member.MemberRegistry;
import com.lindström.member.MembershipService;
import com.lindström.rental.RentalService;


public class Main {


    public static void main(String[] args) {


        Inventory inventory = new Inventory();
        MemberRegistry memberRegistry = new MemberRegistry();
        RentalService rentalService = new RentalService(inventory, memberRegistry);
        MembershipService membershipService = new MembershipService(memberRegistry);

        addSampleData(inventory, membershipService);
        Menu menu = new Menu(inventory, memberRegistry, rentalService, membershipService);
        menu.start();
        
    }

    private static void addSampleData(Inventory inventory, MembershipService membershipService) {

        //Medlemmar
        membershipService.addMember("Anna Andersson", "Junior");
        membershipService.addMember("Bertil Bengtsson", "Junior");
        membershipService.addMember("Cecilia Karlsson", "Senior");
        membershipService.addMember("David Danielsson", "Senior");
        membershipService.addMember("Emma Eriksson", "Senior");
        membershipService.addMember("Fanny Fransson", "Junior");
        membershipService.addMember("Göran Göransson", "Senior");
        membershipService.addMember("Håkan Henriksson", "Junior");
        membershipService.addMember("Isebelle Isaksson", "Senior");


        //Skyddsutrustning
        inventory.addItem(new ProtectiveGear("Halsskydd", "Bauer", "Small"));
        inventory.addItem(new ProtectiveGear("Halsskydd", "Bauer", "Medium"));
        inventory.addItem(new ProtectiveGear("Halsskydd", "CCN", "Large"));
        inventory.addItem(new ProtectiveGear("Halsskydd", "CCN", "Medium"));
        inventory.addItem(new ProtectiveGear("Hjälm", "CCN", "Large"));
        inventory.addItem(new ProtectiveGear("Hjälm", "CCN", "Small"));
        inventory.addItem(new ProtectiveGear("Hjälm", "Bauer", "Medium"));
        inventory.addItem(new ProtectiveGear("Hjälm", "Bauer", "Small"));
        inventory.addItem(new ProtectiveGear("Armbågsskydd", "Bauer", "Small"));
        inventory.addItem(new ProtectiveGear("Armbågsskydd", "CCN", "Medium"));
        inventory.addItem(new ProtectiveGear("Armbågsskydd", "CCN", "Medium"));
        inventory.addItem(new ProtectiveGear("Armbågsskydd", "Bauer", "Large"));

        //Klubbor
        inventory.addItem(new HockeyStick("Vapor CCN", "Composite", "85", "Right"));
        inventory.addItem(new HockeyStick("Snake CCN", "Composite", "80", "Left"));
        inventory.addItem(new HockeyStick("Vapor CCN", "Composite", "85", "Right"));
        inventory.addItem(new HockeyStick("CTX CCN", "Composite", "80", "Left"));
        inventory.addItem(new HockeyStick("WARRIOR HOCKEY", "Composite", "90", "Right"));
        inventory.addItem(new HockeyStick("Tyke Bauer", "Composite", "100", "Left"));
        inventory.addItem(new HockeyStick("WARRIOR HOCKEY", "Composite", "80", "Right"));
        inventory.addItem(new HockeyStick("JETSPEED Bauer", "Composite", "85", "Right"));
        inventory.addItem(new HockeyStick("Pulse Bauer", "Composite", "85", "Left"));
        inventory.addItem(new HockeyStick("Vapor CCN", "Composite", "85", "Left"));

        //SKridskor
        inventory.addItem(new Skate("Jetspeed CCN", 38));
        inventory.addItem(new Skate("Jetspeed CCN", 39));
        inventory.addItem(new Skate("Jetspeed CCN", 37));
        inventory.addItem(new Skate("Jetspeed CCN", 40));
        inventory.addItem(new Skate("Jetspeed CCN", 41));
        inventory.addItem(new Skate("Jetspeed CCN", 42));
        inventory.addItem(new Skate("Jetspeed CCN", 43));
        inventory.addItem(new Skate("Jetspeed CCN", 44));
        inventory.addItem(new Skate("Jetspeed CCN", 36));

    }
}
