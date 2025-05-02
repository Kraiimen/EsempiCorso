package org.generation.italy.edenGame.entity.Enemies;

import org.generation.italy.edenGame.entity.Entity;

public class Monster extends Enemies{

    public Monster(String name, int maxHp, int healthPoints, int damage, int exp) {
        super(name, maxHp, healthPoints, damage, exp);
    }

    @Override
    public void dead() {
        System.out.println("Hai ucciso una Mostro! Hai guadagnato: +50 exp");
    }

    public void attack(Entity target) {
        int attackDamage = getDamage();
        target.setHealthPoints(target.getHealthPoints() - attackDamage);
        System.out.println("Il Mostro dei boschi " + getName() + " ti ha fatto " + attackDamage + " danni");
        if(target.getHealthPoints() <= 0) {
            target.dead();
        }
    }
}
