package com.lindström.entity;

public class HockeyStick extends Item{

    private String flex;
    private String hand;
    private String material;

    public HockeyStick(int id, String name, String flex, String hand, String material) {
        super(id, name);
        this.flex = flex;
        this.hand = hand;
        this.material = material;
    }

    public String getFlex() {
        return flex;
    }

    public String getHand() {
        return hand;
    }

    public String getMaterial() {
        return material;
    }

    @Override
    public String getInfo() {
        return "Klubba: " + name + " (" + material + ", flex: " + flex + ", hand: " + hand + ")";
    }
}
