package org.generation.italy.edenGame.room;

import java.util.HashMap;
import java.util.Map;

public abstract class Room {
    private String name;
    private Map<Compass, Room> directions;
    //Todo guardie nella stanza, oggetti, mostri, npc. guardie potrebbe essere boolean e dipende dal dado

    //todo settare questi per le possibleDirections
    private Room currentRoom;
    private Room nextRoom;

    public Room(String name, Map<Compass, String> directions) {
        this.name = name;
        this.directions = new HashMap<>();
    }

    public abstract void printDescription();

    public void setDirections(Compass dir, Room nextRoom){
        directions.put(dir,nextRoom);
    }

    public Room getDirection(Compass dir) {
        return directions.get(dir);
    }

    //todo serve una nextRoom
//    public void getPossibleDirections(Map<Compass, Room> directions) {
//        if(directions. != null) {
//            this.directions = directions;
//            System.out.println("Le strade da qui portano a: " + directions);
//
//
//    }

    public String getNameRoom() {
        return name;
    }
}
