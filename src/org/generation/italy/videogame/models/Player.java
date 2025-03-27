package org.generation.italy.videogame.models;

public class Player extends Entity{
    private long playerEXP;
    private String playerName;

    public Player(String playerName, String entityName, int hpValue){
        super()
    }

    public void logIn(){
        System.out.println(playerName + " connected!");
    }

    public void logOut(){
        System.out.println(playerName + " disconnected :(");
    }
}

