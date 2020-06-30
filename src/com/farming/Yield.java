package com.farming;

import java.util.ArrayList;

public class Yield {
    private String name;
    private Integer sellPricePerKg;
    private Boolean canFeedAnimals;
    private Integer quantityInKg;

    public Yield(String name, Integer sellPricePerKg, Boolean canFeedAnimals, Integer quantityInKg) {
        this.name = name;
        this.sellPricePerKg = sellPricePerKg;
        this.canFeedAnimals = canFeedAnimals;
        this.quantityInKg = quantityInKg;
    }

    @Override
    public String toString() {
        return name +
                ", \nilość na stanie: " + quantityInKg + " kg" +
                ", \ncena sprzedaży: " + sellPricePerKg + " zł" +
                ", \nmożna karmić zwierzęta: " + (canFeedAnimals ? "tak" : "nie") +
                "\n";
    }

    public int feedAnimal(ArrayList<Animal> animals) {
        int eated = 0;
        for (Animal animal : animals) {
            eated += animal.getEats();
        }
        quantityInKg -= eated;
        return eated;
    }

    //getters
    public String getName() {
        return name;
    }

    public Integer getSellPricePerKg() {
        return sellPricePerKg;
    }

    public Boolean getCanFeedAnimals() {
        return canFeedAnimals;
    }

    public Integer getQuantityInKg() {
        return quantityInKg;
    }


    //setters
    public void setName(String name) {
        this.name = name;
    }

    public void setSellPricePerKg(Integer sellPricePerKg) {
        this.sellPricePerKg = sellPricePerKg;
    }

    public void setCanFeedAnimals(Boolean canFeedAnimals) {
        this.canFeedAnimals = canFeedAnimals;
    }

    public void setQuantityInKg(Integer quantityInKg) {
        this.quantityInKg = quantityInKg;
    }

}

