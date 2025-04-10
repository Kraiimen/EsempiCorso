package org.generation.italy.sudProject.map;

public class Room{
    // /--ATTRIBUTES--/
    private String roomName;
    private boolean nordDoor;
    private boolean sudDoor;
    private boolean estDoor;
    private boolean ovestDoor;

    // /--CONSTRUCTORS--/
    public Room(String roomName, boolean nordDoor, boolean sudDoor, boolean estDoor, boolean ovestDoor){
        this.roomName = roomName;
        this.nordDoor = nordDoor;
        this.sudDoor = sudDoor;
        this.estDoor = estDoor;
        this.ovestDoor = ovestDoor;
    }
}
