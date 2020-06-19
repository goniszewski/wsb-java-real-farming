package com.farming;

import java.util.Scanner;

public class Game {
    private Integer week = 0;
    private Player player;
    private String choice;

    //getters
    public Integer getWeek() {
        return week;
    }
    public String getChoice() {
        return choice;
    }
    //setters
    public void setWeek(Integer week) {
        this.week = week;
    }
    public void setChoice(String choice) {
        this.choice = choice;
    }

    public void nextWeek(){
        setWeek(week++);
    }
    public void resetGame(){
        setWeek(0);
    }
    public void showMenu(){
        System.out.println("\n\n" + "-".repeat(20));
        System.out.println("Tydzień " + this.week + ", PLN: " + this.player.getCash() + "\n");
        if (this.week>0) {
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
        Scanner scanner = new Scanner(System.in);
        this.choice = scanner.nextLine();
        choiceSelector(choice);


    }

    public void choiceSelector(String selectedChoice) {
        switch(selectedChoice) {
            case "1":
if(week > 0 ) {
    nextWeek();
} else {
    resetGame();
}
                break;
            case "2":
                //logic for buying a farm / showing farm
                break;
            case "3":
                //logic for buying / showing veggies and fruits
                break;
            case "4":
                //logic for buying / showing animals
                break;
            case "0":

        }
    }




}
