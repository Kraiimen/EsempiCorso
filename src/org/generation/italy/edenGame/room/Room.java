package org.generation.italy.edenGame.room;

import org.generation.italy.edenGame.entity.Enemies.Enemies;
import org.generation.italy.edenGame.entity.npc.Npc;

import java.util.HashMap;
import java.util.Map;

public abstract class Room {
    private String name;
    private boolean checkEnemies = true;
    private Map<Compass, Room> directions;
    private Enemies enemy;
    private Npc npc;

    private Room currentRoom;

    public Room(String name, Map<Compass, String> directions) {
        this.name = name;
        this.directions = new HashMap<>();
    }



    public abstract void printDescription();

    public abstract void getPossibleActions();

    public Enemies getEnemy() {
        return enemy;
    }

    public Npc getNpc() {
        return npc;
    }

    public Room getDirection(Compass dir) {
        return directions.get(dir);
    }

    public String getNameRoom() {
        return name;
    }

    public boolean isCheckEnemies() {
        return checkEnemies;
    }

    public void setDirections(Compass dir, Room nextRoom){
        directions.put(dir,nextRoom);
    }

    public void setCheckEnemies(boolean checkEnemies) {
        this.checkEnemies = checkEnemies;
    }

    public void setEnemy(Enemies enemy) {
        this.enemy = enemy;
        this.checkEnemies = true;
    }



}
