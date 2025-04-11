package org.generation.italy.mud.codebreaker.entities;

import org.generation.italy.mud.codebreaker.inventory.Inventory;

public class Bitborne extends InteractiveEntity{
    private String className;
    private Inventory inventory = new Inventory();

    public Bitborne(String className, int stamina, int strenght, int agility, int intelligence) {
        this.className = className;
        super(stamina, strenght, agility, intelligence);
        setAttack(strenght * 2);
        setDefend(stamina * 2);
        setMaxHp(stamina * 2);
    }

    public void setClassName(String className){
        this.className = className;
    }

    }

