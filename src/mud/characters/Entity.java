package mud.characters;

import mud.CardinalPoints;
import mud.characters.fightable.monsters.Monster;
import mud.items.Item;
import mud.rooms.MagicMap;
import mud.rooms.Room;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static mud.GameUtil.*;

public abstract class Entity {
    private static int lastId = 0;
    private int characterId;
    private String name;
    private HashMap<String, Item> inventory;
    private Room actualRoom;
//    private boolean hasQuest;

    public Entity(String name){
        this.name = name;
        inventory = new HashMap<>();
        lastId++;
        this.characterId = lastId;
    }

    public void greet(){
        System.out.println(name + " says :" + BLUE + " Hello!" + RESET);
        delay(800);
    }
    public void printInventory(){
        inventory.keySet().forEach(System.out::println);
    }

    public void pickItem(Item item){
        inventory.put(item.getName(), item);
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
        actualRoom.getPresentEntities().put(name, this);
        if(this instanceof Monster){
            Monster monster = (Monster)this;
            actualRoom.getPresentMonsters().add(monster);
        }
    }

    public HashMap<String, Item> getInventory() {
        return inventory;
    }
    public void setInventory(HashMap<String, Item> inventory) {
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

//    public boolean doesHaveQuest() {
//        return hasQuest;
//    }
//    public void setHasQuest(boolean hasQuest) {
//        this.hasQuest = hasQuest;
//    }
}
