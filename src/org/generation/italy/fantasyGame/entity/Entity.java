package org.generation.italy.fantasyGame.entity;

public class Entity{
    //ATTRIBUTI DELL'ISTANZA
    private String name;
    private int healthPoints;
    private int maxHp;

    public Entity(String name, int maxHp){
        this.name = name;
        this.maxHp = maxHp;
        healthPoints= this.maxHp;
    }

    public int sleep(){
        int missingHp = maxHp - healthPoints;
        double addHealth = missingHp * 0.2;
        healthPoints += (int)addHealth;
        return healthPoints;
    }
    public int eat(){
        int missingHp = maxHp - healthPoints;
        double addHealth = missingHp * 0.3;
        healthPoints += (int)addHealth;
        return healthPoints;
    }
    public void attack(String name){
        System.out.println(this.name + " attacca " + name);
    }
    public void addPoint(int points){
        healthPoints += points;
    }
    public void subPoint(int points){
        healthPoints -= points;
    }

    public int getHealthPoints() {
        return healthPoints;
    }
    public int getMaxHp(){
        return maxHp;
    }
    public String getName(){
        return name;
    }
}
