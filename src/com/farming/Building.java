package com.farming;

public class Building {

    private String name;
    private String type;
    private Object[] canHold;
    private Object[] nowHolds;
    private Integer price;
    private Integer costPerWeek;


//getters

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public Object[] getCanHold() {
        return canHold;
    }

    public Object[] getNowHolds() {
        return nowHolds;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getCostPerWeek() {
        return costPerWeek;
    }

//setters
    public void setName(String name) {
        this.name = name;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setCanHold(Object[] canHold) {
        this.canHold = canHold;
    }
    public void setNowHolds(Object[] nowHolds) {
        this.nowHolds = nowHolds;
    }
    public void setPrice(Integer price) {
        this.price = price;
    }
    public void setCostPerWeek(Integer costPerWeek) {
        this.costPerWeek = costPerWeek;
    }
}