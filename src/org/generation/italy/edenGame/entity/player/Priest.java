package org.generation.italy.edenGame.entity.player;

import org.generation.italy.edenGame.entity.Entity;
import org.generation.italy.edenGame.room.Room;

import java.util.Random;

public class Priest extends Player{
    public Priest(String name, int maxHp, int healthPoints, int damage, int exp, Room currentRoom, String playerName, int intelligence, int strength, int agility, int stamina) {
        super(name, maxHp, healthPoints, damage, exp, currentRoom, playerName, intelligence, strength, agility, stamina);
    }

    @Override
    public void attack(Entity target) {
        Random dice = new Random();
        int attackDamage = getDamage() + getIntelligence() + dice.nextInt(getStamina() + 1);
        target.setHealthPoints(target.getHealthPoints() - attackDamage);
        System.out.println("Hai fatto " + attackDamage + "danni");
        if (target.getHealthPoints() <= 0) {
            target.dead();
            setExp(getExp() + target.getExp());

        }
    }
}
