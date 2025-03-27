package org.generation.italy.fantasyGame.entity.player;

import org.generation.italy.fantasyGame.entity.Entity;

public class Player extends Entity {
    private long exp = 0;
    private String namePlayer;


    public Player(String name, int maxHp, String namePlayer, int damage){
        super(name, maxHp, damage);
    }
    public void logIn(){
        System.out.println(this.namePlayer + "Is logged in game");
    }
    public void logOut() {
        System.out.println(this.namePlayer + "Is logout");
    }
}
