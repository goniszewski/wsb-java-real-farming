package com.farming;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

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

    public Integer priceFluctuations(int value) {
        Integer randomPrice = ThreadLocalRandom.current().nextInt(1, ((int) value+2) );
        Integer random = (int) (Math.random() * 100);
        if (random <= 20) {
            return (Integer) Math.max(random, 1);
        } else if (random >= 80) {
            return (Integer) (-random);
        }
        return (Integer)0;
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
        return sellPricePerKg+priceFluctuations(sellPricePerKg);
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

