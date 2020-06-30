package com.farming;

public class Resource {
    String name;
    Integer quantity;
    Integer sellPriceByUnit;
    String unitToDisplay;

    public Resource(String name, Integer quantity, Integer sellPriceByUnit, String unitToDisplay) {
        this.name = name;
        this.quantity = quantity;
        this.sellPriceByUnit = sellPriceByUnit;
        this.unitToDisplay = unitToDisplay;
    }

    @Override
    public String toString() {
        return name +
                "\nilość: " + quantity + " l," +
                "\ncena /" + quantity +
                ": " + sellPriceByUnit +
                " zł\n";
    }
}
