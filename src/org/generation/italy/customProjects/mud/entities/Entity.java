package org.generation.italy.customProjects.mud.entities;

import org.generation.italy.customProjects.mud.engine.Position;
import org.generation.italy.customProjects.mud.world.Place;

import java.util.Random;

public abstract class Entity implements Position {

    //   /-----/STATE-/-----/
    private String name;
    private int currentHealth;
    private int maxHealthPoint;
    private int attackDamage;
    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;
    private Place currentPlace;
    private Random abilitiesDice;

    //   /-----/-CONSTRUCTORS-/-----/
    public Entity(String name, int currentHealth, int maxHealthPoint, Place currentPlace) {
        this.name = name;
        this.currentHealth = currentHealth;
        this.maxHealthPoint = maxHealthPoint;
        this.attackDamage = attackDamage;
        this.currentPlace = currentPlace;
        setStats();
    }

    //   /-----/-METHODS-/-----/
    public abstract void setStats();


    //   /-----/-METHODS-/-GETTER-&-SETTER-/-----/
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getCurrentHealth() {
        return currentHealth;
    }
    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }
    public int getMaxHealthPoint() {
        return maxHealthPoint;
    }
    public void setMaxHealthPoint(int maxHealthPoint) {
        this.maxHealthPoint = maxHealthPoint;
    }
    public int getAttackDamage() {
        return attackDamage;
    }
    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }
    public int getStrength() {
        return strength;
    }
    public void setStrength(int strength) {
        this.strength = strength;
    }
    public int getDexterity() {
        return dexterity;
    }
    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }
    public int getConstitution() {
        return constitution;
    }
    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }
    public int getIntelligence() {
        return intelligence;
    }
    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }
    public int getWisdom() {
        return wisdom;
    }
    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }
    public int getCharisma() {
        return charisma;
    }
    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }
    @Override
    public Place getCurrentPlace() {
        return currentPlace;
    }
    @Override
    public void setCurrentPlace(Place currentPlace) {
        this.currentPlace = currentPlace;
    }
}
