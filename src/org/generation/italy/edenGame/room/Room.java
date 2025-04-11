package org.generation.italy.edenGame.room;

import java.util.HashMap;
import java.util.Map;

public abstract class Room {
    private String name;
    private Map<Compass, Room> directions;
    //Todo guardie nella stanza, oggetti, mostri, npc. guardie potrebbe essere boolean e dipende dal dado

    private Room currentRoom;

    public Room(String name, Map<Compass, String> directions) {
        this.name = name;
        this.directions = new HashMap<>();
    }



    public abstract void printDescription();

    public abstract void getPossibleActions();



    public Room getDirection(Compass dir) {
        return directions.get(dir);
    }

    public String getNameRoom() {
        return name;
    }

    public void setDirections(Compass dir, Room nextRoom){
        directions.put(dir,nextRoom);
    }

}
