package mud.characters;

import mud.items.Item;
import mud.rooms.Room;

import java.util.ArrayList;
import java.util.List;

public abstract class Entity {
    private List<Item> inventory;
    private Room actualRoom;

    public Entity(){
        inventory = new ArrayList<>();
    }

    public Room getActualRoom() {
        return actualRoom;
    }

    public void setActualRoom(Room actualRoom) {
        this.actualRoom = actualRoom;
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public void setInventory(List<Item> inventory) {
        this.inventory = inventory;
    }
}
