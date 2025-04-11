package org.generation.italy.edenGame.entity.Enemies;

import org.generation.italy.edenGame.entity.Entity;

public class Goblin extends Enemies{
    public Goblin(String name, int maxHp, int healthPoints, int damage, int exp) {
        super(name, maxHp, healthPoints, damage, exp);
    }
    @Override
    public void dead() {
        System.out.println("Hai ucciso un Gobli, Hai guadagnato: +20 exp");
    }

    public void attack(Entity target) {
        int attackDamage = getDamage();
        target.setHealthPoints(target.getHealthPoints() - attackDamage);
        System.out.println("Il Goblin " + getName() + " ti ha fatto " + attackDamage + " danni");
        if(target.getHealthPoints() <= 0) {
            target.dead();
        }
    }
}
