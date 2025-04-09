package org.generation.italy.edenGame.entity;

public abstract class Entity {
    private String name;
    private int maxHp;
    private int healthPoints;
    private int damage;
    private int exp;

    public Entity(String name, int maxHp, int healthPoints, int damage, int exp) {
        this.name = name;
        this.maxHp = maxHp;
        this.healthPoints = healthPoints;
        this.damage = damage;
        this.exp = exp;
    }


    //METODI
    public abstract void attack(Entity target);
    public void addHealthPoints(int hp){
        healthPoints += hp;
    }
    public void subtractHealthPoints(int hp){
        healthPoints -= hp;
    }


    //GETTER E SETTER
    public String getName() {
        return name;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public int getDamage() {
        return damage;
    }

    public int getExp() {
        return exp;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }
}
