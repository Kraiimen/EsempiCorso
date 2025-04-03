package org.generation.italy.fantasykingdom;

public class Knight extends Creature {
    int defence;

    public Knight(String name, int health, int damage, int defence) {
        super(name, health, damage);
        this.defence = defence;
    }

    @Override
    public void specialAbility() {
        System.out.println(name + " has faced your attack thanks to his defence power");
    }

    @Override
    public void receiveAttack(int attackDamage) {
        if (defence > attackDamage) {
            return;
        }
        health -= attackDamage - defence;
    }

}
