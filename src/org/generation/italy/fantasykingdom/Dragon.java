package org.generation.italy.fantasykingdom;

import java.util.Random;

public class Dragon extends Creature {

    public Dragon(String name, int health, int damage) {
        super(name, health, damage);
    }

    @Override
    public void specialAbility() {
        Random random = new Random();
        if (random.nextDouble(1) <= 0.3) {
            attackDamage *= 3;
        }
    }

    @Override
    public void attack(Fighter creatureToAttack) {
        specialAbility();
        System.out.println(name + " is attacking " + ((Creature) creatureToAttack).name);
    }
}
