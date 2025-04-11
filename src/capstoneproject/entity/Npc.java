package capstoneproject.entity;

import capstoneproject.rooms.Room;

import java.util.Map;

public abstract class Npc extends Entity{

    protected Map<String,String> npcWord;
    protected int intelligence;
    protected int stamina;
    protected int agility;
    protected int strength;
    protected boolean isRage;

    public Npc(String name, int maxHealth, int maxDamage, Room currentRoom) {
        super(name, maxHealth, maxDamage, currentRoom);
        inizialateStatsNpc();
        currentRoom.addToNpcList(this);

    }
    protected abstract void inizialateStatsNpc();

    public abstract void attack(Entity target);

}
