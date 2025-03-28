package org.generation.italy.ravenClaw.mud.entity;


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

    public String getPlayerName(){return playerName;}
    public void setPlayerName(String playerName){this.playerName = playerName;}

    public Long getExp() {return exp;}
    public void setExp(Long exp) {this.exp = exp;}
}


