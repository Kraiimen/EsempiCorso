package org.generation.italy.edenGame.entity.Enemies;

import org.generation.italy.edenGame.entity.Entity;
import org.generation.italy.edenGame.room.Room;

import java.util.Random;

public class Guards extends Enemies{
    public Guards(String name, int maxHp, int healthPoints, int damage, int exp) {
        super(name, maxHp, healthPoints, damage, exp);
    }

    @Override
    public void dead() {
        Random dice = new Random();
        System.out.println("Hai ucciso una guardia reale e hai guadagnato: +10 exp");
        int chanceOfItem = dice.nextInt(100);
        if (chanceOfItem > 80) {

        }

    }

    public void attack(Entity target) {

        int attackDamage = getDamage();
        target.setHealthPoints(target.getHealthPoints() - attackDamage);
        System.out.println("La guardia reale " + getName() + " ti ha fatto " + attackDamage + " danni");
        if(target.getHealthPoints() <= 0) {
            target.dead();
        }
    }
}
