package sud.actors.characters;

import sud.Die;
import sud.actors.Actor;
import sud.environment.rooms.Room;

public class Priest extends Actor {
    public Priest(String name) {
        super(name);
    }

    public Priest(String name, int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma) {
        super(name, strength, dexterity, constitution, intelligence, wisdom, charisma);
    }

    public Priest(String name, int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma, Room spawnPoint) {
        super(name, strength, dexterity, constitution, intelligence, wisdom, charisma, spawnPoint);
    }

    @Override
    public Die getConstitutionDice() {
        return null;
    }
}
