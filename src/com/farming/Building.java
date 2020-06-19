package com.farming;

public class Building {

    private String name;
    private String type;
    private Integer canHold;
    private Integer nowHolds;
    private Integer price;
    private Integer costPerWeek;


//getters
    public String getName() {
        return name;
    }
    public String getType() {
        return type;
    }
    public Integer getCanHold() {
        return canHold;
    }
    public Integer getNowHolds() {
        return nowHolds;
    }
    public Integer getPrice() {
        return price;
    }
    public Integer getCostPerWeek() {
        return costPerWeek;
    }

//setters
    public void setName(String name) {this.name = name; }
    public void setType(String type) {
        this.type = type;
    }
    public void setCanHold(Integer canHold) {
        this.canHold = canHold;
    }
    public void setNowHolds(Integer nowHolds) {
        this.nowHolds = nowHolds;
    }
    public void setPrice(Integer price) {
        this.price = price;
    }
    public void setCostPerWeek(Integer costPerWeek) {
        this.costPerWeek = costPerWeek;
    }
}