package mud.characters;

import mud.CardinalPoints;
import mud.items.Item;
import mud.rooms.Room;

import java.util.ArrayList;
import java.util.List;

public abstract class Entity {
    private static int lastId = 0;
    private int characterId;
    private String name;
    private List<Item> inventory;
    private Room actualRoom;

    public Entity(String name){
        this.name = name;
        inventory = new ArrayList<>();
        lastId++;
        this.characterId = lastId;
    }

    public void greet(){
        System.out.println(name + " says : Hello!");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Room getActualRoom() {
        return actualRoom;
    }
    public void setActualRoom(Room actualRoom) {
        this.actualRoom = actualRoom;
        actualRoom.getPresentEntities().add(this);
    }

    public List<Item> getInventory() {
        return inventory;
    }
    public void setInventory(List<Item> inventory) {
        this.inventory = inventory;
    }

    public int getCharacterId() {
        return characterId;
    }
    public void setCharacterId(int characterId) {
        this.characterId = characterId;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Entity){
            Entity ent = (Entity)obj;
            return this.characterId == ent.characterId;
        }
        return false;
    }
}
