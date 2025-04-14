package sud.actors.npcs;

import sud.environment.rooms.Room;

public class Guard extends Npc{
    public Guard(String name) {
        super(name);
    }

    public Guard(String name, int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma) {
        super(name, strength, dexterity, constitution, intelligence, wisdom, charisma);
    }

    public Guard(String name, int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma, Room spawnPoint) {
        super(name, strength, dexterity, constitution, intelligence, wisdom, charisma, spawnPoint);
    }
}
