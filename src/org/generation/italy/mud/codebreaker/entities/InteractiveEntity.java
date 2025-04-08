package org.generation.italy.mud.codebreaker.entities;

import java.util.Random;

public class InteractiveEntity extends Entity {
    private String name;
    private int attack;
    private int defend;
    private int agility;
    private boolean isAlive;
    private Random random;


    public InteractiveEntity(String name,int maxHp, int attack, int defend, int agility){
        super(name,maxHp);
        this.attack = attack;
        this.defend = defend;
        this.agility = agility;
        isAlive = true;
    }
    public void takeDamage(InteractiveEntity target){
        int damage = target.attack * (100/(100 + defend ));

    }



    public int getAttack(){return attack;}
    public void setAttack(int attack){this.attack = attack;}
    public int getAgility(){return agility;}
    public void setAgility(int agility){this.agility = agility;}

    }
