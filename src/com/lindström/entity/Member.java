package com.lindström.entity;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private String name;
    private String level;
    private int id;
    private static int nextId = 1;
    private final List<Rental> rentalHistory;


    public Member(String name, String level, List<Rental> rentalHistory) {
        this.id = nextId++;
        this.name = name;
        this.rentalHistory = new ArrayList<>();
        this.level = level;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Member.nextId = nextId;
    }

    public List<Rental> getRentalHistory() {
        return rentalHistory;
    }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", level='" + level + '\'' +
                ", id=" + id +
                ", rentalHistory=" + rentalHistory +
                '}';
    }
}
