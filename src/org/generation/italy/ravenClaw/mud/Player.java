package org.generation.italy.ravenClaw.mud;

public class Player extends Entity{
    private String playerName;
    private Long exp;
    private boolean isOnLine;

    public Player(String name, int maxHp, int attackDamage, String playerName){
        super(name, maxHp, attackDamage);
        this.playerName = playerName;
    }
    public void changeStatus(){
        if(isOnLine){
            System.out.println("I'm logging out");
            isOnLine = false;
        }else{
            System.out.println("I'm logging in");
            isOnLine = true;
        }


    }



}


