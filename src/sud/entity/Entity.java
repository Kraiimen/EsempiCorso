package sud.entity;

import java.util.Random;

public abstract class Entity {
    private String name;
    private int health;
    protected int maxHealth;
    protected boolean isAlive;
    protected int damage;

    public Entity(String name, int maxHealth, int damage) {
        this.name = name;
        this.health = maxHealth;
        this.maxHealth = maxHealth;
        this.isAlive = true;
        this.damage = damage;
    }

    public static int getRandomIntValue(int min, int max) {
        return new Random().nextInt(min, max);
    }

    public static double getRandomDoubleValue(int min, int max) {
        return new Random().nextDouble(min, max);
    }


    public boolean isAlive() {
        if (health <= 0) {
            return false;
        }
        return true;
    }

    public int getHealth() {
        return health;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void getDamaged(int damage) {
        health = Math.max(0, health - damage);
        printStats();
    }

    public void getHealed(int healAmount) {
        int healthBeforeHeal = health;
        health = Math.min(health + healAmount, maxHealth); //gives the minumum value between hp+healed hp and the maxHp
        System.out.println(name + " healed for " + healAmount + ".\n" +
                "HP: " + healthBeforeHeal + "/" + maxHealth + " -> " + health + "/" + maxHealth);
    }

    public void attack(Entity target) {
//        if (!isAlive()) {
//            throw new InvalidAttackException();
//        } else if (!target.isAlive()) {
//            System.out.println("Target is already dead");
//            return;
//        } else {
        System.out.println(name + " is attacking " + target.getName());
        target.getDamaged(damage);

        if (!target.isAlive) {
            System.out.println("You defeated " + target.getName());
        }
    }

    public void printStats() {
        System.out.println(name + "'s HP: " + health + "/" + maxHealth);
    }

    @Override
    public String toString() {
        return name.toString();
    }
}
