package mud.characters;

import mud.CardinalPoints;
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

    public abstract void changeRoom(CardinalPoints cardinal);

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
