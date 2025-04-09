package mud.characters.npcs;

import mud.characters.Entity;
import mud.rooms.MagicMap;

public class Merchant extends Entity {
    public Merchant(String name) {
        super(name);
        setActualRoom(MagicMap.getRooms().get(4));
    }
}
