package org.generation.italy.capstoneProject.models.worldMap;

public class Room {

    private String name;
    private Room north, south, east, west;

    public Room(String n) {
        this.name = n;
    }

    // SET
    public void setNorth(Room nor) {
        this.north = nor;
    }
    public void setSouth(Room sou) {
        this.south = sou;
    }
    public void setEast(Room eas) {
        this.east = eas;
    }
    public void setWest(Room wes) {
        this.west = wes;
    }

    // GET
    public Room getNorth(Room nor) {
        return nor;
    }
    public Room getSouth(Room sou) {
        return sou;
    }
    public Room getEast(Room eas) {
        return eas;
    }
    public Room getWest(Room wes) {
        return wes;
    }

    public String getName() {
        return name;
    }
}
