package com.farming;

public class Crop {

    private String name;
    private Integer age;
    private Integer growingTime;
    private Integer protectionCostPerH;
    private String seedsFromHarvest;
    private String yieldFromHarvest;
    private Integer givesKgPerH;
    private Integer harvestCost;

    public Crop(String name, Integer growingTime, Integer protectionCostPerH, String seedsFromHarvest,
                String yieldFromHarvest, Integer givesKgPerH, Integer harvestCost) {
        this.name = name;
        this.age = 0;
        this.growingTime = growingTime;
        this.protectionCostPerH = protectionCostPerH;
        this.seedsFromHarvest = seedsFromHarvest;
        this.yieldFromHarvest = yieldFromHarvest;
        this.givesKgPerH = givesKgPerH;
        this.harvestCost = harvestCost;
    }

    public void harvestCrop(Player player) {
        if (player.getCash() < harvestCost) {
            System.out.println("\nBrak wystarczających funduszy.\n");
        } else if (growingTime > age) {
            System.out.println("\nZa wcześnie na zbiory. Poczekaj jeszcze " + (growingTime - age) + " tygodni.\n");
        } else if ((player.getFarm().canHoldStocks() - player.getFarm().nowHoldsStocks()) < givesKgPerH) {
            System.out.println("\nMasz za mało miejsca na magazynowanie zbiorów.\n");
        } else {
            player.getFarm().addStocks(this, player);
            player.setCash(player.getCash() - harvestCost);
            player.getFarm().releaseField(1);
            player.getFarm().getCrops().remove(this);
            System.out.println("Żniwa zostały zebrane.");
        }
    }

    public void chanceOfParasites(Player player) {
        int random = (int) (Math.random() * 100);
        if (age > (int) growingTime / 2 && 10 >= random) {
            System.out.println("\n\n\nSusza? Powódź? Stonka?!\nTracisz 1 hektar upraw: " + name + "\n\n\n");
            player.getFarm().removeCrop(this);
            player.getFarm().releaseField(1);
        }
    }


    @Override
    public String toString() {
        return name +
                ":\nwiek/rośnie przez: " + age +
                "/" + growingTime +
                " tyg," +
                (age >= growingTime ? " <- gotowe do zbioru ✔" : "") +
                "\nkoszt pestycydów: " + protectionCostPerH +
                "/tydzień, \nsurowca/h: " + givesKgPerH +
                " kg, \nkoszt zebrania plonów: " + harvestCost + " zł\n";
    }

    //getters


    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getGrowingTime() {
        return growingTime;
    }

    public Integer getProtectionCostPerH() {
        return protectionCostPerH;
    }

    public String getSeedsFromHarvest() {
        return seedsFromHarvest;
    }

    public String getYieldFromHarvest() {
        return yieldFromHarvest;
    }

    public Integer getGivesKgPerH() {
        return givesKgPerH;
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

    public void setGrowingTime(Integer growingTime) {
        this.growingTime = growingTime;
    }

    public void setProtectionCostPerH(Integer protectionCostPerH) {
        this.protectionCostPerH = protectionCostPerH;
    }

    public void setSeedsFromHarvest(String seedsFromHarvest) {
        this.seedsFromHarvest = seedsFromHarvest;
    }

    public void setYieldFromHarvest(String yieldFromHarvest) {
        this.yieldFromHarvest = yieldFromHarvest;
    }

    public void setGivesKgPerH(Integer givesKgPerH) {
        this.givesKgPerH = givesKgPerH;
    }

    public void setHarvestCost(Integer harvestCost) {
        this.harvestCost = harvestCost;
    }
}
