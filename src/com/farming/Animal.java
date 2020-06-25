package com.farming;

import java.util.Arrays;

public class Animal {

    private String species;
    private Integer age;
    private Integer weight;
    private Integer weightGain;
    private Integer matureInWeeks;
    private Integer eats;
    private Boolean canReproduce;
    private Integer reproductionChance;
    private Boolean canSell;
    private Integer buyPrice;
    private Integer sellPrice;
    private Object[] givesPerWeek;

    public Animal(String species, Integer weight, Integer weightGain, Integer matureInWeeks, Integer eats, Integer reproductionChance, Boolean canSell, Integer buyPrice, Integer sellPrice, Object[] givesPerWeek) {
        this.species = species;
        this.age = 1;
        this.weight = weight;
        this.weightGain = weightGain;
        this.matureInWeeks = matureInWeeks;
        this.eats = eats;
        this.reproductionChance = reproductionChance;
        this.canSell = canSell;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
        this.givesPerWeek = givesPerWeek;
    }

    public void buyAnimal(Player player, Farm farm) {
        if (player.getCash() >= buyPrice && farm.canAddAnimals() > 0) {
            farm.addAnimal(this);
            player.setCash(player.getCash() - buyPrice);
            System.out.println("Kupiłeś 1x " + species);
            System.out.println("Pozostało " + player.getCash() + " PLN.");
        }
    }

    @Override
    public String toString() {
        return "Zwierzę" +
                "gatunek: '" + species + '\'' +
                ", wiek (w tyg.): " + age +
                ", waga: " + weight +
                ", wzrost kg/tydzień: " + weightGain +
                ", dojrzewa w tyg.: " + matureInWeeks +
                ", zjada: " + eats +
                ", gotowość do rozrodu: " + canReproduce +
                ", szansa na ciążę: " + reproductionChance +
                ", można sprzedać: " + canSell +
                ", cena zakupu: " + buyPrice +
                ", cena sprzedaży: " + sellPrice +
                ", zapewnia na tydzień: " + Arrays.toString(givesPerWeek) +
                '}';
    }

    //Getters
    public String getSpecies() {
        return species;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getWeight() {
        return weight;
    }

    public Integer getWeightGain() {
        return weightGain;
    }

    public Integer getMatureInWeeks() {
        return matureInWeeks;
    }

    public Integer getEats() {
        return eats;
    }

    public Boolean getCanReproduce() {
        return canReproduce;
    }

    public Integer getReproductionChance() {
        return reproductionChance;
    }

    public Boolean getCanSell() {
        return canSell;
    }

    public Integer getBuyPrice() {
        return buyPrice;
    }

    public Integer getSellPrice() {
        return sellPrice;
    }

    public Object[] getGivesPerWeek() {
        return givesPerWeek;
    }

    //Setters
    public void setSpecies(String species) {
        this.species = species;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public void setWeightGain(Integer weightGain) {
        this.weightGain = weightGain;
    }

    public void setMatureInWeeks(Integer matureInWeeks) {
        this.matureInWeeks = matureInWeeks;
    }

    public void setEats(Integer eats) {
        this.eats = eats;
    }

    public void setCanReproduce(Boolean canReproduce) {
        this.canReproduce = canReproduce;
    }

    public void setReproductionChance(Integer reproductionChance) {
        this.reproductionChance = reproductionChance;
    }

    public void setCanSell(Boolean canSell) {
        this.canSell = canSell;
    }

    public void setBuyPrice(Integer buyPrice) {
        this.buyPrice = buyPrice;
    }

    public void setSellPrice(Integer sellPrice) {
        this.sellPrice = sellPrice;
    }

    public void setGivesPerWeek(Object[] givesPerWeek) {
        this.givesPerWeek = givesPerWeek;
    }


}
