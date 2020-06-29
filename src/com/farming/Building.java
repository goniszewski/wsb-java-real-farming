package com.farming;

import java.util.Random;

public class Building {

    private String type;
    private Integer canHoldAnimals;
    private Integer canHoldStocks;
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

    public Building(String type, Integer canHoldAnimals, Integer canHoldStocks, Integer price) {
        this.type = type;
        this.canHoldAnimals = canHoldAnimals;
        this.canHoldStocks = canHoldStocks;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Budynek" +
                "rodzaj: '" + type + '\'' +
                ", nada się na zwierzęta: " + (canHoldAnimals>0) +
                ", nada się na ziarna/plony: " + (canHoldStocks >0) +
                ", cena: " + price;
    }

    public String getType() {
        return type;
    }

    public Integer getCanHoldAnimals() {
        return canHoldAnimals;
    }

    public Integer getCanHoldStocks() {
        return canHoldStocks;
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

    public void setCanHoldStocks(Integer canHoldStocks) {
        this.canHoldStocks = canHoldStocks;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    private static Integer randInt(Integer min, Integer max) {
        return new Random().nextInt((max - min) + 1) + min;
    }


}