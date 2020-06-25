package com.farming;

import java.util.ArrayList;

public class Player {

    private Integer cash;
    private Farm farm;
    private Game game;

    public Player() {
        this.cash  = 500000;
        this.farm = null;
        this.game = new Game(this);
    }

    public void displayCash() {
        System.out.println("Gracz posiada obecnie "+ cash + " PLN.");
    }

    //Getters
    public Integer getCash() {
        return cash;
    }
    public Integer getWeek(){
        return game.getWeek();
    }

    public Farm getFarm() {
        return farm;
    }

    public Game getGame() {
        return game;
    }

    //Setters
    public void setGame(Game game) {
        this.game = game;
    }
    public void setCash(Integer cash) {
        this.cash = cash;
    }

    public void setFarm(Farm farm) {
            this.farm = farm;

    }
}












