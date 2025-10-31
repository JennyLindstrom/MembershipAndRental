package com.lindström.entity;

public class HockeyStick extends Item {

    private final String flex;
    private final String hand;
    private final String material;

    public HockeyStick(double basePrice, String name, String flex, String hand, String material) {
        super(basePrice, name);
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
    public String toString() {
        return "HockeyStick{" +
                "flex='" + flex + '\'' +
                ", hand='" + hand + '\'' +
                ", material='" + material + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
