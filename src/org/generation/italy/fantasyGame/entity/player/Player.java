package org.generation.italy.fantasyGame.entity.player;

import org.generation.italy.fantasyGame.entity.Entity;

public class Player extends Entity {
    private long exp;
    private String playerName;


    public Player(String name, int maxHp, int damage, String playerName){
        super(name, maxHp, damage);
    }
    public void logIn(){
        System.out.println(this.playerName + "Is logged in game");
    }
    public void logOut() {
        System.out.println(this.playerName + "Is logout");
    }
}
