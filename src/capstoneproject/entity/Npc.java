package capstoneproject.entity;

import capstoneproject.rooms.Room;

import java.util.Map;

public abstract class Npc extends Entity{

    protected String npcName;
    protected boolean isRage;
    Map<String,String> npcWord;

    public Npc(String name, int maxHealth, int maxDamage, Room currentRoom) {
        super(name, maxHealth, maxDamage, currentRoom);
        this.currentRoom = currentRoom;
        inizialateStats();
    }
    protected abstract void inizialateStats();

    abstract void attack(Entity target);

    public void heal(int amount){
        healthPoints += amount;
        if(healthPoints > maxHealth) healthPoints = maxHealth;
    }
}
