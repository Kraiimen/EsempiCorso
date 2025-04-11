package org.generation.italy.capstoneProject.models.worldMap;

public class Room {

    private String name;
    private Room north, south, east, west;

    public Room(String name) {
        this.name = name;
    }

    // SET
    public void setNorth(Room north) {
        this.north = north;
    }
    public void setSouth(Room south) {
        this.south = south;
    }
    public void setEast(Room east) {
        this.east = east;
    }
    public void setWest(Room west) {
        this.west = west;
    }

    // GET
    public Room getNorth() {
        return north;
    }
    public Room getSouth() {
        return south;
    }
    public Room getEast() {
        return east;
    }
    public Room getWest() {
        return west;
    }

    public String getName() {
        return name;
    }
}
