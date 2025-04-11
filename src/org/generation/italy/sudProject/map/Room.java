package org.generation.italy.sudProject.map;

public class Room{
    // /--ATTRIBUTES--/
    private String roomName;
    private String roomDescription;

    private Room northRoom;
    private Room southRoom;
    private Room eastRoom;
    private Room westRoom;

    // /--CONSTRUCTORS--/
    public Room(String roomName){
        this.roomName = roomName;
    }
    //--METHODS--/
    public void setRooms(Room northRoom, Room southRoom, Room eastRoom, Room westRoom){
        this.northRoom = northRoom;
        this.southRoom = southRoom;
        this.eastRoom = eastRoom;
        this.westRoom = westRoom;
    }

    // /--GETTER-&-SETTER--/


    public String getRoomName() {
        return roomName;
    }

    public String getRoomDescription() {
        return roomDescription;
    }

    public Room getNorthRoom() {
        return northRoom;
    }

    public Room getSouthRoom() {
        return southRoom;
    }

    public Room getEastRoom() {
        return eastRoom;
    }

    public Room getWestRoom() {
        return westRoom;
    }

    public void setRoomDescription(String roomDescription) {
        this.roomDescription = roomDescription;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }
}
