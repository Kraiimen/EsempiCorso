package mud.characters.npcs;

import mud.characters.Entity;
import mud.characters.fightable.Priest;
import mud.items.Weapon;
import mud.rooms.MagicMap;

import java.util.ArrayList;
import java.util.List;

public class NPCMap {

    static private List<Entity> npcs = new ArrayList<>();
    static {
        //baker e merchant li ho aggiunti direttamente nelle loro room
        npcs.add(new Baker("Tom"));
        npcs.add(new Merchant("Isildur"));
        npcs.add(new Hobbit("Peregrin"));
        npcs.add(new Hobbit("Bilbo"));
        npcs.add(new Hobbit("Merry"));
        npcs.add(new Hobbit("Samwise"));
        //Elrond deve stare al tempio e dare la spada al player la prima volta che parlano
        npcs.add(new Elf("Elrond",
                "How's the quest going, dear Adventurer? Remember, the faith of our realm lays in your brave hands...",
                MagicMap.getRooms().get(1), new Weapon("Sting the Short Sword")));
        npcs.add(new Elf("Arwen", "I'm willing to give up my immortal life, just to live a mortal life with you..."));
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
