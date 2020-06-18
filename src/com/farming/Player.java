package com.farming;

public class Player {
    private String name;
    private Integer cash = 500000;

    public void buyBuilding(Building building, Integer index) {
        if (cash > building.getPrice()) {
            System.out.println("You just bought yourself a building!");
//            this.buildings[index] = building;
        }
    }


//Getters
    public String getName() {
        return name;
    }
    public Integer getCash() {
        return cash;
    }
//Setters
    public void setName(String name) {
        this.name = name;
    }
    public void setCash(Integer cash) {
        this.cash = cash;
    }

}












