package org.generation.italy.edenGame.entity.player;

import org.generation.italy.edenGame.entity.Enemies.Enemies;
import org.generation.italy.edenGame.entity.Entity;
import org.generation.italy.edenGame.room.Room;
import org.generation.italy.edenGame.room.Temple;
import org.generation.italy.edenGame.room.Compass;

import java.util.HashMap;
import java.util.Map;


public class Player extends Entity {

    private String playerName;
    private int intelligence;
    private int strength;
    private int agility;
    private int stamina;
    private Room currentRoom;

    public Player(String name, int maxHp, int healthPoints, int damage, int exp, Room currentRoom, String playerName, int intelligence, int strength, int agility, int stamina) {

        super(name, maxHp, healthPoints, damage, exp);
        this.playerName = playerName;
        this.intelligence = intelligence;
        this.strength = strength;
        this.agility = agility;
        this.stamina = stamina;
        this.currentRoom = currentRoom;
    }

    @Override
    public void dead() {
        System.out.println("Sei morto");
        setExp(getExp() - 1);

    }

    @Override
    public void attack(Entity target) {
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getStrength() {
        return strength;
    }

    public int getAgility() {
        return agility;
    }

    public int getStamina() {
        return stamina;
    }


    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
        System.out.println("--------/ " + currentRoom.getNameRoom()  + " /--------");
        currentRoom.printDescription();
        currentRoom.setCheckEnemies(true);
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }
}
