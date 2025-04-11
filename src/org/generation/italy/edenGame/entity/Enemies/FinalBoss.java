package org.generation.italy.edenGame.entity.Enemies;

import org.generation.italy.edenGame.entity.Entity;

public class FinalBoss extends Enemies{
    public FinalBoss(String name, int maxHp, int healthPoints, int damage, int exp) {
        super(name, maxHp, healthPoints, damage, exp);
    }
    @Override
    public void dead() {
        System.out.println("CONGRATULAZIONI, HAI SALVATO EDEN CITY DA RICCORCRUX!");
        System.out.println(" ");
        System.out.println("ORA HAI L'ANELLO SACRO DI EDEN");
    }

    public void attack(Entity target) {
        int attackDamage = getDamage();
        target.setHealthPoints(target.getHealthPoints() - attackDamage);
        System.out.println("Il GRANDE MOSTRO " + getName() + " ti ha fatto " + attackDamage + " danni");
        if(target.getHealthPoints() <= 0) {
            target.dead();
            System.exit(0);
        }
    }
}
