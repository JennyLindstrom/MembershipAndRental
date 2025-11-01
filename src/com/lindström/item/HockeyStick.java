package com.lindström.item;

public class HockeyStick extends Item {

    private String flex;
    private String hand;
    private String material;


    public HockeyStick(String description, String material, String flex, String hand) {
        super(description);
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

    public void setFlex(String flex) {
        this.flex = flex;
    }

    public void setHand(String hand) {
        this.hand = hand;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return "HockeyStick{" +
                "flex='" + flex + '\'' +
                ", hand='" + hand + '\'' +
                ", material='" + material + '\'' +
                '}';
    }
}
