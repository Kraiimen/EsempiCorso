package rpgProject.model;

import java.util.Random;

public class Character implements Fighter {
    private Random random = new Random();
    private String name;
    private int health;
    private int level;
    protected String classType;
    private int attackPower;
    private int experience;

    // Constructor
    public Character(String name, int health, int level, String classType, int attackPower,int experience) {
        this.name = name;
        this.health = health;
        this.level = level;
        this.classType = classType;
        this.attackPower = attackPower;
        this.experience = experience;
    }
    public Character(String name,int health,int attackPower,String classType){
        this.name=name;
        this.health=health;
        this.attackPower=attackPower;
        this.classType=classType;
    }

    // Displays info
    public void displayInfo() {
        System.out.println("=== CHARACTER INFO ===");
        System.out.println("Name   : " + name);
        System.out.println("Class  : " + classType);
        System.out.println("Level  : " + level);
        System.out.println("Health : " + health);
        System.out.println("======================\n");
    }

    //Take damage while preventing hp to fall below 0 (chef's kiss)
    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) health = 0;
        System.out.println(name + " takes " + damage + " damage! Remaining health: " + health);
    }

    // Heals
    public void heal(int amount) {
        health += amount;
        System.out.println(name + " heals for " + amount + " points. New health: " + health);
    }
    public void levelUp(){
        level++;
        health+= 10;
        attackPower+= 5;
        experience = 0;
        System.out.println(name + " has leveled up to Level " + level + "!");
        System.out.println("Health increased to: " + health);
        System.out.println("Attack Power increased to: " + attackPower);
    }
    public void levelUpManage() {
        while (experience >= level * 10) {
            experience -= level * 10;
            levelUp();
        }
    }
    // Basic attack
    public void attack(Character target){
        int damage = random.nextInt(attackPower) + 1;
        System.out.println(name + " attacks " + target.getName() + " for " + damage + " damage!");
        target.takeDamage(damage);
        if(target.getHealth()<=0) {
            int expGained = (random.nextInt(getLevel()) * 3) + 5;
            experience += expGained;
            System.out.println(getName() + " gained " + expGained+" xp!");
            levelUpManage();
        }

    }
    public void use(Consumable food) {
        if (food.getQuantity() <= 0) {
            System.out.println(food.getName() + " isn't available");
        } else {
            food.setQuantity(food.getQuantity() - 1);
            System.out.println(food.getName() + " consumed");
            heal(food.getEfficiency());
        }
    }

    @Override
    public void turnManage() {
        System.out.println(getName()+" attack");
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getLevel() {
        return level;
    }

    public String getClassType() {
        return classType;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }
}
