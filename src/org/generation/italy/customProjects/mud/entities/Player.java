package org.generation.italy.customProjects.mud.entities;

import org.generation.italy.customProjects.mud.world.Place;

import java.util.HashMap;

public abstract class Player extends Entity {
    //   /-----/-VARIABLES-/-----/
    private String playerName;
    private HashMap<String, String> login;
    private int exp;


    //   /-----/-CONSTRUCTORS-/-----/
    public Player(String name, int currentHealth, int maxHealthPoint, int attackDamage, int strength, int agility, int stamina, Place currentPosition, String playerName) {
        super(name, currentHealth, maxHealthPoint, attackDamage, strength, agility, stamina, currentPosition);
        this.playerName = playerName;
        this.exp = 0;
    }


    //   /-----/-METHODS-/-----/
//    public int attack() {
//    }
//    public int eat() {
//    }
//    public int sleep(){
//    }
//    public void speak(){
//    }



    //   /-----/-METHODS-/-GETTER-&-SETTER-/-----/
    public String getPlayerName() {
        return playerName;
    }
    public int getExp() {
        return exp;
    }
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
    public void setExp(int exp) {
        this.exp = exp;
    }

}
