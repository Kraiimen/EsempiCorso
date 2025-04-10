package org.generation.italy.sudProject.map;

public class Room{
    // /--ATTRIBUTES--/
    private String roomName;

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
}
