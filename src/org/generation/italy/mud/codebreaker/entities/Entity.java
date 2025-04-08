package org.generation.italy.mud.codebreaker.entities;

public class Entity {
    private String name;
    private int maxHp;
    private int currentHealth;


    public Entity(String name, int maxHp){
        this.name = name;
        this.maxHp = maxHp;
        this.currentHealth = maxHp;
    }

    public int getCurrentHealth() {return currentHealth;}
    public void setCurrentHealth(int currentHealth){this.currentHealth = currentHealth;}
    public int getMaxHp(){return maxHp;}
    public void setMaxHp(int MaxHP){this.maxHp = maxHp;}
}
