package com.farming;

import java.util.concurrent.ThreadLocalRandom;

public class Seeds {
    private String name;
    private Integer buyPricePerKg;
    private Integer sellPricePerKg;
    private Integer quantityInKg;
    private Integer canBePlantedStartedIn;
    private Integer mustBePlantedBefore;
    private Boolean canUseSeeds;
    private Integer groundPreparingCost;
    private Integer needsKgPerH;
    //crop info
    private Crop toCrop;


    public Seeds(String name, Integer buyPricePerKg, Integer sellPricePerKg, Integer quantityInKg,
                 Integer canBePlantedStartedIn, Integer mustBePlantedBefore, Boolean canUseSeeds,
                 Integer groundPreparingCost, Integer needsKgPerH, Crop toCrop) {
        this.name = name;
        this.buyPricePerKg = buyPricePerKg;
        this.sellPricePerKg = sellPricePerKg;
        this.quantityInKg = quantityInKg;
        this.canBePlantedStartedIn = canBePlantedStartedIn;
        this.mustBePlantedBefore = mustBePlantedBefore;
        this.canUseSeeds = canUseSeeds;
        this.groundPreparingCost = groundPreparingCost;
        this.needsKgPerH = needsKgPerH;
        this.toCrop = toCrop;
    }


    public Integer priceFluctuations(int value) {
        Integer randomPrice = ThreadLocalRandom.current().nextInt(1, ((int) value+2) );
        Integer random = (int) (Math.random() * 100);
        if (random <= 20) {
            return (Integer) Math.max(random,1);
        } else if (random >= 80) {
            return (Integer) (-random);
        }
        return (Integer)0;
    }

    public void plantSeeds(Player player) {

        if (player.getCash() < groundPreparingCost) {
            System.out.println("Brak wystarczających funduszy.");
        } else if ((mustBePlantedBefore < player.getWeek()) || (player.getWeek() < canBePlantedStartedIn)) {
            System.out.println("Roślina musi być zasadzona między " + canBePlantedStartedIn + " a " +
                    mustBePlantedBefore + " tygodniem roku.");
        } else if (player.getFarm().displayFreeHectares() < 1) {
            System.out.println("Masz za mało ziemi.");
        } else {
            for (Seeds storedSeeds : player.getFarm().getSeeds()) {
                if ((storedSeeds.getName().equals(name) && (storedSeeds.getQuantityInKg() >= needsKgPerH))) {
                    player.setCash(player.getCash() - groundPreparingCost);
                    player.getFarm().removeStock(this);
                    player.getFarm().addCrop(toCrop);
                    System.out.println("Zasiano: " + name);
                    player.getFarm().reserveField(1);
                    break;
                } else if (storedSeeds.name.equals(name)) {
                    System.out.println("Brak wystarczającej ilości nasion (potrzeba " + needsKgPerH + " kg/ha).");
                    break;
                } else {
                    System.out.println("Nie posiadasz takich nasion.");
                }
            }
        }
    }


    @Override
    public String toString() {
        String text = "";
        try {
            text = name +
                    "\nilość na stanie: " + (quantityInKg.equals(-1) ? "~" : quantityInKg) + " kg" +
                    ", \ncena zakupu /kg: " + buyPricePerKg + " zł" +
                    ", \ncena sprzedaży /kg: " + sellPricePerKg + " zł" +
                    ", \nilość potrzebna do zasadzenia 1 ha: " + needsKgPerH + " kg (" +
                    needsKgPerH * buyPricePerKg + " zł)" +
                    ", \nmożna posadzić w tyg.: " + canBePlantedStartedIn +
                    ", \nnależy posadzić przed tyg.: " + mustBePlantedBefore +
                    ", \nmożna zasadzić z plonów: " + (canUseSeeds ? "tak" : "nie") + "\n";
        } catch (NullPointerException e) {
            text = "O, Null";
        }
        return text;
    }

    //getters
    public String getName() {
        return name;
    }

    public Integer getBuyPricePerKg() {
        return buyPricePerKg+priceFluctuations(buyPricePerKg);
    }

    public Integer getSellPricePerKg() {
        return sellPricePerKg+priceFluctuations(sellPricePerKg);
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

    public Integer getQuantityInKg() {
        return quantityInKg;
    }

    public Integer getNeedsKgPerH() {
        return needsKgPerH;
    }

    public Crop getToCrop() {
        return toCrop;
    }

    //setters
    public void setName(String name) {
        this.name = name;
    }

    public void setBuyPricePerKg(Integer buyPricePerKg) {
        this.buyPricePerKg = buyPricePerKg;
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

    public void setQuantityInKg(Integer quantityInKg) {
        this.quantityInKg = quantityInKg;
    }

    public void setNeedsKgPerH(Integer needsKgPerH) {
        this.needsKgPerH = needsKgPerH;
    }

    public void setToCrop(Crop toCrop) {
        this.toCrop = toCrop;
    }
}

