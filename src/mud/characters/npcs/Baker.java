package mud.characters.npcs;

import mud.characters.Entity;
import mud.rooms.MagicMap;
import org.w3c.dom.ls.LSOutput;

public class Baker extends Entity {

    public Baker(String name) {
        super(name);
        setActualRoom(MagicMap.getRooms().get(3));
    }

    @Override
    public void greet(){
        System.out.println(getName() + " says : Would you like some bread?");
    }

}
