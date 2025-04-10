package org.generation.italy.edenGame.entity.player;

import org.generation.italy.edenGame.entity.Entity;
import org.generation.italy.edenGame.room.Room;
import org.generation.italy.edenGame.room.Temple;
import org.generation.italy.edenGame.room.Compass;

import java.util.HashMap;
import java.util.Map;


public abstract class Player extends Entity {

    private String playerName;
    private int intelligence;
    private int strength;
    private int agility;
    private int stamina;
    private Room currentRoom;

    public Player(String name, int maxHp, int healthPoints, int damage, int exp, Room currentRoom, String playerName, int intelligence, int strength, int agility, int stamina) {

        super(name, maxHp, healthPoints, damage, exp, currentRoom);
        this.playerName = playerName;
        this.intelligence = intelligence;
        this.strength = strength;
        this.agility = agility;
        this.stamina = stamina;

    }

    @Override
    public void dead(int exp) {
        System.out.println("sei morto");
        setExp(getExp() - 1);
        //@Todo controllare l'HashMap
        Map<Compass, String> directions = new HashMap<Compass, String>();
        Room temple = new Temple("Temple", directions);
        setCurrentRoom(temple);
    }
    @Override
    public void attack(Entity target) {
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }
}
