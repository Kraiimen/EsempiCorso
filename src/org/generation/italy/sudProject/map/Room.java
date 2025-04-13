package org.generation.italy.sudProject.map;

import org.generation.italy.sudProject.Entity;
import org.generation.italy.sudProject.itemManagement.Inventory;

import java.util.ArrayList;

public class Room{
    // /--ATTRIBUTES--/
    private String roomName;
    private String roomDescription;

    private Room northRoom;
    private Room southRoom;
    private Room eastRoom;
    private Room westRoom;

    public static final int PLAYER_INDEX = -1;
    public static final int CAT_INDEX = 0;
    public static final int GUARD_INDEX = 1;
    public static final int CULTIST_INDEX = 2;
    public static final int ROOM_MAIN_NPC_INDEX = 3;

    private int maxGuardsInRoom;
    private Inventory roomObjects = new Inventory(20);

    private ArrayList<ArrayList> roomEntities;

    // /--CONSTRUCTORS--/
    public Room(String roomName, int maxGuardsInRoom){
        this.roomName = roomName;
        addEntityType(3);
        this.maxGuardsInRoom = maxGuardsInRoom;
    }
    // /--METHODS--/
    public void setRooms(Room northRoom, Room southRoom, Room eastRoom, Room westRoom){
        this.northRoom = northRoom;
        this.southRoom = southRoom;
        this.eastRoom = eastRoom;
        this.westRoom = westRoom;
    }


    private void addEntityType(int numOfGameEntities){
        for(int i=0; i<numOfGameEntities; i++){
            roomEntities.add(new ArrayList<Entity>());
        }
    }

    public void showEntitiesInRoom(){
        System.out.println("Entità del luogo: ");
        for(ArrayList a : roomEntities){
            if(a!=null){
                for(Object object : a){
                    Entity entity = (Entity) object;
                    System.out.print((entity.getName())+" ");
                }
                System.out.println();
            }
        }
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

    public ArrayList<ArrayList> getRoomEntities() {
        return roomEntities;
    }

    public int getMaxGuardsInRoom() {
        return maxGuardsInRoom;
    }
}
