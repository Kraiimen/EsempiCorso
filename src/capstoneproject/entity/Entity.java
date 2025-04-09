package capstoneproject.entity;

import java.util.Random;

public abstract class Entity {
    protected String name;
    protected int health;
    protected int maxHealth;
    protected int strength;
    protected int intelligence;
    protected int agility;
    protected int stamina;


    public Entity(String name) {
        this.name = name;
        this.health = maxHealth;
        this.maxHealth = 20 + stamina;
        this.strength = new Random().nextInt(21);
        this.intelligence = new Random().nextInt(21);
        this.agility = new Random().nextInt(21);
        this.stamina = stamina;
    }

    public void printStats(){
        System.out.println("Name: " + name);
        System.out.println("Intelligence: " + intelligence);
        System.out.println("Strength: " + strength);
        System.out.println("Agility : " + agility);
        System.out.println("Stamina: " + stamina);
        System.out.println("Health: " + health + "/" + maxHealth);
    }
     public void takeDamage(int damage){
        health -= damage;
        if(health < 0) health = 0;
     }

     public void heal(int amount){
        health += amount;
        if(health > maxHealth) health = maxHealth;
     }

     public boolean isAlive(){
        return health > 0;
     }
}
