package sud.actors.npcs;

import sud.environment.rooms.Room;

public class Cat extends Npc{
    public Cat(String name) {
        super(name);
    }

    public Cat(String name, int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma) {
        super(name, strength, dexterity, constitution, intelligence, wisdom, charisma);
    }

    public Cat(String name, int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma, Room spawnPoint) {
        super(name, strength, dexterity, constitution, intelligence, wisdom, charisma, spawnPoint);
    }
}
