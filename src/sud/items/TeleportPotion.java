package sud.items;

import sud.entity.Entity;
import sud.rooms.Room;

import static sud.entity.Entity.resetColor;

public class TeleportPotion extends Potion{

    public TeleportPotion(int price, String name) {
        super(price, name);
    }

    public void tepelortToSafety(Entity drinker){
        drinker.setCurrentroom(Room.getRoomPointerFromName("temple"));
        System.out.printf(drinker.getEntityColor()+"%s drinks the %s, and he in a burst of light find's himself in the temple, away from danger"+ resetColor, drinker.getName(),this.getName());


    }
}
