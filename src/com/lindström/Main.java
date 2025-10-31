package com.lindström;

import com.lindström.entity.*;
import com.lindström.pricing.JuniorPricePolicy;
import com.lindström.pricing.StandardPricePolicy;
import com.lindström.service.MembershipService;
import com.lindström.service.RentalService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {


    public static void main(String[] args) {


//        MemberRegistry memberRegistry = new MemberRegistry();
//
//        System.out.println("ettan " + memberRegistry.findMemberById(0));
//        System.out.println("Hela listan; " + memberRegistry.listMembers());
//
//        Inventory inventory = new Inventory();
//        System.out.println("Produkter " + inventory.getItems().toString());
//
//        JuniorPricePolicy juniorPricePolicy = new JuniorPricePolicy();
//        System.out.println("Junior price policy " + juniorPricePolicy.calculatePrice(5));
//        StandardPricePolicy standardPricePolicy = new StandardPricePolicy();
//        System.out.println("Standard price policy " + standardPricePolicy.calculatePrice(5));
//
//        MembershipService membershipService = new MembershipService();
//        System.out.println(membershipService.calculatePrice(5, "junior"));
//
//        Rental rental = new Rental(memberRegistry.findMemberById(2), 2);
//        Skate skate = new Skate(100.0, "Salkov ", 40, "Bauer");
//        RentalService rentalService = new RentalService(rental);
//        System.out.println("rentalservice " + rentalService.calculatePrice(skate, 5, memberRegistry.findMemberById(2)));
//
//        List<Rental> rentalHistory = memberRegistry.listMembers().get(1).getRentalHistory();
//        System.out.println("rentalHistory " + rentalHistory);


        Scanner scanner = new Scanner(System.in);
        boolean run = true;


        while (run) {
            System.out.println("\n--- VALBO HC Hyr utrustning ---");
            System.out.println("Välj ett alternativ:");
            System.out.println("1. Lista medlemmar");
            System.out.println("2. Lista hockeyartiklar");
            System.out.println("3. Starta uthyrning");
            System.out.println("4. Lista uthyrda artiklar");
            System.out.println("5. Avsluta uthyrning");
            System.out.println("6. Skapa medlem");
            System.out.println("7. Ändra level");
            System.out.println("8. Avsluta program");
            System.out.print("Val: ");

            String choise = scanner.next();
            MemberRegistry memberRegistry = new MemberRegistry();
            Inventory inventory = new Inventory();




            switch (choise.toLowerCase()) {
                case "1":
                    System.out.println("Resultat 1: " + memberRegistry.listMembers().toString());
                    break;
                case "2":
                    System.out.println("Resultat 2: " + inventory.getItems().toString());
                    break;
                case "3":
                    System.out.print("Ange medlemsId : ");
                    int id = scanner.nextInt();
                    System.out.print("Ange artikel : ");
                    int artikel = scanner.nextInt();
                    System.out.print("Ange antal hyrdagar : ");
                    int rentDays = scanner.nextInt();
                    RentalService rentalService = new RentalService(new Rental(memberRegistry.findMemberById(id), rentDays));
                    double sum = rentalService.calculatePrice(inventory.getItems().get(artikel), rentDays, memberRegistry.findMemberById(id));
                    System.out.println("Resultat 3: " + sum);
                    break;
                    case "4":
                        



                case "6":
                    System.out.print("Ange namn : ");
                    String name = scanner.next();
                    System.out.print("Ange level: ");
                    String level = scanner.next();
                    memberRegistry.addMember(new Member(name, level, new ArrayList<>()));
                    System.out.println("Medlem tillagd: " + memberRegistry.listMembers().toString());
                    break;

                case "8":
                    run = false;
                    System.out.println("Avslutar programmet.");
                    break;
                default:
                    System.out.println("Ogiltigt val. Försök igen.");

            }
        }


    }

}
