package com.farming;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private Integer week = 0;
    private Player player;
    private ArrayList<Farm> farms = new ArrayList<>();
    private ArrayList<Building> buildings = new ArrayList<>();
    private String choice = "";


    public Game(Player player) {
        this.week = 0;
        this.player = player;
    }

    //getters
    public Integer getWeek() {
        return week;
    }

    public String getChoice() {
        return choice;
    }

    public ArrayList<Farm> getFarms() {
        return farms;
    }

    //setters
    public void setWeek(Integer week) {
        this.week = week;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }

    public void setFarms(Farm farm) {
        this.farms.add(farm);
    }

    public void nextWeek() {
        setWeek(week++);
        Integer weeklyExpenses = 0;
        Integer foodEaten = 0;
        for (Crop crop : player.getFarm().getCrops()) {
            weeklyExpenses += crop.getProtectionCost();
        }
    }

    public void startGame() {
        setWeek(0);
        player.setCash(500000);
        player.setFarm(null);
        farms = new ArrayList<>();
        buildings = new ArrayList<>();

        for (int i=0; i < 5; i++) {
            this.farms.add(generateFarm(randInt(0,1),randInt(0,1)));
        }
        for (int i=0; i<5;i++) {
            this.buildings.add(generateBuilding("obora"));
            this.buildings.add(generateBuilding("stodoła"));
        }
    }

    public void showMenu() {
        System.out.println("\n\n" + "-".repeat(20));
        System.out.println("Tydzień " + this.week + ", PLN: " + this.player.getCash() + "\n");
        if (this.week > 0) {
            System.out.println("1. Kolejny tydzień");
        } else {
            System.out.println("1. Nowa gra");
        }
        if (this.player.getFarm() != null) {
            System.out.println("2. Informacje o farmie");
            System.out.println("3. Pokaż posiadane warzywa/owoce");
            System.out.println("4. Pokaż posiadane zwierzęta");
            System.out.println("0. Zakończ grę i rozpocznij nową");
        } else {
            System.out.println("2. Kup farmę");
            System.out.println("Aby kupić sadzonki potrzebujesz farmy");
            System.out.println("Aby kupić zwierzęta potrzebujesz farmy");
        }
        System.out.println("-".repeat(20) + "\n");
        Scanner scanner = new Scanner(System.in);
        this.choice = scanner.nextLine();
        choiceSelector(choice);
    }

    public void choiceSelector(String selectedChoice) {
        switch (selectedChoice) {
            case "1":
                if (week > 0) {
                    nextWeek();
                } else {
                    startGame();
                }
                showMenu();
            case "2":
                if (this.player.getFarm() != null) {
                    System.out.println(player.getFarm().toString());
                } else {
                    int farmNo = 1;
                    System.out.println("\nKtórą farmę chcesz kupić?\n");
                    for (Farm farm: farms) {
                        System.out.println(farmNo+ ". " + ((farm.toString() == null)? "Brak farmy.": farm.toString()));
                        farmNo++;
                    }
                }
                showMenu();
            case "3":
                //logic for buying / showing veggies and fruits
                showMenu();
            case "4":
                //logic for buying / showing animals
                showMenu();
            case "0":
                startGame();
                showMenu();
            default:
                System.out.println("Nieprawidłowa opcja, spróbuj jeszcze raz.");
                showMenu();
        }
    }

    private static Integer randInt(Integer min, Integer max) {
        return new Random().nextInt((max - min) + 1) + min;
    }

    public Building generateBuilding(String type) {
        int canHoldA = 0;
        int canHoldS = 0;
        if (type.equals("obora")) {
            canHoldA = randInt(5, 50);
        } else if (type.equals("stodoła")) {
            canHoldS = randInt(1, 5);
            canHoldS *= 10000;
        }
        Integer thisPrice = canHoldA + canHoldS/10000 * 5000;
        return new Building(type, canHoldA, canHoldS, thisPrice);
    }

    public Farm generateFarm(Integer buildingsForAnimals, Integer buildingsForSeeds) {
        ArrayList<Building> thisBuildings = new ArrayList<>();
        for (int i = 0; i <= buildingsForAnimals; i++) {
            thisBuildings.add(generateBuilding("obora"));
        }
        for (int i = 0; i <= buildingsForSeeds; i++) {
            thisBuildings.add(generateBuilding("stodoła"));
        }
        Integer hectares = randInt(3, 10);
        Integer thisPrice = 0;
        thisPrice += hectares * 20000;
        for (Building building : thisBuildings) {
            thisPrice += building.getPrice();
        }
        return new Farm(thisPrice, thisBuildings, hectares);
    }



}
