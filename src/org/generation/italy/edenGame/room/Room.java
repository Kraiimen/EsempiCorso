package org.generation.italy.edenGame.room;

import org.generation.italy.edenGame.entity.Enemies.Enemies;
import org.generation.italy.edenGame.entity.npc.Npc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class Room {
    private String name;
    private boolean checkEnemies = true;
    private boolean checkSearch = true;
    private Map<Compass, Room> directions;
    private Enemies enemy;
    private Npc npc;
    private Set<String> possibleActions = new HashSet<>();

    private Room currentRoom;

    public Room(String name, Map<Compass, String> directions) {
        this.name = name;
        this.directions = new HashMap<>();
    }

    public void addAction(String action) {
        possibleActions.add(action);
    }
    public void getPossibleActions() {
    }
    public Set<String> returnPossibleActions() {
        return possibleActions;
    }
    public abstract void printDescription();

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

    public boolean getCheckEnemies() {
        return checkEnemies;
    }

    public boolean getCheckSearch() {
        return checkSearch;
    }

    public void setDirections(Compass dir, Room nextRoom){
        directions.put(dir,nextRoom);
    }

    public void setCheckEnemies(boolean checkEnemies) {
        this.checkEnemies = checkEnemies;
    }

    public void setCheckSearch(boolean checkSearch) {
        this.checkSearch = checkSearch;
    }

    public Map<Compass, Room> getDirections(){
        return directions;
    }

    public void setEnemy(Enemies enemy) {
        this.enemy = enemy;
        this.checkEnemies = true;
    }



}
