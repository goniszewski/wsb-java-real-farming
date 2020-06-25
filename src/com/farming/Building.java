package com.farming;

import java.util.Random;

public class Building {

    private String type;
    private Integer canHoldAnimals;
    private Integer canHoldSeeds;
    private Integer price;

    public void buyBuilding(Player player, Farm farm) {
        if (player.getCash() > this.getPrice()) {
            farm.AddBuilding(this);
            player.setCash(player.getCash() - this.getPrice());
            System.out.println("Zakupiono budynek!");
        } else {
            System.out.println("Niewystarczająca ilość funduszy.");
        }
    }

    public Building(String type, Integer canHoldAnimals, Integer canHoldSeeds, Integer price) {
        this.type = type;
        this.canHoldAnimals = canHoldAnimals;
        this.canHoldSeeds = canHoldSeeds;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Budynek" +
                "rodzaj: '" + type + '\'' +
                ", nada się na zwierzęta: " + (canHoldAnimals>0) +
                ", nada się na ziarna/plony: " + (canHoldSeeds>0) +
                ", cena: " + price;
    }

    public String getType() {
        return type;
    }

    public Integer getCanHoldAnimals() {
        return canHoldAnimals;
    }

    public Integer getCanHoldSeeds() {
        return canHoldSeeds;
    }

    public Integer getPrice() {
        return price;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCanHoldAnimals(Integer canHoldAnimals) {
        this.canHoldAnimals = canHoldAnimals;
    }

    public void setCanHoldSeeds(Integer canHoldSeeds) {
        this.canHoldSeeds = canHoldSeeds;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    private static Integer randInt(Integer min, Integer max) {
        return new Random().nextInt((max - min) + 1) + min;
    }


}