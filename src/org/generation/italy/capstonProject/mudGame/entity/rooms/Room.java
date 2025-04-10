package org.generation.italy.capstonProject.mudGame.entity.rooms;

import org.generation.italy.capstonProject.mudGame.entity.Entity;
import org.generation.italy.capstonProject.mudGame.entity.items.Item;
import org.generation.italy.capstonProject.mudGame.entity.player.Player;

import java.util.*;

public class Room {
    private String name;
    private List<Item> items;
    private List<Entity> entities;
    private Room northRoom;
    private Room eastRoom;
    private Room southRoom;
    private Room westRoom;
    private boolean hasItems;
    private boolean hasEntities;
    private String description;
    private List<Direction> allowedDirections;
    private Map<Direction, Room> nextRooms;
//    private Map<Direction, Room> adjacentRooms = new EnumMap<>(Direction.class);

    private static Map<String, Room> gameMap = new HashMap();

    static{
        Room templeSquare = new Room("templeSquare");
        gameMap.put(templeSquare.getName(), templeSquare);
        Room temple = new Room("temple");
        gameMap.put(temple.getName(), temple);
        Room marketSquare = new Room("marketSquare");
        gameMap.put(marketSquare.getName(), marketSquare);
        Room bakery = new Room("bakery");
        gameMap.put(bakery.getName(), bakery);
        Room armory = new Room("armory");
        gameMap.put(armory.getName(), armory);
        Room gardenA = new Room("gardenA");
        gameMap.put(gardenA.getName(), gardenA);
        Room gardenB = new Room("gardenB");
        gameMap.put(gardenB.getName(), gardenB);
        Room gardenC = new Room("gardenC");
        gameMap.put(gardenC.getName(), gardenC);
        Room cityDoors = new Room("cityDoors");
        gameMap.put(cityDoors.getName(), cityDoors);
        Room woods1 = new Room("woods1");
        gameMap.put(woods1.getName(), woods1);

//        templeSquare.setOneDirection(temple, Direction.EAST);
//        templeSquare.setOneDirection(marketSquare, Direction.SOUTH);
        templeSquare.setDirections(null, temple, marketSquare, null);
        templeSquare.setRoomContents();
        temple.setOneDirection(templeSquare, Direction.WEST);
        temple.setRoomContents();
        marketSquare.setDirections(templeSquare, bakery, gardenA, armory);
        marketSquare.setRoomContents();
        armory.setOneDirection(marketSquare, Direction.WEST);
        marketSquare.setRoomContents();
        gardenA.setDirections(marketSquare, null, gardenB, null);
        gardenA.setRoomContents();
        gardenB.setDirections(gardenA, null, gardenC, null);
        gardenB.setRoomContents();
        gardenC.setDirections(gardenB, null, cityDoors, null);
        gardenC.setRoomContents();
        cityDoors.setDirections(gardenC, null, woods1, null);
        cityDoors.setRoomContents();
        woods1.setOneDirection(cityDoors, Direction.NORTH);
        woods1.setRoomContents();
    }

    public Room (String name){
        this.name = name;
        this.items = new ArrayList<>();
        this.entities = new ArrayList<>();
        this.allowedDirections = new ArrayList<>();
        this.nextRooms = new HashMap<>();
    }

    public Room (String name, Room northRoom, Room eastRoom, Room southRoom, Room westRoom, boolean hasItems, boolean hasEntities){
        this(name);
        this.northRoom = northRoom;
        this.eastRoom = eastRoom;
        this.southRoom = southRoom;
        this.westRoom = westRoom;
        this.hasItems = hasItems;
        this.hasEntities = hasEntities;
        if(northRoom != null){
            nextRooms.put(Direction.NORTH, northRoom);
            allowedDirections.add(Direction.NORTH);
        }
        if(eastRoom != null){
            nextRooms.put(Direction.EAST, eastRoom);
            allowedDirections.add(Direction.EAST);
        }
        if(southRoom != null){
            nextRooms.put(Direction.SOUTH, southRoom);
            allowedDirections.add(Direction.SOUTH);
        }
        if(westRoom != null){
            nextRooms.put(Direction.WEST, westRoom);
            allowedDirections.add(Direction.WEST);
        }
    }

    public void setOneDirection(Room roomName, Direction roomDirection){
        if(roomDirection == Direction.NORTH){
            northRoom = roomName;
            if (roomName != null) {
                nextRooms.put(Direction.NORTH, northRoom);
                allowedDirections.add(Direction.NORTH);
            }
        }
        if(roomDirection == Direction.EAST){
            eastRoom = roomName;
            if (roomName != null) {
                nextRooms.put(Direction.EAST, eastRoom);
                allowedDirections.add(Direction.EAST);
            }
        }
        if(roomDirection == Direction.SOUTH){
            southRoom = roomName;
            if (roomName != null) {
                nextRooms.put(Direction.SOUTH, southRoom);
                allowedDirections.add(Direction.SOUTH);
            }
        }
        if(roomDirection == Direction.WEST){
            westRoom = roomName;
            if (roomName != null) {
                nextRooms.put(Direction.WEST, westRoom);
                allowedDirections.add(Direction.WEST);
            }
        }
    }

    public void setDirections(Room northRoom, Room eastRoom, Room southRoom, Room westRoom){
        this.northRoom = northRoom;
        this.eastRoom = eastRoom;
        this.southRoom = southRoom;
        this.westRoom = westRoom;
        if(northRoom != null){
            nextRooms.put(Direction.NORTH, northRoom);
            allowedDirections.add(Direction.NORTH);
        }
        if(eastRoom != null){
            nextRooms.put(Direction.EAST, eastRoom);
            allowedDirections.add(Direction.EAST);
        }
        if(southRoom != null){
            nextRooms.put(Direction.SOUTH, southRoom);
            allowedDirections.add(Direction.SOUTH);
        }
        if(westRoom != null){
            nextRooms.put(Direction.WEST, westRoom);
            allowedDirections.add(Direction.WEST);
        }
    }

//    public void setAdjacentRoom(Direction direction, Room room) {
//        if (room != null) {
//            adjacentRooms.put(direction, room);
//            allowedDirections.add(direction);
//        }
//    }
//
//    public Room getAdjacentRoom(Direction direction) {
//        return adjacentRooms.get(direction);
//    }

    public void addEntityToRoom(Entity entity){
        entities.add(entity);
        if(!hasEntities){
            hasEntities = true;
        }
    }

    public void addItemToRoom(Item item){
        items.add(item);
        if(!hasItems){
            hasItems = true;
        }
    }

    public void removeEntityFromRoom(Entity entity){
        entities.remove(entity);
        if(entities.isEmpty()){
            hasEntities = false;
        }
    }

    public void removeItemFromRoom(Item item){
        items.remove(item);
        if(items.isEmpty()){
            hasItems = false;
        }
    }

    public void setRoomContents(){
        if(!items.isEmpty()){
            this.hasItems = true;
        } else {
            hasItems = false;
        }
        if(!entities.isEmpty()){
            this.hasEntities = true;
        } else {
            hasEntities = false;
        }
    }

    public void printDescription(){
        StringBuilder message = new StringBuilder("You are in the " + this.getName() + "!\n");

        if(hasEntities){
            message.append("In this room you can find " + entities.size() + " to interact with.\n").append(getEntities());
        }else{
            message.append("There is no one to interact with in here.\n");
        }

        if(hasItems){
            message.append("There is something on the ground, " + items.size() + " items free for you to pick.\n").append(getItems());
        }else{
            message.append("You can't find any items to pick in here.\n");
        }

        message.append("From this room you can go in " + allowedDirections.size() + " directions.");

        for(Direction d : allowedDirections){
            if(d == Direction.NORTH) {
                message.append("You can go ").append(d).append(", into the ").append(northRoom.getName());
            } else if(d == Direction.EAST) {
                message.append("You can go ").append(d).append(", into the ").append(eastRoom.getName());
            } else if(d == Direction.SOUTH) {
                message.append("You can go ").append(d).append(", into the ").append(southRoom.getName());
            } else if(d == Direction.WEST) {
                message.append("You can go ").append(d).append(", into the ").append(westRoom.getName());
            }
        }

        System.out.println(message);
    }

    public void playerHasEntered(Player player){
        printDescription();
        if(hasEntities){
            for(Entity entity : entities){
                entity.manageInteraction(player);
            }
        }
    }

    public String getName() {
        return name;
    }

    public List<Item> getItems() {
        return items;
    }

    public List<Entity> getEntities() {
        return entities;
    }

    public boolean isHasItems() {
        return hasItems;
    }

    public boolean isHasEntities() {
        return hasEntities;
    }

    public Room getNorthRoom() {
        return northRoom;
//        return adjacentRooms.get(Direction.NORTH);
    }

    public Room getEastRoom() {
        return eastRoom;
//        return adjacentRooms.get(Direction.EAST);
    }

    public Room getSouthRoom() {
        return southRoom;
//        return adjacentRooms.get(Direction.SOUTH);
    }

    public Room getWestRoom() {
        return westRoom;
//        return adjacentRooms.get(Direction.WEST);
    }

    public String getDescription() {
        return description;
    }

    public List<Direction> getAllowedDirections() {
        return allowedDirections;
    }

    public static Map<String, Room> getGameMap() {
        return gameMap;
    }

    public void setNorthRoom(Room northRoom) {
        this.northRoom = northRoom;
        nextRooms.put(Direction.NORTH, northRoom);
        allowedDirections.add(Direction.NORTH);
    }

    public void setEastRoom(Room eastRoom) {
        this.eastRoom = eastRoom;
        nextRooms.put(Direction.EAST, eastRoom);
        allowedDirections.add(Direction.EAST);
    }

    public void setSouthRoom(Room southRoom) {
        this.southRoom = southRoom;
        nextRooms.put(Direction.SOUTH, southRoom);
        allowedDirections.add(Direction.SOUTH);
    }

    public void setWestRoom(Room westRoom) {
        this.westRoom = westRoom;
        nextRooms.put(Direction.WEST, westRoom);
        allowedDirections.add(Direction.WEST);
    }

    public Map<Direction, Room> getNextRooms() {
        return nextRooms;
    }
}
