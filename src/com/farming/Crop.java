package com.farming;

public class Crop {

    private String name;
    private Integer age;
    private Integer seedsPrice;
    private Integer sellPricePerKg;
    private Boolean canSell;
    private Integer growingTime;
    private Integer canBePlantedIn;
    private Boolean canUseSeeds;
    private Integer protectionCost;
    private Integer groundPreparingCost;
    private Integer tonsPerHectar;
    private Integer harvestCost;

//getters
    public String getName() {
        return name;
    }
    public Integer getAge() {
        return age;
    }
    public Integer getSeedsPrice() {
        return seedsPrice;
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
    public Integer getCanBePlantedIn() {
        return canBePlantedIn;
    }
    public Boolean getCanUseSeeds() {
        return canUseSeeds;
    }
    public Integer getProtectionCost() {
        return protectionCost;
    }
    public Integer getGroundPreparingCost() {
        return groundPreparingCost;
    }
    public Integer getTonsPerHectar() {
        return tonsPerHectar;
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
    public void setSeedsPrice(Integer seedsPrice) {
        this.seedsPrice = seedsPrice;
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
    public void setCanBePlantedIn(Integer canBePlantedIn) {
        this.canBePlantedIn = canBePlantedIn;
    }
    public void setCanUseSeeds(Boolean canUseSeeds) {
        this.canUseSeeds = canUseSeeds;
    }
    public void setProtectionCost(Integer protectionCost) {
        this.protectionCost = protectionCost;
    }
    public void setGroundPreparingCost(Integer groundPreparingCost) {
        this.groundPreparingCost = groundPreparingCost;
    }
    public void setTonsPerHectar(Integer tonsPerHectar) {
        this.tonsPerHectar = tonsPerHectar;
    }
    public void setHarvestCost(Integer harvestCost) {
        this.harvestCost = harvestCost;
    }
}
