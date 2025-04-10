package capstoneproject.entity;

import java.util.Random;

public abstract class Entity {
    private String name;
    private int healthPoints;
    private int maxHealth;
    private int inventory;
    private int damage;
    private int maxDamage;
    protected Random random;

    public Entity(int maxHealth, int maxDamage) {
        this.name = name;
        this.healthPoints = healthPoints;
        this.maxHealth = maxHealth;
        this.inventory = inventory;
        this.damage = damage;
        this.maxDamage = maxDamage;
        this.random = new Random();
    }

//    public void printStats(){
//        System.out.println("Name: " + name);
//        System.out.println("Intelligence: " + intelligence);
//        System.out.println("Strength: " + strength);
//        System.out.println("Agility : " + agility);
//        System.out.println("Stamina: " + stamina);
//        System.out.println("Health: " + healthpoint + "/" + maxHealth);
//    }
     public int takeDamage(int damage){
        healthPoints -= damage;
        if(healthPoints < 0) healthPoints = 0;
        return healthPoints;
     }

     public void heal(int amount){
        healthPoints += amount;
        if(healthPoints > maxHealth) healthPoints = maxHealth;
     }

     public boolean isDead(){
        return healthPoints <= 0;
     }

     abstract void attack(Entity target);


     public void addHealthPoints(int hp) {
         healthPoints += hp;
    }
     public void subtractHealthPoints(int hp){
        healthPoints -= hp;
    }

    public int healMissingPercent(double healPercent){
        if(isFullyHealed()){
            return getMaxHealth();
        }
        double heal = getMissingHp() * healPercent;
        healthPoints += (int)heal;
        return healthPoints;
    }

    public boolean isFullyHealed(){
        return getHealthPoints() == getMaxHealth();
    };


     public int getMissingHp(){
         return maxHealth - healthPoints;
     }

    public int getHealthPoints() {
        return healthPoints;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getDamage() {
        return damage;
    }

    public int getMaxDamage() {
        return maxDamage;
    }
}
