package org.generation.italy.edenGame.room;

import java.util.HashMap;
import java.util.Map;

public abstract class Room {
    private String name;
    private Map<Compass, Room> directions;
    //Todo guardie nella stanza, oggetti, mostri, npc. guardie potrebbe essere boolean e dipende dal dado

    public Room(String name,Map<Compass, Room> directions) {
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

    public abstract void getPossibleDirections();

    public String getName() {
        return name;
    }
}
