package sud.items;

import sud.entity.Entity;
import sud.rooms.Room;

public class TeleportPotion extends Potion{

    public TeleportPotion(int price, ItemType type, String name) {
        super(price, type, name);
    }

    public void tepelortToSafety(Entity drinker){
        drinker.setCurrentroom(Room.getRoomPointerFromName("temple"));
    }
}
