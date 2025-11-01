package com.lindström;

import com.lindström.item.HockeyStick;
import com.lindström.item.Inventory;
import com.lindström.item.ProtectiveGear;
import com.lindström.item.Skate;
import com.lindström.member.Member;
import com.lindström.member.MemberRegistry;
import com.lindström.member.MembershipService;
import com.lindström.rental.Rental;
import com.lindström.rental.RentalService;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private final Scanner scanner = new Scanner(System.in);

    private final Inventory inventory;
    private final MemberRegistry memberRegistry;
    private final RentalService rentalService;
    private final MembershipService membershipService;

    public Menu(Inventory inventory, MemberRegistry memberRegistry,
                RentalService rentalService, MembershipService membershipService) {
        this.inventory = inventory;
        this.memberRegistry = memberRegistry;
        this.rentalService = rentalService;
        this.membershipService = membershipService;
    }

    public void start() {
        boolean running = true;
        while (running) {
            System.out.println("\n--- VALBO HC Medlemsregister och uthyrningsregister ---");
            System.out.println("1. Medlemmar");
            System.out.println("2. Utrustning");
            System.out.println("3. Uthyrningar");
            System.out.println("0. Avsluta");
            System.out.print("Ange val: ");
            int choice = readInt();

            switch (choice) {
                case 1 -> memberMenu();
                case 2 -> equipmentMenu();
                case 3 -> rentalMenu();
                case 0 -> running = false;
                default -> System.out.println("Ogiltigt val, försök igen!");
            }
        }
        System.out.println("Avslutar programmet.");
    }

    private void memberMenu() {
        boolean inMenu = true;
        while (inMenu) {
            System.out.println("\n--- Medlemsmeny ---");
            System.out.println("1. Lägg till medlem");
            System.out.println("2. Ta bort medlem");
            System.out.println("3. Lista medlemmar");
            System.out.println("4. Sök medlem efter namn");
            System.out.println("5. Lista medlemmar efter status");
            System.out.println("0. Tillbaka");
            System.out.print("Ange val: ");

            int choice = readInt();

            switch (choice) {
                case 1 -> addMember();
                case 2 -> removeMember();
                case 3 -> listMembers();
                case 4 -> searchMember();
                case 5 -> filterMembersByStatus();
                case 0 -> inMenu = false;
                default -> System.out.println("Ogiltigt val, försök igen!");
            }
        }
    }

    private void equipmentMenu() {
        boolean inMenu = true;
        while (inMenu) {
            System.out.println("\n--- Utrustningsmeny ---");
            System.out.println("1. Lägg till skyddsutrusting");
            System.out.println("2. Lägg till skridsko");
            System.out.println("3. Lägg till klubba");
            System.out.println("4. Lista tillgänglig skyggsutrustning");
            System.out.println("5. Lista tillgängliga skridskor");
            System.out.println("6. Lista tillgängliga klubbor");
            System.out.println("7. Hyr skyddsutrustning");
            System.out.println("8. Hyr skridskor");
            System.out.println("9. Hyr klubba");
            System.out.println("0. Tillbaka");
            System.out.print("Ange val: ");

            int choice = readInt();

            switch (choice) {
                case 1 -> addProtectiveGear();
                case 2 -> addSkate();
                case 3 -> addHockeyStick();
                case 4 -> listAvailableProtectiveGear();
                case 5 -> listAvailableSkate();
                case 6 -> listAvailableHockeyStick();
                case 7 -> rentProtectiveGear();
                case 8 -> rentSkate();
                case 9 -> rentHockeyStick();
                case 0 -> inMenu = false;
                default -> System.out.println("Ogiltigt val, försök igen!");
            }
        }
    }

    private void rentalMenu() {
        boolean inMenu = true;
        while (inMenu) {
            System.out.println("\n--- Uthyrningsmeny ---");
            System.out.println("1. Avsluta hyrning");
            System.out.println("2. Visa pågående uthyrningar");
            System.out.println("3. Visa intäkter");
            System.out.println("0. Tillbaka");
            System.out.print("Ange val: ");

            int choice = readInt();

            switch (choice) {
                case 1 -> finishRental();
                case 2 -> listActiveRentals();
                case 3 -> showTotalRevenue();
                case 0 -> inMenu = false;
                default -> System.out.println("Ogiltigt val, försök igen!");
            }
        }
    }

    private void addMember() {
        System.out.print("Namn på medlem: ");
        String name = scanner.nextLine();
        System.out.print("Statusnivå (Standard/Junior): ");
        String status = scanner.nextLine();
        Member member = membershipService.addMember(name, status);
        System.out.println("Medlem tillagd: " + member);
    }

    private void removeMember() {
        System.out.print("Ange medlems-ID att ta bort: ");
        int id = readInt();
        if (membershipService.removeMember(id)) {
            System.out.println("Medlem borttagen.");
        } else {
            System.out.println("Medlemmen finns ej.");
        }
    }

    private void listMembers() {
        System.out.println("\n--- Medlemslista ---");
        for (Member m : membershipService.listAllMembers()) {
            System.out.println(m);
        }
    }

    private void searchMember() {
        System.out.print("Ange namn eller del av namn att söka: ");
        String searchTerm = scanner.nextLine();
        List<Member> results = membershipService.searchMembersByName(searchTerm);
        if (results.isEmpty()) {
            System.out.println("Inga medlemmar matchade sökningen.");
        } else {
            System.out.println("Matchande medlemmar:");
            for (Member m : results) {
                System.out.println(m);
            }
        }
    }

    private void filterMembersByStatus() {
        System.out.print("Ange status att filtrera på (Standard/Junior): ");
        String status = scanner.nextLine();
        List<Member> filtered = membershipService.filterMembersByStatus(status);
        if (filtered.isEmpty()) {
            System.out.println("Inga medlemmar med status " + status);
        } else {
            System.out.println("Medlemmar med status " + status + ":");
            for (Member m : filtered) {
                System.out.println(m);
            }
        }
    }

    private void addProtectiveGear() {
        System.out.print("Typ av skydd:  ");
        String desc = scanner.nextLine();
        System.out.print("Märke: ");
        String type = scanner.nextLine();
        System.out.print("Storlek: ");
        String size = scanner.nextLine();
        ProtectiveGear gear = new ProtectiveGear(desc, type, size);
        inventory.addItem(gear);
        System.out.println("Skyddsutrustning tillagd: " + gear);
    }

    private void addSkate() {
        System.out.print("Märke: ");
        String desc = scanner.nextLine();
        System.out.print("Storlek : ");
        int size = scanner.nextInt();
        Skate skate = new Skate(desc, size);
        inventory.addItem(skate);
        System.out.println("Skridsko tillagd: " + skate);
    }

    private void addHockeyStick() {
        System.out.print("Märke : ");
        String desc = scanner.nextLine();
        System.out.print("Flex på klubban : ");
        String flex = scanner.nextLine();
        System.out.print("Fattnig på klubban : ");
        String hand = scanner.nextLine();
        System.out.print("Material : ");
        String material = scanner.nextLine();
        HockeyStick stick = new HockeyStick(desc, material, hand, flex);
        inventory.addItem(stick);
        System.out.println("Hockeykklibba tillagd: " + stick);
    }

    private void listAvailableProtectiveGear() {
        System.out.println("\n--- Tillgänglig skyddsutrustning ---");
        for (ProtectiveGear pg : inventory.filterByType(ProtectiveGear.class)) {
            if (pg.isAvailable()) {
                System.out.println(pg);
            }
        }
    }

    private void listAvailableSkate() {
        System.out.println("\n--- Tillgängliga skridskor ---");
        for (Skate s : inventory.filterByType(Skate.class)) {
            if (s.isAvailable()) {
                System.out.println(s);
            }
        }
    }

    private void listAvailableHockeyStick() {
        System.out.println("\n--- Tillgängliga klubbor ---");
        for (HockeyStick hs : inventory.filterByType(HockeyStick.class)) {
            if (hs.isAvailable()) {
                System.out.println(hs);
            }
        }
    }

    private void rentProtectiveGear() {
        List<ProtectiveGear> available = inventory.filterByType(ProtectiveGear.class);
        if (available.isEmpty()) {
            System.out.println("Ingen skyddsutrustning tillgängligt för uthyrning.");
            return;
        }
        System.out.println("\n--- Tillgänglig skyddsutrustning ---");
        for (int i = 0; i < available.size(); i++) {
            ProtectiveGear pg = available.get(i);
            System.out.println((i + 1) + ". " + pg);
        }
        System.out.print("Ange medlems-ID: ");
        int memId = readInt();
        System.out.print("Välj skyddsutrustning med nummer: ");
        int choice = readIntInRange(1, available.size());
        ProtectiveGear selected = available.get(choice - 1);
        System.out.print("Startdatum (ÅÅÅÅ-MM-DD): ");
        LocalDate start = LocalDate.parse(scanner.nextLine());
        System.out.print("Slutdatum (ÅÅÅÅ-MM-DD): ");
        LocalDate end = LocalDate.parse(scanner.nextLine());
        Rental rental = rentalService.rentItem(memId, selected.getId(), start, end);
        if (rental != null) {
            System.out.println("Hyrning genomförd: " + rental);
        } else {
            System.out.println("Det gick ej att boka. Kontrollera medlems-ID och att skyddutrustningen är ledig!");
        }
    }

    private void rentSkate() {
        List<Skate> available = inventory.filterByType(Skate.class);
        if (available.isEmpty()) {
            System.out.println("Inga tillgängliga skridskor för uthyrning.");
            return;
        }
        System.out.println("\n--- Tillgängliga skridskor ---");
        for (int i = 0; i < available.size(); i++) {
            Skate s = available.get(i);
            System.out.println((i + 1) + ". " + s);
        }
        System.out.print("Ange medlems-ID: ");
        int memId = readInt();
        System.out.print("Välj skridsko med nummer: ");
        int choice = readIntInRange(1, available.size());
        Skate selected = available.get(choice - 1);
        System.out.print("Startdatum (ÅÅÅÅ-MM-DD): ");
        LocalDate start = LocalDate.parse(scanner.nextLine());
        System.out.print("Slutdatum (ÅÅÅÅ-MM-DD): ");
        LocalDate end = LocalDate.parse(scanner.nextLine());
        Rental rental = rentalService.rentItem(memId, selected.getId(), start, end);
        if (rental != null) {
            System.out.println("Hyrning genomförd: " + rental);
        } else {
            System.out.println("Det gick ej att boka. Kontrollera medlems-ID och att skridskon är ledig!");
        }
    }

    private void rentHockeyStick() {
        List<HockeyStick> available = inventory.filterByType(HockeyStick.class);
        if (available.isEmpty()) {
            System.out.println("Inga tillgängliga klubbor för uthyrning.");
            return;
        }
        System.out.println("\n--- Tillgängliga klubbor ---");
        for (int i = 0; i < available.size(); i++) {
            HockeyStick hs = available.get(i);
            System.out.println((i + 1) + ". " + hs);
        }
        System.out.print("Ange medlems-ID: ");
        int memId = readInt();
        System.out.print("Välj klubba med nummer: ");
        int choice = readIntInRange(1, available.size());
        HockeyStick selected = available.get(choice - 1);
        System.out.print("Startdatum (ÅÅÅÅ-MM-DD): ");
        LocalDate start = LocalDate.parse(scanner.nextLine());
        System.out.print("Slutdatum (ÅÅÅÅ-MM-DD): ");
        LocalDate end = LocalDate.parse(scanner.nextLine());
        Rental rental = rentalService.rentItem(memId, selected.getId(), start, end);
        if (rental != null) {
            System.out.println("Hyrning genomförd: " + rental);
        } else {
            System.out.println("Det gick ej att boka. Kontrollera medlems-ID och att klubban är ledig!");
        }
    }

    private void finishRental() {
        listActiveRentals();
        System.out.print("Ange utrustnings-ID för hyrning som ska avslutas: ");
        String itemId = scanner.nextLine();
        Rental rental = null;
        for (Rental r : rentalService.getActiveRentals()) {
            if (r.getItem().getId().equals(itemId)) {
                rental = r;
                break;
            }
        }
        if (rental == null) {
            System.out.println("Ingen pågående uthyrning för valt ID.");
            return;
        }
        System.out.print("Avslutsdatum (ÅÅÅÅ-MM-DD): ");
        LocalDate retDate = LocalDate.parse(scanner.nextLine());
        double total = rentalService.finishRental(rental, retDate);
        System.out.println("Hyra avslutad. Slutpris: " + total + " kr");
    }

    private void listActiveRentals() {
        System.out.println("\n--- Pågående uthyrningar ---");
        for (Rental r : rentalService.getActiveRentals()) {
            System.out.println(r);
        }
    }

    private void showTotalRevenue() {
        System.out.println("Totala intäkter: " + rentalService.getTotalRevenue() + " kr");
    }

    private int readInt() {
        while (true) {
            try {
                String input = scanner.nextLine();
                return Integer.parseInt(input.trim());
            } catch (NumberFormatException e) {
                System.out.print("Felaktig siffra, försök igen: ");
            }
        }
    }

    private int readIntInRange(int min, int max) {
        while (true) {
            int choice = readInt();
            if (choice >= min && choice <= max) {
                return choice;
            }
            System.out.print("Valet måste vara mellan " + min + " och " + max + ", försök igen: ");
        }
    }
}

