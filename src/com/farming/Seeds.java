package com.farming;

public class Seeds {
    private String name;
    private Integer seedsPrice;
    private Integer sellPricePerKg;
    private Integer canBePlantedStartedIn;
    private Integer mustBePlantedBefore;
    private Boolean canUseSeeds;
    private Integer groundPreparingCost;
    //crop info
    private Crop toCrop;


    public Seeds(String name, Integer seedsPrice, Integer sellPricePerKg, Integer canBePlantedStartedIn, Integer mustBePlantedBefore, Boolean canUseSeeds, Integer groundPreparingCost, Crop toCrop) {
        this.name = name;
        this.seedsPrice = seedsPrice;
        this.sellPricePerKg = sellPricePerKg;
        this.canBePlantedStartedIn = canBePlantedStartedIn;
        this.mustBePlantedBefore = mustBePlantedBefore;
        this.canUseSeeds = canUseSeeds;
        this.groundPreparingCost = groundPreparingCost;
        this.toCrop = toCrop;
    }

    public void plantSeeds(Farm farm, Player player) {
        if (player.getCash() < groundPreparingCost) {
            System.out.println("Brak wystarczających funduszy.");
        } else if (mustBePlantedBefore > player.getWeek() && player.getWeek() > canBePlantedStartedIn) {
            System.out.println("Roślina musi być zasadzona między " + canBePlantedStartedIn + " a " + mustBePlantedBefore + " tygodniem roku.");
        } else if (farm.displayFreeHectares() < 1) {
            System.out.println("Masz za mało ziemi.");
        } else {
            player.setCash(player.getCash() - groundPreparingCost);
            player.getFarm().addCrop(toCrop);
            System.out.println("Zasiano: " + name);
        }
    }

    @Override
    public String toString() {
        String text = "";
        try {
            text = "Nasiona" +
                    "nazwa: '" + name + '\'' +
                    ", cena zakupu /kg: " + seedsPrice +
                    ", cena sprzedaży /kg: " + sellPricePerKg +
                    ", można posadzić w tyg.: " + canBePlantedStartedIn +
                    ", należy posadzić przed tyg.: " + mustBePlantedBefore +
                    ", można zasadzić z plonów: " + canUseSeeds;
        } catch (NullPointerException e) {
            text = "O, Null";
        }
        return text;
    }

    //getters
    public String getName() {
        return name;
    }

    public Integer getSeedsPrice() {
        return seedsPrice;
    }

    public Integer getSellPricePerKg() {
        return sellPricePerKg;
    }

    public Integer getCanBePlantedStartedIn() {
        return canBePlantedStartedIn;
    }

    public Integer getMustBePlantedBefore() {
        return mustBePlantedBefore;
    }

    public Boolean getCanUseSeeds() {
        return canUseSeeds;
    }

    public Integer getGroundPreparingCost() {
        return groundPreparingCost;
    }

    //setters
    public void setName(String name) {
        this.name = name;
    }

    public void setSeedsPrice(Integer seedsPrice) {
        this.seedsPrice = seedsPrice;
    }

    public void setSellPricePerKg(Integer sellPricePerKg) {
        this.sellPricePerKg = sellPricePerKg;
    }

    public void setCanBePlantedStartedIn(Integer canBePlantedStartedIn) {
        this.canBePlantedStartedIn = canBePlantedStartedIn;
    }

    public void setMustBePlantedBefore(Integer mustBePlantedBefore) {
        this.mustBePlantedBefore = mustBePlantedBefore;
    }

    public void setCanUseSeeds(Boolean canUseSeeds) {
        this.canUseSeeds = canUseSeeds;
    }

    public void setGroundPreparingCost(Integer groundPreparingCost) {
        this.groundPreparingCost = groundPreparingCost;
    }
}

