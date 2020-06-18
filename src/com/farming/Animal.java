package com.farming;

public class Animal {

    private String species;
    private Integer age;
    private Integer weight;
    private Integer weightGain;
    private Integer matureInWeeks;
    private Object[] eats;
    private Boolean canReproduce;
    private Integer reproductionChance;
    private Boolean canSell;
    private Integer buyPrice;
    private Integer sellPrice;
    private Object[] givesPerWeek;

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
    public Object[] getEats() {
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
    public void setEats(Object[] eats) {
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
