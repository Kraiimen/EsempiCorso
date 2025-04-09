package mud.rooms;

import mud.CardinalPoints;
import mud.characters.Entity;
import mud.items.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class Room {
    //field
    private String name;
    private HashMap<CardinalPoints, Room> directions;
    private List<Entity> presentEntities;
    private List<Item> presentItems;

    //costruttore
    public Room(String name){
        this.name = name;
        directions = new HashMap<>();
        presentEntities = new ArrayList<>();
        presentItems = new ArrayList<>();
    }
    //costruttore per l'ultimo garden
    public Room(String name, Room lastRoom) {
        this(name);
        directions.put(CardinalPoints.SOUTH, lastRoom);
    }

    //funzioni principali
    public void beInRoom(Entity entity) {
        presentEntities.add(entity);
        entity.setActualRoom(this);
    }

    public void changeRoomNPC(CardinalPoints cardinal, Entity entity){
        if(directions.containsKey(cardinal)) {
            presentEntities.remove(entity);
            directions.get(cardinal).beInRoom(entity);
        }
    }

    public void changeRoomPlayer(CardinalPoints cardinal, Entity entity){
        if(directions.containsKey(cardinal)) {
            presentEntities.remove(entity);
            directions.get(cardinal).beInRoom(entity);
            printEntrance();
        } else {
            System.out.println("The road is closed. You're still at " + name);
        }
    }

    public abstract void addRandomNPC();

    public abstract void printEntrance();

    //getter e setter
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public HashMap<CardinalPoints, Room> getDirections() {
        return directions;
    }
    public void setDirections(HashMap<CardinalPoints, Room> directions) {
        this.directions = directions;
    }

    public List<Entity> getPresentCharacters() {
        return presentEntities;
    }
    public void setPresentCharacters(List<Entity> presentEntities) {
        this.presentEntities = presentEntities;
    }

    public List<Item> getPresentItems() {
        return presentItems;
    }
    public void setPresentItems(List<Item> presentItems) {
        this.presentItems = presentItems;
    }

}
