package com.farming;

public class Crop {

    private String name;
    private Integer age;
    private Integer sellPricePerKg;
    private Boolean canSell;
    private Integer growingTime;
    private Boolean canFeedAnimals;
    private Integer protectionCost;
    private Integer kgPerH;
    private Integer harvestCost;

    public Crop(String name, Integer seedsPrice, Integer sellPricePerKg, Boolean canSell, Integer growingTime, Integer canBePlantedStartedIn, Integer mustBePlantedBefore, Boolean canUseSeeds, Boolean canFeedAnimals, Integer protectionCost, Integer kgPerH, Integer harvestCost) {
        this.name = name;
        this.age = 0;
        this.sellPricePerKg = sellPricePerKg;
        this.canSell = canSell;
        this.growingTime = growingTime;
        this.canFeedAnimals = canFeedAnimals;
        this.protectionCost = protectionCost;
        this.kgPerH = kgPerH;
        this.harvestCost = harvestCost;

    }


    public void plantCrop(Farm farm, Player player) {
           setAge(age+1);
    }

    public void harvestCrop(Farm farm, Player player) {
        if (player.getCash() < harvestCost) {
            System.out.println("Brak wystarczających funduszy.");
        } else if (growingTime>age) {
            System.out.println("Za wcześnie na zbiory. Poczekaj jeszcze " + (growingTime-age) + " tygodni.");
        }
    }


    @Override
    public String toString() {
        return "Roślina" +
                "nazwa: '" + name + '\'' +
                ", wiek: " + age +
                ", cena za kg: " + sellPricePerKg +
                ", można już sprzedać: " + canSell +
                ", rośnie przez: " + growingTime +
                ", można tym karmić zwierzęta: " + canFeedAnimals +
                ", koszt pestycydów: " + protectionCost +
                ", ton na hektar: " + kgPerH +
                ", koszt zebrania plonów: " + harvestCost;
    }

    //getters
    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }


    public Integer getSellPricePerKg() {
        return sellPricePerKg;
    }

    public Boolean getCanSell() {
        return canSell;
    }

    public Integer getGrowingTime() {
        return growingTime;
    }


    public Boolean getCanFeedAnimals() {
        return canFeedAnimals;
    }

    public Integer getProtectionCost() {
        return protectionCost;
    }

    public Integer getKgPerH() {
        return kgPerH;
    }

    public Integer getHarvestCost() {
        return harvestCost;
    }

    //setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setSellPricePerKg(Integer sellPricePerKg) {
        this.sellPricePerKg = sellPricePerKg;
    }

    public void setCanSell(Boolean canSell) {
        this.canSell = canSell;
    }

    public void setGrowingTime(Integer growingTime) {
        this.growingTime = growingTime;
    }

    public void setCanFeedAnimals(Boolean canFeedAnimals) {
        this.canFeedAnimals = canFeedAnimals;
    }

    public void setProtectionCost(Integer protectionCost) {
        this.protectionCost = protectionCost;
    }

    public void setKgPerH(Integer kgPerH) {
        this.kgPerH = kgPerH;
    }

    public void setHarvestCost(Integer harvestCost) {
        this.harvestCost = harvestCost;
    }

}
