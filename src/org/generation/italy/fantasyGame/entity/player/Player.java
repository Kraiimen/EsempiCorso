package org.generation.italy.fantasyGame.entity.player;


import org.generation.italy.fantasyGame.entity.Entity1;

public abstract class Player extends Entity1 {
    private long exp;
    private String playerName;


    public Player(String name, int maxHp, int damage, String playerName, long exp){
        super(name, maxHp, damage);
        this.playerName = playerName;
        this.exp = exp;
    }
    public void logIn(){
        System.out.println(this.playerName + "Is logged in game");
    }
    public void logOut() {
        System.out.println(this.playerName + "Is logout");
    }
}
