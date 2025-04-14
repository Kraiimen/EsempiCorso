package mud.characters.npcs;

import mud.characters.Entity;
import mud.characters.fightable.Priest;
import mud.items.Map;
import mud.items.Weapon;
import mud.rooms.MagicMap;

import javax.print.attribute.HashPrintJobAttributeSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NPCMap {

    static private List<Entity> npcs = new ArrayList<>();
    static {
        npcs.add(new Elf("Elrond", "There will soon be a time when us elves will return home...", MagicMap.getRooms().get(1), new Weapon("Short sword", 2), true));
        npcs.add(new Elf("Arwen", "I'm willing to give up my immortal life, just to live a mortal life with you...",
                MagicMap.getRooms().get(5), new Map("Map"), false));
        npcs.add(new Baker("Tom"));
        npcs.add(new Merchant("Isildur"));
        npcs.add(new Hobbit("Peregrin"));
        npcs.add(new Hobbit("Bilbo"));
        npcs.add(new Hobbit("Merry"));
        npcs.add(new Hobbit("Samwise"));
        npcs.add(new Elf("Schiarux", "Have you ever tried a Long Island Iced Tea?"));
        npcs.add(new Elf("Nicuz", "Let's go training, darling!"));
    }

    public static List<Entity> getNpcs() {
        return npcs;
    }
    public static void setNpcs(List<Entity> npcs) {
        NPCMap.npcs = npcs;
    }

}
