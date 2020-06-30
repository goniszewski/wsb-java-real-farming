package com.farming;

import java.util.Random;

public class Building {

    private String type;
    private Integer canHoldAnimals;
    private Integer canHoldStocks;
    private Integer price;

    public Building(String type, Integer canHoldAnimals, Integer canHoldStocks, Integer price) {
        this.type = type;
        this.canHoldAnimals = canHoldAnimals;
        this.canHoldStocks = canHoldStocks;
        this.price = price;
    }

    @Override
    public String toString() {
        return type +
                ",\n może przechowywać zwierząt: " + canHoldAnimals + " szt."+
                ",\n może przechowywać zbiorów: " + canHoldStocks/1000 + " ton" +
                ",\n cena zakupu: " + price + " zł\n";
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