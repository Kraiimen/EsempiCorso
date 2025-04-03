package org.generation.italy.fantasykingdom;

public class Wizard extends Creature {

    public Wizard(String name, int health, int damage) {
        super(name, health, damage);
    }

    @Override
    public void specialAbility() {
        health *= 1.3;
        System.out.println(name + " restored part of his health");
    }

    public void receiveAttack(int attackDamage) {
        health = -attackDamage;
    }
}
