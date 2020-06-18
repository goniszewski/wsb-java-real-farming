package com.farming;

public class Farm {
    private String name;
    private Integer price;
    private Building[] buildings;
    private Crop[] crops;
    private Animal[] animals;
    private Ground[] grounds;

//getters
    public Building[] getBuildings() {
        return buildings;
    }

    public Crop[] getCrops() {
        return crops;
    }

    public Animal[] getAnimals() {
        return animals;
    }

    public Ground[] getGrounds() {
        return grounds;
    }
//setters

    public void setBuildings(Building[] buildings) {
        this.buildings = buildings;
    }

    public void setCrops(Crop[] crops) {
        this.crops = crops;
    }

    public void setAnimals(Animal[] animals) {
        this.animals = animals;
    }

    public void setGrounds(Ground[] grounds) {
        this.grounds = grounds;
    }
}
