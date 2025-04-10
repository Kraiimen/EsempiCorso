package org.generation.italy.customProjects.mud.entities;

import org.generation.italy.customProjects.mud.world.Place;

import java.util.Random;

public abstract class Entity {
    //   /-----/-VARIABLES-/-----/
    private String name;
    private int currentHealth;
    private int maxHealthPoint;
    private int attackDamage;
    private int strength;
    private int agility;
    private int stamina;
    private Place currentPosition;
    private Random abilitiesDice;

    //   /-----/-CONSTRUCTORS-/-----/
    public Entity(String name, int currentHealth, int maxHealthPoint, int attackDamage, int strength, int agility, int stamina, Place currentPosition) {
        this.name = name;
        this.currentHealth = currentHealth;
        this.maxHealthPoint = maxHealthPoint;
        this.attackDamage = attackDamage;
        this.strength = strength;
        this.agility = agility;
        this.stamina = stamina;
        this.currentPosition = currentPosition;
    }


    //   /-----/-METHODS-/-GETTER-&-SETTER-/-----/
    public String getName() {
        return name;
    }
    public int getCurrentHealth() {
        return currentHealth;
    }
    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }
    public Place getCurrentPosition() {
        return currentPosition;
    }
    public void setCurrentPosition(Place currentPosition) {
        this.currentPosition = currentPosition;
    }

}
