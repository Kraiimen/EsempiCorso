package org.generation.italy.sudProject.map;

import org.generation.italy.sudProject.Entity;
import org.generation.italy.sudProject.entities.mobs.Cat;
import org.generation.italy.sudProject.entities.npcTypes.Guard;

import java.util.ArrayList;

import static org.generation.italy.sudProject.Entity.dice;
import static org.generation.italy.sudProject.entities.npcTypes.Guard.deleteGuards;

public class Room{
    // /--ATTRIBUTES--/
    private String roomName;
    private String roomDescription;

    private Room northRoom;
    private Room southRoom;
    private Room eastRoom;
    private Room westRoom;

    private static final int CAT_INDEX = 0;
    private static final int GUARD_INDEX = 1;

    private ArrayList<ArrayList> roomEntities;

    // /--CONSTRUCTORS--/
    public Room(String roomName){
        this.roomName = roomName;
        addEntityType(2);
    }
    // /--METHODS--/
    public void setRooms(Room northRoom, Room southRoom, Room eastRoom, Room westRoom){
        this.northRoom = northRoom;
        this.southRoom = southRoom;
        this.eastRoom = eastRoom;
        this.westRoom = westRoom;
    }

    public void generateRoomEntities(int numOfCats, int numOfGuards){
        for(int i=0; i<numOfCats; i++){
            roomEntities.get(CAT_INDEX).add(new Cat("Cat", this));
        }
        for(int i=0; i<numOfGuards; i++){
            roomEntities.get(GUARD_INDEX).add(new Guard("Guard", this));
        }
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
    public void resetGuardsInRoom(){
        if(roomEntities.get(GUARD_INDEX) != null){
            int numGuards = (roomEntities.get(GUARD_INDEX).size());
            int randomNumber = dice.nextInt(numGuards+1);
            roomEntities.get(GUARD_INDEX).clear();
            deleteGuards(numGuards);
            for(int i=0; i<randomNumber; i++){
                roomEntities.get(GUARD_INDEX).add(new Guard("Guard", this));
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
}
