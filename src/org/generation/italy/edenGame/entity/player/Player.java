package org.generation.italy.edenGame.entity.player;

import org.generation.italy.edenGame.entity.Entity;

import javax.naming.directory.InvalidAttributesException;

public abstract class Player extends Entity {

    private String playerName;
    private int intelligence;
    private int strength;
    private int agility;
    private int stamina;

    public Player(String name, int maxHp, int healthPoints, int damage, int exp, String playerName, int intelligence, int strength, int agility, int stamina) {

        super(name, maxHp, healthPoints, damage, exp);
        this.playerName = playerName;
        this.intelligence = intelligence;
        this.strength = strength;
        this.agility = agility;
        this.stamina = stamina;

    }

    public void dead(int exp) {
        System.out.println("sei morto");
        getExp();
        //@Todo telestrasporto a Temple per rinascere
    }

}
