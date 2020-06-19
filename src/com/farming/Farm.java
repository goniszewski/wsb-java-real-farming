package com.farming;

public class Farm {
    private String name;
    private Integer price;
    private Building[] buildings;
    private Crop[] crops;
    private Animal[] animals;
    private Ground[] grounds;

//getters
    public Building getBuildings(int index) {
        return buildings[index];
    }
    public void listBuildings() {
        for (Building building : buildings) {
            System.out.println(building);
        }
    }
    public Crop getCrops(int index) {
        return crops[index];
    }
    public void listCrops() {
        for (Crop crop : crops) {
            System.out.println(crop);
        }
    }
    public Animal getAnimals(int index) {
        return animals[index];
    }
    public void listAnimals() {
        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }
    public Ground getGrounds(int index) {
        return grounds[index];
    }
    public void listGrounds(){
        for (Ground ground : grounds) {
            System.out.println(ground);
        }
    }
//setters
    public void setBuildings(Building building, int index) {
        this.buildings[index] = building;
    }
    public void setCrops(Crop crop, int index) {
        this.crops[index] = crop;
    }
    public void setAnimals(Animal animal, int index) {
        this.animals[index] = animal;
    }
    public void setGrounds(Ground ground, int index) {
        this.grounds[index] = ground;
    }
}
