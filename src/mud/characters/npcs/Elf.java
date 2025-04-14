package mud.characters.npcs;

import mud.characters.Entity;
import mud.items.Item;
import mud.rooms.MagicMap;
import mud.rooms.Room;

import static mud.GameUtil.*;
import static mud.characters.fightable.Character.dice;

public class Elf extends Entity {
    public static final int ELF_POSSIBLE_ROOM = 8;

    public Elf(String name, String greetMessage) {
        super(name);
        setGreetMessage(greetMessage);
        setActualRoom(MagicMap.getRooms().get(dice.nextInt(ELF_POSSIBLE_ROOM)));
    }
    public Elf(String name, String greetMessage, Room startingRoom, Item item) {
        this(name, greetMessage);
        getActualRoom().getPresentEntities().remove(this.getName());
        setActualRoom(startingRoom);
        getInventory().put(item.getName(), item);
    }


}
