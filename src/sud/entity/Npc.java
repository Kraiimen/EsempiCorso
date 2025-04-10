package sud.entity;

import sud.rooms.Room;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Npc extends Entity{
    private NpcState stato;
    private boolean canInteract;
    public static Map<String, Npc> npcMap = new HashMap<>();
    static {
        Npc debugNPC = new Npc("deb",100000,0,Room.getRoomPointerFromName("debugroom"),0,NpcState.PASSIVE,false);
        npcMap.put("deb", debugNPC);
        Npc king = new Npc("The King", 100000000,0, Room.getRoomPointerFromName("castle"), 0, NpcState.PASSIVE, true);
        npcMap.put("King", king);
        Npc kingsGuard = new Npc("The Guard", 50,15, Room.getRoomPointerFromName("castle"), 0, NpcState.NEUTRAL, false);
        npcMap.put("Kings Guard", kingsGuard);
        Npc tQGuard = new Npc("The Guard", 50,15, Room.getRoomPointerFromName("templeSquare"), 0, NpcState.NEUTRAL, false);
        npcMap.put("TQ Guard", tQGuard);
        Npc mQGuard = new Npc("The Guard", 50,15, Room.getRoomPointerFromName("market"), 0, NpcState.NEUTRAL, false);
        npcMap.put("MQ Guard", mQGuard);
        Npc cleric = new Npc("The Cleric", 50,15, Room.getRoomPointerFromName("temple"), 0, NpcState.PASSIVE, true);
        npcMap.put("Cleric", cleric);
        Npc blackSmithAssistant = new Npc("The Assistant", 10000000,0, Room.getRoomPointerFromName("forge"), 0, NpcState.PASSIVE, true);
        npcMap.put("Assistant", blackSmithAssistant);
        Npc alchemist = new Npc("The Alchemist", 10000000,0, Room.getRoomPointerFromName("alchemist"), 0, NpcState.PASSIVE, true);
        npcMap.put("Alchemist", alchemist);
        Npc tavernKeeper = new Npc("The Tavern Keeper", 10000000,0, Room.getRoomPointerFromName("tavern"), 0, NpcState.PASSIVE, true);
        npcMap.put("TavernK", tavernKeeper);
        Npc baker = new Npc("The Baker", 10000000,0, Room.getRoomPointerFromName("bakery"), 0, NpcState.PASSIVE, true);
        npcMap.put("Baker", baker);
    }
    public Npc(String name, int maxHp, int attackDamage, Room currentroom, int xpOnDeath, NpcState stato, boolean canInteract) {
        super(name, maxHp, attackDamage, currentroom, xpOnDeath);
        this.stato = stato;
        this.canInteract = canInteract;
        this.asignColor();
    }

    public void asignColor (){
        if(stato == NpcState.PASSIVE){this.setEntityColor(colorG);}if(stato == NpcState.NEUTRAL){this.setEntityColor(colorY);}if (stato == NpcState.AGGRESSIVE){this.setEntityColor(colorR);}
    }

    public NpcState getStato() {
        return stato;
    }

    public void setStato(NpcState stato) {
        this.stato = stato;
    }

    public boolean isCanInteract() {
        return canInteract;
    }

    public void setCanInteract(boolean canInteract) {
        this.canInteract = canInteract;
    }

    public static Map<String, Npc> getNpcMap() {
        return npcMap;
    }
}
