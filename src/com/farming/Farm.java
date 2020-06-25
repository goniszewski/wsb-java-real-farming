package com.farming;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Farm {
    private Integer price;
    private ArrayList<Building> buildings;
    private ArrayList<Crop> crops;
    private ArrayList<Animal> animals;
    private ArrayList<Seeds> seeds = new ArrayList<>();
    private Integer fieldsInHectares = 0;
    private Integer usedHectares = 0;
    private final Integer cashPerHectare = 50000;


    public Farm(Integer price, ArrayList<Building> buildings, Integer fieldsInHectares) {
        this.buildings = buildings;
        this.crops = new ArrayList<>();
        this.animals = new ArrayList<>();
        this.fieldsInHectares = ThreadLocalRandom.current().nextInt(1, 11);
        this.price = (fieldsInHectares * cashPerHectare);
    }

    @Override
    public String toString() {
        return "Farma " +
                "\ncena zakupu: " + price +
                ", \nbudynki: " + displayBuildings() +
                " \nzasiano: " + displayCrops() +
                ", \nnasiona: " + displaySeeds() +
                ", \nzwierzęta: " + displayAnimals() +
                ", \nhektarów ziemi: " + fieldsInHectares +
                ", \nhektarów w użyciu: " + usedHectares + "\n";
    }

    public String displayBuildings() {
        StringBuilder list = new StringBuilder();
        for (Building building : buildings) {
            list.append("" + building.getType());
            if (building.getCanHoldAnimals() != 0) {
                list.append(" (max zwierząt: " + building.getCanHoldAnimals() + "), ");
            }
            if (building.getCanHoldSeeds() != 0) {
                list.append(" (max ton ziarna: " + building.getCanHoldSeeds() / 1000 + "), ");
            }

        }
        return list.toString();
    }

    public String displayCrops() {
        StringBuilder list = new StringBuilder();
        for (Crop crop : crops) {
            list.append("" + crop.getName() + " (tygodni: " + crop.getAge() + "/" + crop.getGrowingTime() + ",");
        }
        return (list.toString().length()<10?"brak":list.toString());
    }

    public String displaySeeds() {
        StringBuilder list = new StringBuilder();
        for (Seeds seeds : seeds) {
            list.append("" + seeds.getName() + ",");
        }
        return (list.toString().length()<10?"brak":list.toString());
    }

    public String displayAnimals() {
        StringBuilder list = new StringBuilder();
        for (Animal animal : animals) {
            list.append("" + animal.getSpecies() + " (tygodni: " + animal.getAge() + "/" + animal.getMatureInWeeks() + ",");
        }
        return (list.toString().length()<10?"brak":list.toString());
    }

    public Integer displayFreeHectares() {
        return fieldsInHectares - usedHectares;
    }

    public void reserveField(Integer hectares) {
        setUsedHectares(usedHectares + hectares);
        System.out.println("Pozostało " + displayFreeHectares() + " ha wolnej ziemi uprawnej.");
    }

    public void releaseField(Integer hectares) {
        setUsedHectares(usedHectares - hectares);
        System.out.println("Pozostało " + displayFreeHectares() + " ha wolnej ziemi uprawnej.");
    }

    public void buyField(Player player) {
        if (player.getCash() > cashPerHectare) {
            fieldsInHectares += 1;
            player.setCash(player.getCash() - cashPerHectare);
            System.out.println("Kupiono hektar ziemi!");
        } else {
            System.out.println("Brak wystarczających funduszy.");
        }
    }

    public void sellField(Player player) {
        if (fieldsInHectares > 0) {
            fieldsInHectares -= 1;
            player.setCash(player.getCash() + cashPerHectare);
            System.out.println("Sprzedano hektar ziemi!");
        } else {
            System.out.println("Brak wystarczającej ilości ziemi.");
        }
    }

    public Integer canHoldAnimals() {
        Integer canHold = 0;
        for (Building building : buildings) {
            canHold += building.getCanHoldAnimals();
        }
        return canHold;
    }

    public Integer nowHoldsAnimals() {
        return animals.size();
    }

    public Integer canAddAnimals() {
        return canHoldAnimals() - nowHoldsAnimals();
    }

    public Integer canHoldCrops() {
        Integer canHold = 0;
        for (Building building : buildings) {
            canHold += building.getCanHoldSeeds();
        }
        return canHold;
    }

    public Integer nowHoldsCrops() {
        return crops.size();
    }


    //getters

    public Integer getPrice() {
        return price;
    }

    public ArrayList<Building> getBuildings() {
        return buildings;
    }

    public ArrayList<Crop> getCrops() {
        return crops;
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    public void listBuildings() {
        for (Building building : buildings) {
            System.out.println(building);
        }
    }

    public void listCrops() {
        for (Crop crop : crops) {
            System.out.println(crop);
        }
    }

    public void listAnimals() {
        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }

    public void listSeeds() {
        for (Seeds seeds : seeds) {
            System.out.println(seeds);
        }
    }
//setters

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void AddBuilding(Building building) {
        this.buildings.add(building);
    }

    public void addCrop(Crop crop) {
        this.crops.add(crop);
    }

    public void addAnimal(Animal animal) {
        this.animals.add(animal);
    }

    public void addSeeds(Seeds seeds) {
        this.seeds.add(seeds);
    }

    public void setUsedHectares(Integer usedHectares) {
        this.usedHectares = usedHectares;
    }


}


