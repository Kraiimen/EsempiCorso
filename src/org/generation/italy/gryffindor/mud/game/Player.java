package org.generation.italy.gryffindor.mud.game;

public class Player extends Entity{

    private String playerName;
    private long currentExpPoint;


    public String getPlayerName(){
        return playerName;
    }
    public void setPlayerName(String n){
        playerName = n;
    }
    public long getCurrentExpPoint(){
        return currentExpPoint;
    }
    public void setCurrentExpPoint(long exp){
        if (exp => 0){
        currentExpPoint = exp;
    }
}
