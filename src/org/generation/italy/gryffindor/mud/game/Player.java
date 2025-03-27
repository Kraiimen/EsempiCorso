package org.generation.italy.gryffindor.mud.game;

public class Player extends Entity{

    private String playerName;
    private long currentExpPoint;


    public Player(String playerName, String name, int maxHealthPoint){
        super(name, maxHealthPoint);
        this.playerName = playerName;
        currentExpPoint = 0;
    }



    public void login(){
        System.out.println("sto facendo il login");
    }
    public void logout(){
        System.out.println("sto facendo il logout");
    }





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
        if (exp >= 0) {
            currentExpPoint = exp;
        }
    }

}
