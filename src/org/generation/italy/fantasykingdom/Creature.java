package org.generation.italy.fantasykingdom;

public abstract class Creature implements Fighter {
    String name;
    int health;
    int attackDamage;

    public Creature(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.attackDamage = damage;
    }

    public abstract void specialAbility();

    @Override
    public void attack(Fighter target) throws InvalidAttackException {
        if (!isAlive()) {
            throw new InvalidAttackException();
        } else if (!target.isAlive()) {
            System.out.println("Target is already dead");
            return;
        }

        System.out.println(name + " is attacking " + ((Creature) target).name);
        target.receiveAttack(attackDamage);
    }

    @Override
    public boolean isAlive() {
        if (health <= 0) {
            return false;
        }
        return true;
    }

    @Override
    public void receiveAttack(int attackDamage) {
        health -= attackDamage;
        if (health <= 0) {
            health = 0;
            System.out.println(name + " is dead. Good job!");
        }
        System.out.println(name + " hp:" + health);
    }
}
