package com.farming;

public class Animal {

    private String species;
    private Integer age = 1;
    private Integer weight = 0;
    private Integer eatsWeightWorthPerWeek = 0;
    private Integer weightGain = getWeightGain();
    private Integer matureInWeeks;
    private Integer eats = getEats();
    private Boolean canReproduce = (age == matureInWeeks);
    private Integer reproductionChance;
    private Boolean canSell;
    private Integer buyPricePerKg;
    private Integer buyPriceMultiplier = 5;
    private Integer sellPricePerKg;
    private Resource givesPerWeek;


    public Animal(String species, Integer weight, Integer eatsWeightWorthPerWeek, Integer matureInWeeks, Integer reproductionChance, Boolean canSell, Integer buyPricePerKg, Integer sellPricePerKg, Resource givesPerWeek) {
        this.species = species;
        this.weight = weight;
        this.eatsWeightWorthPerWeek = eatsWeightWorthPerWeek;
        this.matureInWeeks = matureInWeeks;
        this.reproductionChance = reproductionChance;
        this.canSell = canSell;
        this.buyPricePerKg = buyPricePerKg;
        this.sellPricePerKg = sellPricePerKg;
        this.givesPerWeek = givesPerWeek;
    }

    public void gainWeight() {
        if (matureInWeeks > 1) {
            weight += getWeightGain();
        }
    }

    public Integer getWeightGain() {
        return (weight * eatsWeightWorthPerWeek / 100) + 1;
    }

    public Integer getEats() {
        return (weight * eatsWeightWorthPerWeek) + 1;
    }

    @Override
    public String toString() {
        return species +
                ", \nwiek /tyg: " + age +
                ", \nwaga: " + weight + " kg" +
                ", \nwzrost kg/tydzień: " + getWeightGain() +
                ", \ndojrzewa w: " + matureInWeeks + " tyg." +
                ", \nzjada /tyg: " + getEats() + " kg" +
                ", \ngotowość do rozrodu: " + (canReproduce ? "tak" : "nie") +
                ", \nszansa na ciążę: " + reproductionChance + "%" +
                ", \nmożna sprzedać: " + (canSell ? "tak" : "jeszcze nie") +
                ", \ncena zakupu /kg: " + buyPricePerKg + " zł (+ " + (buyPricePerKg * buyPriceMultiplier) + " zł opłat)" +
                ", \ncena sprzedaży /kg: " + sellPricePerKg + " zł (" + (sellPricePerKg * weight) + " zł obecnie)" +
                ", \nzapewnia na tydzień: " + givesPerWeek.name + "(" + givesPerWeek.quantity + " " + givesPerWeek.unitToDisplay + " * " + givesPerWeek.sellPriceByUnit + " zł)\n";
    }


    //Getters

    public Integer getBuyPrice() {
        return buyPricePerKg * weight * buyPriceMultiplier;
    }

    public String getSpecies() {
        return species;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getWeight() {
        return weight;
    }

    public Integer getEatsWeightWorthPerWeek() {
        return eatsWeightWorthPerWeek;
    }

    public Integer getMatureInWeeks() {
        return matureInWeeks;
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

    public Integer getBuyPricePerKg() {
        return buyPricePerKg * buyPriceMultiplier;
    }

    public Integer getSellPricePerKg() {
        return sellPricePerKg;
    }

    public Resource getGivesPerWeek() {
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

    public void setEatsWeightWorthPerWeek(Integer eatsWeightWorthPerWeek) {
        this.eatsWeightWorthPerWeek = eatsWeightWorthPerWeek;
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

    public void setBuyPricePerKg(Integer buyPricePerKg) {
        this.buyPricePerKg = buyPricePerKg;
    }

    public void setSellPricePerKg(Integer sellPricePerKg) {
        this.sellPricePerKg = sellPricePerKg;
    }

    public void setGivesPerWeek(Resource givesPerWeek) {
        this.givesPerWeek = givesPerWeek;
    }
}
