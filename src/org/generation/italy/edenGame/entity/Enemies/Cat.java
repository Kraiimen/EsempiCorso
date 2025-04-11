package org.generation.italy.edenGame.entity.Enemies;

import org.generation.italy.edenGame.entity.Entity;
import org.generation.italy.edenGame.room.Room;

import java.util.Random;

public class Cat extends Enemies {

    public Cat(String name, int maxHp, int healthPoints, int damage, int exp) {
        super(name, maxHp, healthPoints, damage, exp);
    }

    @Override
    public void dead() {
        System.out.println("Hai ucciso un povero gattino e hai guadagnato alcuni punti exp" );
    }

    public void attack(Entity target) {
        int attackDamage = getDamage();
        target.setHealthPoints(target.getHealthPoints() - attackDamage);
        System.out.println("Il gatto " + getName() + " ti ha fatto " + attackDamage + " danni");
        if(target.getHealthPoints() <= 0) {
            target.dead();
        }
    }


}
