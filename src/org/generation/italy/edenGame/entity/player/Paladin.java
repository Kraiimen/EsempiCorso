package org.generation.italy.edenGame.entity.player;

import org.generation.italy.edenGame.room.Room;

public class Paladin extends Player{
    public Paladin(String name, int maxHp, int healthPoints, int damage, int exp, Room currentRoom, String playerName, int intelligence, int strength, int agility, int stamina) {
        super(name, maxHp, healthPoints, damage, exp, currentRoom, playerName, intelligence, strength, agility, stamina);
    }
}
