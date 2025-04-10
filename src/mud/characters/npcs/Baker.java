package mud.characters.npcs;

import mud.characters.Entity;
import mud.rooms.MagicMap;
import org.w3c.dom.ls.LSOutput;

public class Baker extends Entity {
//    private static final int BAKER_POSSIBLE_ROOM = 3;

    public Baker(String name) {
        super(name);
//        setActualRoom(MagicMap.getRooms().get(BAKER_POSSIBLE_ROOM));
    }

    @Override
    public void greet(){
        System.out.println(getName() + " says : Would you like some bread?");
    }

}
