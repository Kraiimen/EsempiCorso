package org.generation.italy.videogame.models;

public class Player extends Entity{
    private long playerEXP;
    private String playerName;

    // COSTRUTTORE
    public Player(String name, int maxHP, int hpValue, String playerName){
        super(name, maxHP, hpValue);
        this.playerName = playerName;
    }

    // Il giocatore fa il logIn
    public void logIn(){
        System.out.println(playerName + " connected!");
    }

    // Il giocatore fa il logOut
    public void logOut(){
        System.out.println(playerName + " disconnected :(");
    }

    // Getters
    public String getPlayerName(){
        return playerName;
    }
}

