package mud.characters.npcs;

import mud.characters.Entity;

import java.util.ArrayList;
import java.util.List;

public class NPCMap {

    static private List<Entity> npcs = new ArrayList<>();
    static {
        npcs.add(new Baker("Tom Bombadil"));
        npcs.add(new Merchant("Lady Arwen"));
        npcs.add(new Civilian("Peregrin Tuc"));
        npcs.add(new Civilian("Bilbo Baggins"));
        npcs.add(new Civilian("Merry Brandibuck"));
    }
}
