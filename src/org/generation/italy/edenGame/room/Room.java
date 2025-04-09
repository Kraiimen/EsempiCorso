package org.generation.italy.edenGame.room;

import java.util.HashMap;
import java.util.Map;

public abstract class Room {
    private String name;
    private Map<Compass, Room> directions;

    public Room(String name,Map<Compass, Room> directions) {
        this.name = name;
        this.directions = new HashMap<>();
    }

    public abstract void printDescription();

    public void setDirections(Compass dir, Room nextRoom){
        directions.put(dir,nextRoom);
    }

    public Room getDirections(Compass dir) {
        return directions.get(dir);
    }

    public abstract void getPossibleDirections();

    //METTI FUNZIONE CHE TI TELETRASPORTA SE MUORI

    public String getName() {
        return name;
    }
}
